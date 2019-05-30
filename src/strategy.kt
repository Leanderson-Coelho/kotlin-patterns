interface ConvertStrategy{
	fun convert(map: Map<String, String>);
}

class ConvertToJson: ConvertStrategy{
	override fun convert(map: Map<String, String>){
		var json: String = "{\n";
		for((k,v) in map){
			json+="\t\"$k\":\"$v\",\n";
		} 
		json+="}";
		println(json);
	}
}

class ConvertToXML: ConvertStrategy{
	override fun convert(map: Map<String, String>){
		var xml: String ="<xml>\n";
		for((k,v) in map){
			xml+="\t<$k>$v</$k>\n";
		}
		xml+="</xml>";
		println(xml);
	}
}

fun main(){
	var paraJson: ConvertStrategy = ConvertToJson();
	var paraXML: ConvertStrategy = ConvertToXML();
	paraJson.convert(mapOf("Foi" to "Embora","Vamos" to "pra casa"));
	paraXML.convert(mapOf("Foi" to "Embora","Vamos" to "pra casa"))
}