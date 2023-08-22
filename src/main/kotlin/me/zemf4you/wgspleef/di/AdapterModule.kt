package me.zemf4you.wgspleef.di

import me.zemf4you.wgspleef.adapters.commands.SpleefCommand
import me.zemf4you.wgspleef.adapters.commands.SpleefCommandImpl
import me.zemf4you.wgspleef.adapters.misc.*
import me.zemf4you.wgspleef.adapters.providers.ConfigProvider
import me.zemf4you.wgspleef.adapters.providers.ConfigProviderImpl
import me.zemf4you.wgspleef.adapters.providers.LocalizationProvider
import me.zemf4you.wgspleef.adapters.providers.LocalizationProviderImpl
import org.bukkit.plugin.java.JavaPlugin
import org.koin.dsl.module

fun adapterModule() = module {
    // commands
    single<SpleefCommand> { SpleefCommandImpl(get()) }

    // listeners
    // TODO

    // other
    single<Logger> {
        val plugin: JavaPlugin = get()
        LoggerImpl(plugin.slF4JLogger)
    }
    factory<YamlConfigLoader> { YamlConfigLoaderImpl(get()) }
    factory<ResourceFileLoader> { ResourceFileLoaderImpl(get()) }

    single<ConfigProvider> { ConfigProviderImpl(get()) }
    single<LocalizationProvider> { LocalizationProviderImpl(get(), get()) }
}
