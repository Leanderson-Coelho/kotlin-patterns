package TemplateMethod

import java.io.File

//Classe que implementar deve fazer a leitura de um conteúdo de arquivo
interface ReadFile {
	fun readDataFile(path: String) : String
}

//Faz a leitura de arquivos DOC (somente exemplo)
class ReadFileDoc(): ReadFile{
	override fun readDataFile(path: String): String{
		return File(path).readText();
	}
}

//Faz a leitura de arquivos CSV (somente exemplo)
class ReadFileCSV(): ReadFile{
	override fun readDataFile(path: String): String{
		return File(path).readText();
	}
}

//Faz a leitura de arquivos PDF (somente exemplo)
class ReadFilePDF(): ReadFile{
	override fun readDataFile(path: String): String{
		return File(path).readText();
	}
}

//Classe ABSTRATA que faz a mineração de dados a partir de um arquivo
//params readerFile - recebe o tipo de leitor de arquivo
abstract class TemplateDataMine(val readerFile: ReadFile) {
	fun mine(origemArquivo: String) {
		//ler arquivo
		//hook method
		val resultadoLeitura: String = getDado(origemArquivo);
		//analizar já implementado
		analyze(resultadoLeitura);
	}
	
	//Analiza os dados (apenas mostra no console para exemplo)
	fun analyze(resultadoAnalize: String){
		println("Resultado: "+resultadoAnalize);
	}

	//HOOK METHOD
	abstract fun getDado(origemArquivo: String): String
}

//Mineração com arquivos do tipo DOC
//Classe que implementa a abstração de TemplateDataMine para fazer
//a mineração em arquivos DOC
class DocDataMiner(val readFileDoc: ReadFileDoc): TemplateDataMine(readFileDoc){
	
	//faz leitura somente de DOC
	override fun getDado(origemArquivo: String): String{
		return readFileDoc.readDataFile(origemArquivo);
	}
	
}

//Mineração com arquivos do tipo CSV
//Classe que implementa a abstração de TemplateDataMine para fazer
//a mineração em arquivos CSV
class CSVDataMiner(val readFileCSV: ReadFileCSV): TemplateDataMine(readFileCSV){
	
	//faz leitura somente de CSV
	override fun getDado(origemArquivo: String): String{
		return readFileCSV.readDataFile(origemArquivo);
	}
	
}

//Mineração com arquivos do tipo PDF
//Classe que implementa a abstração de TemplateDataMine para fazer
//a mineração em arquivos PDF
class PDFDataMiner(val readFilePDF: ReadFilePDF): TemplateDataMine(readFilePDF){
	
	//faz leitura somente de PDF
	override fun getDado(origemArquivo: String): String{
		return readFilePDF.readDataFile(origemArquivo);
	}
	
}



fun main() {
	// DOC
	var readFileDoc: ReadFileDoc = ReadFileDoc();
	var docDataMine: DocDataMiner = DocDataMiner(readFileDoc);
	docDataMine.mine("data.txt");
	// CSV
	var readFileCSV: ReadFileCSV = ReadFileCSV();
	var csvDataMine: CSVDataMiner = CSVDataMiner(readFileCSV);
	csvDataMine.mine("data.txt");
	// PDF
	var readFilePDF: ReadFilePDF = ReadFilePDF();
	var PDFDataMine: PDFDataMiner = PDFDataMiner(readFilePDF);
	PDFDataMine.mine("data.txt");
	
	
}