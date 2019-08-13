package com.ifpb.padroes.kotlin.injecaodedependencia.service

import com.ifpb.padroes.kotlin.injecaodedependencia.components.HelloMessage
import org.koin.core.KoinComponent
import org.koin.dsl.KoinAppDeclaration


class HelloServiceImpl(val helloMessage:HelloMessage): HelloService, KoinComponent {

    override fun sayHello(nome: String): String {
        return "${helloMessage.message} $nome"
    }

}