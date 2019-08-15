abstract class Parede(val altura: Float, val espessura: Float) : Cloneable {
	override public fun clone(): Any {
		return super.clone()
	}
}

class Arbusto(alturap: Float, espessurap: Float) : Parede(alturap, espessurap) {

}

abstract class Piso(val espessura: Float) {

}

class Pedra(espessura: Float) : Piso(espessura), Cloneable {

	override public fun clone(): Any {
		return super.clone()
	}
}

fun main() {
	var pedra = Pedra(2f);
	print(pedra);
	print(pedra.clone());
}





