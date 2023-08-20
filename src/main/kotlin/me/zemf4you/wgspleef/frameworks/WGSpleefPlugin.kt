package me.zemf4you.wgspleef.frameworks

import me.zemf4you.wgspleef.adapters.commands.SpleefCommand
import me.zemf4you.wgspleef.di.adapterModule
import me.zemf4you.wgspleef.di.frameworkModule
import me.zemf4you.wgspleef.di.useCaseModule
import org.bukkit.plugin.java.JavaPlugin
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin

class WGSpleefPlugin : JavaPlugin(), KoinComponent {
    override fun onEnable() {
        super.onEnable()
        startKoin {
            modules(
                frameworkModule(plugin = this@WGSpleefPlugin),
                adapterModule(slf4jLogger = slF4JLogger),
                useCaseModule(),
            )
        }
        val spleefCommand: SpleefCommand = get()
        getCommand("spleef")!!.setExecutor(spleefCommand)
    }
}
