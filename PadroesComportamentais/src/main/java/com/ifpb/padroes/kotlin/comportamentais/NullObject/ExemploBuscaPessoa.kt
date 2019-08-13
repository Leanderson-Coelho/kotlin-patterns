package NullObject

abstract class AlunoAbstract (){
	abstract fun getNome(): String
	abstract fun getIdade(): Int
}

class Aluno(var nomeAluno:String, var idadeAluno: Int): AlunoAbstract() {
	
	override fun getNome(): String{
		return nomeAluno;
	}
	
	override fun getIdade(): Int{
		return idadeAluno;
	}
}

object AlunoNullObject : AlunoAbstract(){
	override fun getNome(): String{
		return "Não foi possível encontrar o aluno";
	}
	
	override fun getIdade(): Int{
		return 0;
	}
}

class BuscaAluno(){
	
	fun buscar(nomeBusca: String, alunos: List<AlunoAbstract>): AlunoAbstract{
		for (a in alunos){
			if(a.getNome().equals(nomeBusca))
				return a;
		}
		return AlunoNullObject;
	}
	
}

fun main(){
	var aluno1 = Aluno("Leanderson",18);
	var aluno2 = Aluno("João",15);
	var aluno3 = Aluno("Pedro",24);
	var aluno4 = Aluno("Maria",23);
	var aluno5 = Aluno("Bruna",17);
	var listaAlunos: ArrayList<AlunoAbstract> = ArrayList();
	listaAlunos.add(aluno1);
	listaAlunos.add(aluno2);
	listaAlunos.add(aluno3);
	listaAlunos.add(aluno4);
	listaAlunos.add(aluno5);
	
	var buscaDeAlunos: BuscaAluno = BuscaAluno();
	println(buscaDeAlunos.buscar("abc",listaAlunos).getNome());
	println(buscaDeAlunos.buscar("Leanderson",listaAlunos).getNome());
	println(buscaDeAlunos.buscar("Bruna",listaAlunos).getNome());
	println(buscaDeAlunos.buscar("Brina",listaAlunos).getNome());
}

