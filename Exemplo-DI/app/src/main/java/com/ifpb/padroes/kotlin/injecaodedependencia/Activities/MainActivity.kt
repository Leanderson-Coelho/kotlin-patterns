package com.ifpb.padroes.kotlin.injecaodedependencia.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.ifpb.padroes.kotlin.injecaodedependencia.R
import com.ifpb.padroes.kotlin.injecaodedependencia.service.HelloService
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainActivity : AppCompatActivity(), KoinComponent {

    private val helloService by inject<HelloService>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun mostrarMensagem(view: View){
        val editText = findViewById<EditText>(R.id.meuInput)
        val message = editText.text.toString()
        Log.d("SAPORRA",message)
        Toast.makeText(this, helloService.sayHello(message), Toast.LENGTH_SHORT).show()

    }

    fun teste(view: View){
        val editText = findViewById<EditText>(R.id.meuInput)
        val message = editText.text.toString()
        Log.d("SAPORRA",message)
    }
}
