package com.ifpb.kt.singleton

class Singleton{

    var nome:String?=null

    private constructor(){
        println("eu sou um singleton :)")
    }

    companion object{
        val instance:Singleton by lazy { Singleton() }
    }

}

fun main(args:Array<String>){

    var s1 = Singleton.instance
    s1.nome = "eu sou o primeiro singleton :)"
    println(s1.nome)

    var s2 = Singleton.instance
    println(s2.nome)

}