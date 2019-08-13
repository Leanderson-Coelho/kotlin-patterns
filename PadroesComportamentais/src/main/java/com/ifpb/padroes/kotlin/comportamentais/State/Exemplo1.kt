package State

interface EstadoDeAlerta{
    fun alertar()
}

class Vibracao : EstadoDeAlerta{

    override fun alertar() {
        println("VRUMMMMM!")
    }

}

class Som : EstadoDeAlerta{

    override fun alertar() {
        println("Piririm Piririm Piririm!")
    }

}

class Mudo : EstadoDeAlerta {

    override fun alertar() {
        println("........")
    }

}


class Alerta{

    private var estadoDeAlerta: EstadoDeAlerta = Vibracao()

    fun setEstado(estado: EstadoDeAlerta){
        estadoDeAlerta = estado
    }


    fun alertar(){
        estadoDeAlerta.alertar()
    }

}

fun main(args: Array<String>) {

    val meuAlerta = Alerta()
    meuAlerta.alertar()
    meuAlerta.setEstado(Som())
    meuAlerta.alertar()
    meuAlerta.setEstado(Mudo())
    meuAlerta.alertar()

}


