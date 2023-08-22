package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class GameResponses(
    val notEnoughPlayers: String,
    val countdown: String,
    val start: String,
    val end: GameEndResponses,
)