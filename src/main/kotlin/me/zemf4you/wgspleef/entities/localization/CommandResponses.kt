package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable

@Serializable
data class CommandResponses(
    val help: SplitResponse,
    val arenas: ListResponse,
    val players: ListResponse,
    val join: JoinResponses,
    val leave: LeaveResponses,
    val reload: String,
)