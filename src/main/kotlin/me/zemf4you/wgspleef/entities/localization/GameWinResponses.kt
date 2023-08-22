package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class GameWinResponses(
    val reward: String,
    val noReward: String,
)