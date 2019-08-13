package com.ifpb.padroes.kotlin.injecaodedependencia

import android.app.Application
import com.ifpb.padroes.kotlin.injecaodedependencia.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MainApplication: Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.INFO)
            printLogger(Level.INFO)
            androidContext(this@MainApplication)
            androidFileProperties()
            modules(listOf(helloMessageModule, sayHelloModule))
        }
    }
}