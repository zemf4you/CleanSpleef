package me.zemf4you.wgspleef.adapters.providers

import me.zemf4you.wgspleef.BasePluginTest
import org.junit.jupiter.api.Test
import org.koin.test.inject

class LocalizationProviderTest : BasePluginTest() {
    private val localizationProvider: LocalizationProvider by inject()

    @Test
    fun `test loadConfig loads correct localization`() {
        // TODO: pass test resource, setup config.lang
        println(localizationProvider.config)
    }
}
