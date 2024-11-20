package dev.rendrap.app.movienight.core.network.model

import kotlinx.serialization.Serializable

@Serializable
data class TestResponse(val key: String, val value: String)