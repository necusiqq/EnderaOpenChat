package org.endera.enderaopenchat.utils

import me.clip.placeholderapi.PlaceholderAPI
import org.bukkit.entity.Player

fun String.papiParse(player: Player): String {
    return PlaceholderAPI.setPlaceholders(
        player,
        this
    )
}