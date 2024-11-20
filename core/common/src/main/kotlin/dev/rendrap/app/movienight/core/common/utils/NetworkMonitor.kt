package dev.rendrap.app.movienight.core.common.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import androidx.core.content.getSystemService
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.rendrap.app.movienight.core.common.di.IODispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

interface NetworkMonitor {
    val isConnected: Flow<Boolean>
}

/**
 * A singleton class that monitors the network connectivity status.
 * It uses the [ConnectivityManager] to register a [ConnectivityManager.NetworkCallback] and listens for network availability changes.
 *
 * @param context The application context to get the system service.
 * @param ioDispatcher The coroutine dispatcher for IO operations.
 */
@Singleton
class NetworkMonitorImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    @IODispatcher private val ioDispatcher: CoroutineDispatcher,
) : NetworkMonitor {

    /**
     * A flow that emits the current network connectivity status.
     * It uses a [callbackFlow] to register a [ConnectivityManager.NetworkCallback] and listens for network availability changes.
     * The flow is conflated to emit only the latest value, and it is executed on the provided [ioDispatcher].
     */
    override val isConnected: Flow<Boolean> = callbackFlow {
        val connectivityManager = context.getSystemService<ConnectivityManager>()
        if (connectivityManager == null) {
            channel.trySend(false)
            channel.close()
            return@callbackFlow
        }

        val callback = object : ConnectivityManager.NetworkCallback() {

            private val networks = mutableSetOf<Network>()

            /**
             * Called when a network becomes available.
             * Adds the network to the set of available networks and sends `true` to the channel.
             */
            override fun onAvailable(network: Network) {
                networks += network
                channel.trySend(true)
            }

            /**
             * Called when a network is lost.
             * Removes the network from the set of available networks and sends `true` if there are still available networks,
             * or `false` if all networks are lost.
             */
            override fun onLost(network: Network) {
                networks -= network
                channel.trySend(networks.isNotEmpty())
            }
        }

        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        connectivityManager.registerNetworkCallback(request, callback)

        channel.trySend(connectivityManager.isCurrentlyConnected())

        awaitClose {
            connectivityManager.unregisterNetworkCallback(callback)
        }
    }.flowOn(ioDispatcher).conflate()

    /**
     * Checks if the current network is connected by getting the network capabilities of the active network.
     *
     * @return `true` if the network is connected, `false` otherwise.
     */
    private fun ConnectivityManager.isCurrentlyConnected() = activeNetwork
        ?.let(::getNetworkCapabilities)
        ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        ?: false
}