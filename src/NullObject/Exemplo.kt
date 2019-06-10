package NullObject

class Pessoa (var nome: String,var idade: Int?,var cpf: String){}

class MediaPessoasCadastradas(var pessoas: List<Pessoa>){
	val pessoasMedia: List<Pessoa> = pessoas;
	
	fun calcularMedia(): Int{
		var total = 0;
		for(p in pessoasMedia){
			total += p.idade ?: 0;
		}
		return total;
	}
}


fun main(){
	var pessoa1: Pessoa = Pessoa("Leanderson",10,"43434343");
	var pessoa2: Pessoa = Pessoa("Pedro",null,"43434");
	var pessoa3: Pessoa = Pessoa("Lucas",10,"5657567");
	var pessoa4: Pessoa = Pessoa("Rafael",null,"9789878");
	var pessoa5: Pessoa = Pessoa("Jose",10,"234332424");
	var pessoa6: Pessoa = Pessoa("Maria",null,"67786768");
	var pessoa7: Pessoa = Pessoa("Aquirys",10,"32455");
	var pessoa8: Pessoa = Pessoa("Rafaela",null,"4564564");
	var pessoas: ArrayList<Pessoa> = ArrayList<Pessoa>();
	pessoas.add(pessoa1);
	pessoas.add(pessoa2);
	pessoas.add(pessoa3);
	pessoas.add(pessoa4);
	pessoas.add(pessoa5);
	pessoas.add(pessoa6);
	pessoas.add(pessoa7);
	pessoas.add(pessoa8);
	var mediaPessoas: MediaPessoasCadastradas = MediaPessoasCadastradas(pessoas);
	
	print(mediaPessoas.calcularMedia());

}