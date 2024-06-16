package me.zemf4you.wgspleef.adapters.providers

import me.zemf4you.wgspleef.adapters.misc.YamlConfigLoader
import me.zemf4you.wgspleef.entities.localization.Localization

class LocalizationProviderImpl(
    private val yamlConfigLoader: YamlConfigLoader,
    private val configProvider: ConfigProvider,
) : LocalizationProvider {
    override lateinit var config: Localization

    init {
        loadConfig()
    }

    override fun loadConfig() {
        this.config = yamlConfigLoader.loadConfig(
            configFilePath = "languages/${configProvider.config.lang}.yml",
            clazz = Localization::class,
        )
    }
}
