package me.zemf4you.wgspleef.frameworks

import me.zemf4you.wgspleef.adapters.commands.SpleefCommand
import me.zemf4you.wgspleef.di.adapterModule
import me.zemf4you.wgspleef.di.frameworkModule
import me.zemf4you.wgspleef.di.useCaseModule
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

open class WGSpleef : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()
        startKoin {
            modules(
                frameworkModule(plugin = this@WGSpleef),
                adapterModule(),
                useCaseModule(),
            )
            val spleefCommand: SpleefCommand = koin.get()
            this@WGSpleef.getCommand("spleef")!!.setExecutor(spleefCommand)
        }
    }

    override fun onDisable() {
        super.onDisable()
        stopKoin()
    }
}
