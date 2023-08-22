package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class CommonResponses(
    val noPermission: String,
    val playersOnly: String,
    val unavailableCommand: String,
)