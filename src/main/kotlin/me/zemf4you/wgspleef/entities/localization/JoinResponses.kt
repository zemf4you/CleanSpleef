package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class JoinResponses(
    val success: String,
    val fail: JoinFailResponses,
)