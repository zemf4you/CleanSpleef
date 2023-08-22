package me.zemf4you.wgspleef.frameworks

import me.zemf4you.wgspleef.BasePluginTest
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class WGSpleefTest : BasePluginTest() {
    @Test
    fun `plugin loads correctly`() {
        assertNotNull(plugin)
    }
}
