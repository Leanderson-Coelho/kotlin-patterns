package com.ifpb.kt.singleton


class Singleton {

    var name:String?=null

    private constructor(){
        println("eu sou um singleton")
    }

    companion object {
        val instance:Singleton by lazy { Singleton() }
    }

}

fun main(args:Array<String>){

    var singleton1 = Singleton.instance
    singleton1.name = "eu sou o singleton 1"
    println(singleton1.name)

    var singleton2 = Singleton.instance
    println(singleton1.name)

    var singleton3 = Singleton.instance
    println(singleton1.name)

}