package me.zemf4you.wgspleef.adapters.misc

import java.io.File
import kotlin.reflect.KClass

interface YamlConfigLoader {
    fun getConfigFile(configFilePath: String): File
    fun <T : Any> loadConfig(configFilePath: String, clazz: KClass<T>): T
}
