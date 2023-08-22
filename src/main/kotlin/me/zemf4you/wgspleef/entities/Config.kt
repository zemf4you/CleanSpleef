package me.zemf4you.wgspleef.entities

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val lang: String,
    val arenas: Map<String, ArenaConfig>,
)
