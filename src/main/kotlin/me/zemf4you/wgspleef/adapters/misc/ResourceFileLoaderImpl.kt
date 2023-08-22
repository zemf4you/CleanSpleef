package me.zemf4you.wgspleef.adapters.misc

import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class ResourceFileLoaderImpl(private val plugin: JavaPlugin) : ResourceFileLoader {
    override fun copyResourceFile(resourcePath: String, destinationPath: String, overwrite: Boolean): File {
        val resource = plugin.getResource(resourcePath)
        val destination = File(plugin.dataFolder, destinationPath)

        if (!destination.exists() || overwrite) {
            resource?.let {
                destination.parentFile.mkdirs()
                destination.writeBytes(it.readBytes())
            }
        }

        return destination
    }
}
