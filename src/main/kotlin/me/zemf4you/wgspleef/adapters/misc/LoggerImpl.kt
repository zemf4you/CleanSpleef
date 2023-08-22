package me.zemf4you.wgspleef.adapters.misc

class LoggerImpl(private val logger: org.slf4j.Logger) : Logger {
    override fun trace(msg: String) = logger.trace(msg)
    override fun trace(format: String, vararg arguments: Any) = logger.trace(format, *arguments)
    override fun trace(msg: String, t: Throwable) = logger.trace(msg, t)

    override fun debug(msg: String) = logger.debug(msg)
    override fun debug(format: String, vararg arguments: Any) = logger.debug(format, *arguments)
    override fun debug(msg: String, t: Throwable) = logger.debug(msg, t)

    override fun info(msg: String) = logger.info(msg)
    override fun info(format: String, vararg arguments: Any) = logger.info(format, *arguments)
    override fun info(msg: String, t: Throwable) = logger.info(msg, t)

    override fun warn(msg: String) = logger.warn(msg)
    override fun warn(format: String, vararg arguments: Any) = logger.warn(format, *arguments)
    override fun warn(msg: String, t: Throwable) = logger.warn(msg, t)

    override fun error(msg: String) = logger.error(msg)
    override fun error(format: String, vararg arguments: Any) = logger.error(format, *arguments)
    override fun error(msg: String, t: Throwable) = logger.error(msg, t)
}
