package Command

interface Command{
	fun execute(msg: String): Unit;
}

class MensagemPorSMSCommand: Command {
	override fun execute(msg: String){
		println("Mensagem eviada aos funcionários por SMS: $msg");
	}
}

class MensagemPorEmailCommand: Command {
	override fun execute(msg: String){
		println("Mensagem eviada aos funcionários por email: $msg");
	}
}

class EnviarMensagensFuncionarios(){
	private val queue = ArrayList<Command>();
	
	fun addCommand(novoCommand: Command){
		queue.add(novoCommand);
	}
	
	fun enviarMensagem(msg: String){
		queue.forEach {it.execute(msg)}
	}
}

fun main(){
	var commandProcessor: EnviarMensagensFuncionarios = EnviarMensagensFuncionarios();
	commandProcessor.addCommand(MensagemPorEmailCommand());
	commandProcessor.addCommand(MensagemPorSMSCommand());
	commandProcessor.enviarMensagem("Reunião as 16h");
}