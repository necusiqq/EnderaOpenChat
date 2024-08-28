package org.endera.enderaopenchat.listeners

import io.papermc.paper.event.player.AsyncChatEvent
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.endera.enderalib.adventure.componentToString
import org.endera.enderalib.adventure.stringToComponent
import org.endera.enderaopenchat.bukkitDispatcher
import org.endera.enderaopenchat.config.config


class ChatListener : Listener {

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    fun onPlayerChatSent(event: AsyncChatEvent) {
        runBlocking {
            val player = event.player
            val stringMessage = event.message().componentToString()

            if (stringMessage.startsWith(config.globalChat.prefix)) {
//            val renderer = EChatRenderer()

                event.renderer { _, _, message, _ -> message }
                event.message(
                    PlaceholderAPI.setPlaceholders(
                        event.player,
                        config.globalChat.format
                            .replace("{message}", stringMessage.substring(config.globalChat.prefix.length))
                            .replace("{player}", player.name)
                    ).stringToComponent()
                )
                return@runBlocking
            }

            // LOCAL CHAT HERE

            val nearbyPlayers = withContext(bukkitDispatcher) {
                player.location.getNearbyPlayers(config.localChat.range.toDouble())
            }

            event.viewers().clear()
            event.viewers().addAll(nearbyPlayers)
            event.viewers().add(Bukkit.getConsoleSender())

            event.renderer { _, _, message, _ ->
                message
            }

            event.message(
                PlaceholderAPI.setPlaceholders(
                    event.player,
                    config.localChat.format
                        .replace("{message}", stringMessage)
                        .replace("{player}", player.name)
                ).stringToComponent()
            )
        }
    }

}