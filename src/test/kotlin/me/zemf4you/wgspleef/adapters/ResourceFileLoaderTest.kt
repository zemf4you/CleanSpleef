package me.zemf4you.wgspleef.adapters

import me.zemf4you.wgspleef.BasePluginTest
import me.zemf4you.wgspleef.adapters.misc.ResourceFileLoader
import org.junit.jupiter.api.Test
import org.koin.test.inject
import java.io.File
import kotlin.test.assertContentEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ResourceFileLoaderTest : BasePluginTest() {
    private val resourceFileLoader: ResourceFileLoader by inject()

    @Test
    fun `copy resource file from plugin`() {
        val resourcePath = "testResource.txt"
        val resourceURL = javaClass.classLoader.getResource(resourcePath)
        assertNotNull(resourceURL, "Test resource not found")
        val originalResourceFile = File(resourceURL.toURI())
        val resourceFile = resourceFileLoader.loadResourceFile(resourcePath, overwrite = true)
        assertTrue { resourceFile.exists() }
        assertContentEquals(originalResourceFile.readBytes(), resourceFile.readBytes())
    }
}
