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
        val resourceURL = javaClass.classLoader.getResource("testResource.txt")
        assertNotNull(resourceURL, "Resource not found")
        val testResource = File(resourceURL.toURI())

        val copiedFile = resourceFileLoader.copyResourceFile(
            resourcePath = testResource.name,
            destinationPath = testResource.name,
            overwrite = true,
        )

        assertTrue { copiedFile.exists() }
        assertContentEquals(testResource.readBytes(), copiedFile.readBytes())
    }
}
