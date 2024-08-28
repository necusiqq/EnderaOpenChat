package org.endera.enderaopenchat.config

val defaultConfig = ConfigScheme(
    localChat = LocalChat(
        range = 100,
        format = "<green>[L] <reset>%luckperms_prefix% {player}: {message}"
    ),
    globalChat = GlobalChat(
        prefix = "!",
        format = "<red>[G] <reset>%luckperms_prefix% {player}: {message}"
    ),
    personalMessages = Msg(
        format = "<gray>[<dark_gray>{sender} <gray>-> <dark_gray>{target}<gray>]: <white>{message}"
    ),
    customLeaveJoin = CustomLeaveJoin(
        joinMessage = LeaveJoinMessage(
            enabled = true,
            message = "<gray>[<green>+<gray>] <white>{player} присоединился к игре"
        ),
        leaveMessage = LeaveJoinMessage(
            enabled = true,
            message = "<gray>[<red>-<gray>] <white>{player} покинул игру"
        )
    ),
    messages = Messages(
        prefix = "<green>[EChat]<reset>",
        playernotfound = "{prefix} <red>Игрок не найден",
        usage = Usage(
            msg = "{prefix} <red>Использование команды: /msg (player) (сообщение)"
        )
    )
)