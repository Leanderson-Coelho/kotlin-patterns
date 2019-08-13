package ChainOfResponsibility

class PilhaDeDinheiro(val valor: Int, var quantidade: Int, var proximaPilha: PilhaDeDinheiro?){

    fun conseguePagar(quantia: Int): Boolean = (quantia / this.valor) > 0

    fun podeRetirar(valorDesejado: Int) : Boolean{
        var montante = valorDesejado
        var quantidade = this.quantidade

        while(conseguePagar(montante)){
            if(quantidade == 0){
                break
            }

            montante -= this.valor
            quantidade -= 1
        }

        if(montante <= 0){
            return true
        }

        proximaPilha?.let {
            return it.podeRetirar(montante)
        }

        return false
    }


}

class CaixaEletronico(val pilhaDeDinheiro: PilhaDeDinheiro){

    fun podeRetirar(valor: Int) {
        if(pilhaDeDinheiro.podeRetirar(valor)){
            println("É possível retirar este valor!")
        }else{
            println("Not enough cash, stranger!")
        }
    }

}

fun main(args: Array<String>) {

    val dezReais = PilhaDeDinheiro(10,6,null)
    val vinteReais = PilhaDeDinheiro(20,2,dezReais)
    val cinquentaReais = PilhaDeDinheiro(50,2,vinteReais)
    val cemReais = PilhaDeDinheiro(100,1,cinquentaReais)

    val meuCaixa = CaixaEletronico(cemReais)

    meuCaixa.podeRetirar(310)
    meuCaixa.podeRetirar(100)
    meuCaixa.podeRetirar(165)
    meuCaixa.podeRetirar(30)



}