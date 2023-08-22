package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class JoinFailResponses(
    val alreadyIn: String,
    val arenaDoesNotExist: String,
    val arenaIsFull: String,
    val allArenasAreFull: String,
)