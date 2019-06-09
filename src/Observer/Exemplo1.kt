package Observer

import kotlin.properties.Delegates

interface Notificacao{
    fun notificar(mensagem: String)
}

class Pessoa(val nome: String)

class NotificaPessoa(private val pessoa: Pessoa): Notificacao{
    override fun notificar(mensagem: String) {
        println("${pessoa.nome} recebeu a mensagem: \"mensagem\" com sucesso!")
    }
}

class Chat(private val notificadores : ArrayList<Notificacao> = ArrayList()){

    private val mensagens: ArrayList<String> = ArrayList()

    private var ultimaMensagem: String by Delegates.observable(""){ _, _, new ->
        mensagens.add(new)
        notificadores.forEach { notf -> notf.notificar(new) }
    }


    fun enviar(mensagemNova: String){
        ultimaMensagem = mensagemNova
    }

    fun addNotificador(notificador : Notificacao){
        notificadores.add(notificador)
    }

    fun removerNotificador(notificador: Notificacao){
        notificadores.remove(notificador)
    }

}

fun main(args: Array<String>) {

    val not1 = NotificaPessoa(Pessoa("eu"))
    val not2 = NotificaPessoa(Pessoa("tu"))

    val chat = Chat(arrayListOf(not1,not2))

    chat.addNotificador(NotificaPessoa(Pessoa("ele")))
    chat.enviar("opa")
    chat.enviar("Mah Oe")



}