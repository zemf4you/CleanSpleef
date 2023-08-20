package me.zemf4you.wgspleef.adapters.commands

import me.zemf4you.wgspleef.adapters.Logger
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class SpleefCommandImpl(private val logger: Logger) : SpleefCommand {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        logger.info("Spleef command!")
        sender.sendMessage("Pong!")
        return true
    }
}
