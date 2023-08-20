package me.zemf4you.wgspleef.di

import me.zemf4you.wgspleef.frameworks.WGSpleefPlugin
import org.bukkit.plugin.java.JavaPlugin
import org.koin.dsl.module

fun frameworkModule(plugin: WGSpleefPlugin) = module {
    single<JavaPlugin> { plugin }
}
