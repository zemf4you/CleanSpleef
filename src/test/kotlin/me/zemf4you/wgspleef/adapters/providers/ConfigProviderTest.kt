package me.zemf4you.wgspleef.adapters.providers

import me.zemf4you.wgspleef.BasePluginTest
import org.junit.jupiter.api.Test
import org.koin.test.inject

class ConfigProviderTest : BasePluginTest() {
    private val configProvider: ConfigProvider by inject()

    @Test
    fun `test loadConfig loads correct config`() {
        // TODO: pass test resource
        println(configProvider.config)
    }
}
