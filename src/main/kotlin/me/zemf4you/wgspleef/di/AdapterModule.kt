package me.zemf4you.wgspleef.di

import me.zemf4you.wgspleef.adapters.Logger
import me.zemf4you.wgspleef.adapters.Slf4jLoggerAdapter
import me.zemf4you.wgspleef.adapters.commands.SpleefCommand
import me.zemf4you.wgspleef.adapters.commands.SpleefCommandImpl
import org.bukkit.plugin.java.JavaPlugin
import org.koin.dsl.module

fun adapterModule() = module {
    // commands
    single<SpleefCommand> { SpleefCommandImpl(get()) }

    // listeners
    // TODO

    // adapters
    single<Logger> {
        val plugin: JavaPlugin = get()
        Slf4jLoggerAdapter(plugin.slF4JLogger)
    }
}
