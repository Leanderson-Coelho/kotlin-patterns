package com.ifpb.kt.builder

class Pizza(var tamanho: Int,
			var queijo: Boolean,
			var tomate: Boolean
){
	override public fun toString(): String{
		return "Tamanho: "+this.tamanho+", Com Queijo? "+this.queijo+", Com Tomate? "+this.tomate;
	}
}

class Builder(val tamanho: Int){
	
 	var queijo : Boolean = false;
	var tomate : Boolean = false;
	
	public fun queijo(): Builder{
		this.queijo = true;
		return this;
	}
	
	public fun tomate(): Builder{
		this.tomate = true;
		return this;
	}
	
	public fun Build() : Pizza{
		return Pizza(this.tamanho, this.queijo, this.tomate);
	}
}

fun main(){
	var pizza : Pizza = Builder(2).queijo().tomate().Build();
	print(pizza.toString())
	
}