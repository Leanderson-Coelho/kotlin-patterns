package Observer

import kotlin.properties.Delegates

interface Notificacao{
    fun notificar(mensagem: String)
}

class Pessoa(val nome: String)

class NotificaPessoa(private val pessoa: Pessoa): Notificacao{
    override fun notificar(mensagem: String) {
        println("${pessoa.nome} recebeu a mensagem: \"$mensagem\" com sucesso!")
    }
}

class Chat(private val notificadores : List<NotificaPessoa>, private val mensagens: ArrayList<String> = ArrayList()){

    private var mensagem: String by Delegates.observable("") { _, _, new ->
        mensagens.add(new)
        for(not in notificadores){
            not.notificar(new)
        }
    }

    fun add(mensagemNova: String){
        mensagem = mensagemNova
    }

}

fun main(args: Array<String>) {

    var not1 = NotificaPessoa(Pessoa("eu"))
    var not2 = NotificaPessoa(Pessoa("tu"))

    var chat = Chat(listOf(not1,not2))
    chat.add("teste")
    chat.add("teste2")


}