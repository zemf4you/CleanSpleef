package me.zemf4you.wgspleef.di

import me.zemf4you.wgspleef.frameworks.WGSpleef
import org.bukkit.plugin.java.JavaPlugin
import org.koin.dsl.module

fun frameworkModule(plugin: WGSpleef) = module {
    single<JavaPlugin> { plugin }
}
