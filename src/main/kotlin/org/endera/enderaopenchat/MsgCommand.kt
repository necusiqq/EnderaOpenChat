package org.endera.enderaopenchat

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.endera.enderalib.adventure.stringToComponent
import org.endera.enderalib.utils.checkPermission
import org.endera.enderaopenchat.config.config

class MsgCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        sender.checkPermission("echat.msg") {
            if (args.size < 2) {
                sender.sendMessage(config.messages.usage.msg.cparse())
                return@checkPermission
            }

            val targetPlayerName = args[0]
            val message = args.drop(1).joinToString(" ")

            val targetPlayer = Bukkit.getPlayer(targetPlayerName)

            if ((targetPlayer == null) || !targetPlayer.isOnline) {
                sender.sendMessage(config.messages.playernotfound.cparse())
                return@checkPermission
            }

            sender.sendMessage(
                config.personalMessages.format
                    .replace("{sender}","Я")
                    .replace("{target}", targetPlayerName)
                    .replace("{message}", message)
                    .stringToComponent()
            )
            targetPlayer.sendMessage(
                config.personalMessages.format
                    .replace("{target}","Я")
                    .replace("{sender}", sender.name)
                    .replace("{message}", message)
                    .stringToComponent()
            )
        }
        return true
    }
}