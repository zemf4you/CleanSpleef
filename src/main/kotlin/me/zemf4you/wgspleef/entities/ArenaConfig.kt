package me.zemf4you.wgspleef.entities

import kotlinx.serialization.Serializable

@Serializable
data class ArenaConfig(
    val world: String,
    val minPlayers: Int,
    val maxPlayers: Int,
    val startCoords: Coordinates,
    val blockToBreak: String,
    val startItem: String,
    val startCountdown: Int,
    val startCountdownReset: Boolean,
    val reward: Int,
)
