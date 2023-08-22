package me.zemf4you.wgspleef

import me.zemf4you.wgspleef.adapters.commands.SpleefCommand
import me.zemf4you.wgspleef.di.adapterModule
import me.zemf4you.wgspleef.di.frameworkModule
import me.zemf4you.wgspleef.di.useCaseModule
import me.zemf4you.wgspleef.frameworks.WGSpleef
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

class CompositionRoot(private val plugin: WGSpleef) {
    fun initialize() {
        startKoin {
            modules(
                frameworkModule(plugin = plugin),
                adapterModule(),
                useCaseModule(),
            )
            val spleefCommand: SpleefCommand = koin.get()
            plugin.getCommand("spleef")!!.setExecutor(spleefCommand)
        }
    }

    fun dispose() {
        stopKoin()
    }
}
