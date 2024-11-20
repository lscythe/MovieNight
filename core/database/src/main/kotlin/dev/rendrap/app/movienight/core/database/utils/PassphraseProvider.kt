package dev.rendrap.app.movienight.core.database.utils

import android.content.Context
import android.os.Build
import androidx.security.crypto.EncryptedFile
import androidx.security.crypto.MasterKeys
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.security.SecureRandom
import javax.inject.Inject
import javax.inject.Singleton

interface PassphraseProvider {
    fun get(): ByteArray
}

private const val PASSPHRASE_FILE_NAME = "assignment_json.bin"

@Singleton
class PassphraseProviderImpl @Inject constructor(
    @ApplicationContext private val context: Context
): PassphraseProvider {
    override fun get(): ByteArray {
        val file = File(context.filesDir, PASSPHRASE_FILE_NAME)
        val encryptedFile = EncryptedFile.Builder(
            file,
            context,
            MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC),
            EncryptedFile.FileEncryptionScheme.AES256_GCM_HKDF_4KB
        ).build()

        return if (file.exists()) {
            encryptedFile.openFileInput().use { it.readBytes() }
        } else {
            generate().also { passPhrase ->
                encryptedFile.openFileOutput().use { it.write(passPhrase) }
            }
        }
    }

    private fun generate(): ByteArray {
        val random = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            SecureRandom.getInstanceStrong()
        } else {
            SecureRandom.getInstance("SHA1PRNG")
        }
        val result = ByteArray(32)

        random.nextBytes(result)
        while (result.contains(0)) {
            random.nextBytes(result)
        }

        return result
    }
}