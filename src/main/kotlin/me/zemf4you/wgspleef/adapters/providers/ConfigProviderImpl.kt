package me.zemf4you.wgspleef.adapters.providers

import me.zemf4you.wgspleef.adapters.misc.YamlConfigLoader
import me.zemf4you.wgspleef.entities.Config

class ConfigProviderImpl(private val yamlConfigLoader: YamlConfigLoader) : ConfigProvider {
    override lateinit var config: Config
        private set

    init {
        loadConfig()
    }

    override fun loadConfig() {
        this.config = yamlConfigLoader.loadConfig(
            configFilePath = "config.yml",
            clazz = Config::class,
        )
    }
}
