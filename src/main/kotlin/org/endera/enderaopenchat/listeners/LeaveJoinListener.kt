package org.endera.enderaopenchat.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import org.endera.enderalib.adventure.stringToComponent
import org.endera.enderaopenchat.config.config
import org.endera.enderaopenchat.utils.papiParse

class LeaveJoinListener : Listener {

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        if (!config.customLeaveJoin.joinMessage.enabled) return
        if (config.customLeaveJoin.joinMessage.message.isBlank()) {
            event.joinMessage(null)
            return
        }
        event.joinMessage(
            config.customLeaveJoin.joinMessage.message
                .replace("{player}", event.player.name)
                .papiParse(event.player)
                .stringToComponent()
        )

    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        if (!config.customLeaveJoin.leaveMessage.enabled) return
        if (config.customLeaveJoin.leaveMessage.message.isBlank()) {
            event.quitMessage(null)
            return
        }
        event.quitMessage(
            config.customLeaveJoin.leaveMessage.message
                .replace("{player}", event.player.name)
                .papiParse(event.player)
                .stringToComponent()
        )
    }
}