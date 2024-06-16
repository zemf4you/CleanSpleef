package me.zemf4you.wgspleef.adapters.misc

import kotlin.reflect.KClass

interface YamlConfigLoader {
    fun <T : Any> loadConfig(configFilePath: String, clazz: KClass<T>): T
}
