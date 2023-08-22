package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class GameEndResponses(
    val lose: String,
    val win: GameWinResponses,
)