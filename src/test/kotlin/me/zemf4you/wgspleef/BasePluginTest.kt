package me.zemf4you.wgspleef

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.ServerMock
import me.zemf4you.wgspleef.frameworks.WGSpleef
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.koin.test.KoinTest

abstract class BasePluginTest : KoinTest {
    protected lateinit var server: ServerMock
    protected lateinit var plugin: WGSpleef

    @BeforeEach
    open fun setUp() {
        server = MockBukkit.mock()
        plugin = MockBukkit.load(WGSpleef::class.java)
    }

    @AfterEach
    fun tearDown() {
        MockBukkit.unmock()
    }
}
