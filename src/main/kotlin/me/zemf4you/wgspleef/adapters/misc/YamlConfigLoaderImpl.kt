package me.zemf4you.wgspleef.adapters.misc

import com.charleskorn.kaml.Yaml
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.modules.serializersModuleOf
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

class YamlConfigLoaderImpl(
    private val resourceFileLoader: ResourceFileLoader,
) : YamlConfigLoader {
    @OptIn(InternalSerializationApi::class)
    override fun <T : Any> loadConfig(configFilePath: String, clazz: KClass<T>): T {
        val configFile = resourceFileLoader.loadResourceFile(configFilePath)
        val serializer = clazz.serializer()
        val yaml = Yaml(serializersModuleOf(clazz, serializer))
        return yaml.decodeFromStream(serializer, configFile.inputStream())
    }
}
