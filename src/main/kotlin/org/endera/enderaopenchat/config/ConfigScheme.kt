package org.endera.enderaopenchat.config

import kotlinx.serialization.Serializable

@Serializable
data class ConfigScheme(
    val localChat: LocalChat,
    val globalChat: GlobalChat,
    val personalMessages: Msg,
    val customLeaveJoin: CustomLeaveJoin,
    val messages: Messages
)

@Serializable
data class CustomLeaveJoin(
    val joinMessage: LeaveJoinMessage,
    val leaveMessage: LeaveJoinMessage,
)

@Serializable
data class LeaveJoinMessage(
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
)

@Serializable
data class Messages(
    val prefix: String,
    val usage: Usage,
    val playernotfound: String,
)


@Serializable
data class Usage(
    val msg: String
)