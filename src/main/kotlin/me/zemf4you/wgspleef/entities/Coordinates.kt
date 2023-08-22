package me.zemf4you.wgspleef.entities

import kotlinx.serialization.Serializable

@Serializable
data class Coordinates(
    val x: Double,
    val y: Double,
    val z: Double,
)
