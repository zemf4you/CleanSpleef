package me.zemf4you.wgspleef

interface Logger {
    val name: String

    fun trace(msg: String)
    fun trace(format: String, vararg arguments: Any)
    fun trace(msg: String, t: Throwable)

    fun debug(msg: String)
    fun debug(format: String, vararg arguments: Any)
    fun debug(msg: String, t: Throwable)

    fun info(msg: String)
    fun info(format: String, vararg arguments: Any)
    fun info(msg: String, t: Throwable)

    fun warn(msg: String)
    fun warn(format: String, vararg arguments: Any)
    fun warn(msg: String, t: Throwable)

    fun error(msg: String)
    fun error(format: String, vararg arguments: Any)
    fun error(msg: String, t: Throwable)
}
