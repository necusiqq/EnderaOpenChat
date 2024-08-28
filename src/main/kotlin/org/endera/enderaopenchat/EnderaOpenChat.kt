package org.endera.enderaopenchat

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import org.endera.enderalib.utils.async.BukkitDispatcher
import org.endera.enderalib.utils.configuration.PluginException
import org.endera.enderalib.utils.configuration.configLoadCreationHandler
import org.endera.enderaopenchat.config.ConfigScheme
import org.endera.enderaopenchat.config.configFile
import org.endera.enderaopenchat.config.defaultConfig
import java.io.File
import java.util.logging.Logger

lateinit var rlogger: Logger
lateinit var plugin: JavaPlugin
lateinit var bukkitDispatcher: BukkitDispatcher

class EnderaOpenChat : JavaPlugin() {

    override fun onEnable() {
        plugin = this
        bukkitDispatcher = BukkitDispatcher(this)
        configFile = File("${dataFolder}/config.yml")
        rlogger = logger

        try {
            val loadedConfig = configLoadCreationHandler(
                configFile = configFile,
                dataFolder = dataFolder,
                defaultConfig = defaultConfig,
                logger = logger,
                serializer = ConfigScheme.serializer()
            )
            org.endera.enderaopenchat.config.config = loadedConfig
        } catch (e: PluginException) {
            logger.severe("Critical error loading configuration: ${e.message}")
            server.pluginManager.disablePlugin(this)
        }

        val pm = Bukkit.getPluginManager()
        pm.registerEvents(ChatListener(), this)
        pm.registerEvents(LeaveJoinListener(), this)

        getCommand("msg")?.setExecutor(MsgCommand())
    }
}