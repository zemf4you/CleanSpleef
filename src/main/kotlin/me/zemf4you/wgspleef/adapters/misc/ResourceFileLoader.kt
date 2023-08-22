package me.zemf4you.wgspleef.adapters.misc

import java.io.File

interface ResourceFileLoader {
    fun copyResourceFile(resourcePath: String, destinationPath: String, overwrite: Boolean): File
}
