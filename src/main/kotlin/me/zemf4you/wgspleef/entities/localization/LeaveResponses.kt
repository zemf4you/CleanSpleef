package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class LeaveResponses(
    val success: String,
    val fail: String,
)