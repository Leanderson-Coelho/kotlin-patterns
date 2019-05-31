typealias convertMap = (Map<String,String>) -> Unit

class MeuConversor(private val formaDeConverter: convertMap){

    fun converter(meuMapa: Map<String,String>) {
        formaDeConverter(meuMapa)
    }
}

fun main(args: Array<String>) {

    val converteParaJson: convertMap = {
        var json: String = "{\n"
        for((k,v) in it) {
            json += "\t\"$k\":\"$v\",\n"
        }
        json += "}"
        println(json)
    }

    val converteParaXML: convertMap = {
        var xml: String = "<xml>\n"
        for((k,v) in it){
            xml += "\t<$k>$v</$k>\n"
        }
        xml += "</xml>"
        println(xml)
    }

    var meuConversor = MeuConversor(converteParaXML)
    meuConversor.converter(mapOf("Teste" to "testador","testando" to "ahsduqw"))

}
