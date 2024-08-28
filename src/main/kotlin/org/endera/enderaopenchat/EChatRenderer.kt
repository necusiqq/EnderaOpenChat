package org.endera.enderaopenchat

import io.papermc.paper.chat.ChatRenderer
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player
import org.endera.enderalib.adventure.componentToString

class EChatRenderer : ChatRenderer {

    override fun render(source: Player, sourceDisplayName: Component, message: Component, viewer: Audience): Component {
        return message
    }

}