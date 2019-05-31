package Command

interface Command{
	fun execute(msg: String): Unit;
}

class MensagemPorSMSCommand: Command {
	override fun execute(msg: String): Unit{
		println("Mensagem eviada aos funcionários por SMS: $msg");
	}
}

class MensagemPorEmailCommand: Command {
	override fun execute(msg: String): Unit{
		println("Mensagem eviada aos funcionários por email: $msg");
	}
}

fun main(){
	var msgEmail : Command = MensagemPorEmailCommand();
	var msgSMS: Command = MensagemPorSMSCommand();
	msgEmail.execute("Reunião as 15h");
	msgSMS.execute("Reunião as 15h");
}