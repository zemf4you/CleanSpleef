package me.zemf4you.wgspleef.entities.localization

import kotlinx.serialization.Serializable
import org.bukkit.entity.Player

@Serializable
data class SplitResponse(
    val admin: String,
    val player: String,
) {
    operator fun invoke(player: Player): String =
        if (player.hasPermission("wgspleef.admin")) {
            this.admin
        } else {
            this.player
        }
}