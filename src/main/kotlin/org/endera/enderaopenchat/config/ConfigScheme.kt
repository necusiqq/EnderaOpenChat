package org.endera.enderaopenchat.config

import kotlinx.serialization.Serializable

@Serializable
data class ConfigScheme(
    val localChat: LocalChat,
    val globalChat: GlobalChat,
    val personalMessages: Msg,
    val customLeaveJoinDeath: CustomLeaveJoinDeath,
    val discordSrv: DiscordSrv,
    val messages: Messages,
)

@Serializable
data class CustomLeaveJoinDeath(
    val joinMessage: LeaveJoinDeathMessage,
    val leaveMessage: LeaveJoinDeathMessage,
    val deathMessage: LeaveJoinDeathMessage,
)

@Serializable
data class DiscordSrv(
    val sendMessagesFromLocalChat: Boolean
)

@Serializable
data class LeaveJoinDeathMessage(
    val enabled: Boolean,
    val message: String,
)

@Serializable
data class LocalChat(
    val format: String,
    val range: Int,
)

@Serializable
data class GlobalChat(
    val prefix: String,
    val format: String,
)

@Serializable
data class Msg(
    val format: String,
    val sound: String,
    val volume: Float,
    val pitch: Float,
)

@Serializable
data class Messages(
    val prefix: String,
    val reload: String,
    val usage: Usage,
    val playernotfound: String,
)


@Serializable
data class Usage(
    val msg: String
)