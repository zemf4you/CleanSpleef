package me.zemf4you.wgspleef.frameworks

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.ServerMock
import be.seeseemelk.mockbukkit.entity.PlayerMock
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class WGSpleefPluginTest {

    private lateinit var server: ServerMock
    private lateinit var plugin: WGSpleefPlugin
    private lateinit var player: PlayerMock

    @BeforeEach
    fun setUp() {
        server = MockBukkit.mock()
        plugin = MockBukkit.load(WGSpleefPlugin::class.java)
        player = server.addPlayer()
    }

    @AfterEach
    fun tearDown() {
        MockBukkit.unmock()
    }

    @Test
    fun `plugin loads correctly`() {
        assertNotNull(plugin)
    }

    @Test
    fun `spleef command execute`() {
        player.performCommand("spleef")
        player.assertSaid("Pong!")
        player.assertNoMoreSaid()
    }
}
