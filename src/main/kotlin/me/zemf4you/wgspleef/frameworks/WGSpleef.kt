package me.zemf4you.wgspleef.frameworks

import me.zemf4you.wgspleef.CompositionRoot
import org.bukkit.plugin.java.JavaPlugin

open class WGSpleef : JavaPlugin() {
    private lateinit var compositionRoot: CompositionRoot

    override fun onEnable() {
        super.onEnable()
        compositionRoot = CompositionRoot(this)
        compositionRoot.initialize()
    }

    override fun onDisable() {
        super.onDisable()
        compositionRoot.dispose()
    }
}
