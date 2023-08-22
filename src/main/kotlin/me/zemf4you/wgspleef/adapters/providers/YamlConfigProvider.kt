package me.zemf4you.wgspleef.adapters.providers

interface YamlConfigProvider<T> {
    val config: T
    fun loadConfig()
}
