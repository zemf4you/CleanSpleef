package me.zemf4you.wgspleef.adapters.misc

import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import java.io.FileNotFoundException

class ResourceFileLoaderImpl(private val plugin: JavaPlugin) : ResourceFileLoader {
    override fun loadResourceFile(resourcePath: String, overwrite: Boolean): File {
        val resourceFile = File(plugin.dataFolder, resourcePath)
        val resource = plugin.getResource(resourcePath)
        resource ?: throw FileNotFoundException("Resource $resourcePath not found")
        if (!resourceFile.exists() || overwrite) {
            resourceFile.parentFile.mkdirs()
            // TODO: work with input stream effectively
            resourceFile.writeBytes(resource.readBytes())
        }
        return resourceFile
    }
}
