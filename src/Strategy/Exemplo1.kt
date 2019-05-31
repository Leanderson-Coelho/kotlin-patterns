package Strategy

interface ConvertStrategy{
	fun convert(map: Map<String, String>);
}

class ConvertToJson: ConvertStrategy {
	override fun convert(map: Map<String, String>){
		var json: String = "{\n";
		for((k,v) in map){
			json+="\t\"$k\":\"$v\",\n";
		} 
		json+="}";
		println(json);
	}
}

//class ConvertToXML: Strategy.ConvertStrategy{
//	override fun convert(map: Map)
//}

fun main(){
	var paraJson = ConvertToJson();
	paraJson.convert(mapOf("Foi" to "Embora","Vamos" to "pra casa"));
}