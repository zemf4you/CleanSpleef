package me.zemf4you.wgspleef.adapters.commands

import be.seeseemelk.mockbukkit.entity.PlayerMock
import me.zemf4you.wgspleef.BasePluginTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.koin.test.inject

class SpleefCommandTest : BasePluginTest() {
    private val spleefCommand: SpleefCommand by inject()
    private lateinit var player: PlayerMock

    @BeforeEach
    override fun setUp() {
        super.setUp()
        player = server.addPlayer()
    }

    @Test
    fun `spleef command executes`() {
        player.performCommand("spleef")
        // TODO
    }
}
