package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class Localization(
    val prefix: String,
    val common: CommonResponses,
    val game: GameResponses,
    val commands: CommandResponses,
)
