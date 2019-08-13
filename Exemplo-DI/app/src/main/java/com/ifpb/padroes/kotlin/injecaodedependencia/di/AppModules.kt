package com.ifpb.padroes.kotlin.injecaodedependencia.di

import com.ifpb.padroes.kotlin.injecaodedependencia.components.HelloMessage
import com.ifpb.padroes.kotlin.injecaodedependencia.components.HelloMessageEn
import com.ifpb.padroes.kotlin.injecaodedependencia.components.HelloMessagePt
import com.ifpb.padroes.kotlin.injecaodedependencia.service.HelloService
import com.ifpb.padroes.kotlin.injecaodedependencia.service.HelloServiceImpl
import org.koin.dsl.module

val sayHelloModule = module {
    single { HelloServiceImpl(get()) as HelloService }
}

val helloMessageModule = module {
    single { HelloMessageEn() as HelloMessage }
}