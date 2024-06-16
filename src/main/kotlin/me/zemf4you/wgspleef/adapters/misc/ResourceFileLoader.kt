package me.zemf4you.wgspleef.adapters.misc

import java.io.File

interface ResourceFileLoader {
    fun loadResourceFile(resourcePath: String, overwrite: Boolean = false): File
}
