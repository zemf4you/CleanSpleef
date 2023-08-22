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
        val lang = configProvider.config.lang
        this.config = yamlConfigLoader.loadConfig("languages/${lang}.yml", Localization::class)
    }
}
