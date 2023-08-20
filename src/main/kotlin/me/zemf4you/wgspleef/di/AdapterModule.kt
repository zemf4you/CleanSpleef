package me.zemf4you.wgspleef.di

import me.zemf4you.wgspleef.adapters.Logger
import me.zemf4you.wgspleef.adapters.Slf4jLoggerAdapter
import me.zemf4you.wgspleef.adapters.commands.SpleefCommand
import me.zemf4you.wgspleef.adapters.commands.SpleefCommandImpl
import org.koin.dsl.module

fun adapterModule(slf4jLogger: org.slf4j.Logger) = module {
    // commands
    single<SpleefCommand> { SpleefCommandImpl(get()) }

    // listeners
    // TODO

    // adapters
    single<Logger> { Slf4jLoggerAdapter(slf4jLogger) }
}
