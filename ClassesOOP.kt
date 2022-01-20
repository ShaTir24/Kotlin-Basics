/* Exqmple demonstrating use of abstract classes and interfaces in Kotliln
we'll describe two properties of Fishes: color and eat*/
abstract class AquariumFish { //describes the color property to be inherited by sub-class
    abstract var color: String
}
interface FishAction {  //describes the eat property to be inherited by sub-class
    fun eat() {}
}
class Shark: AquariumFish(), FishAction { //inherits an abstract class and interface
    override var color: String = "gray" //override keyword to assign value of super-class variable
    override fun eat() {
        println("Hunt and eat fish")
    }
}
class Carassius: AquariumFish(), FishAction {
    override var color: String = "gold"
    override fun eat() {
        println("Munch on Algae")
    }
}

fun feedFish(fish: FishAction) {  //method to print eat property of Fish
    fish.eat()
}
fun makeFish() {  //method to create instances and call member methods
    val shark = Shark() //instance of a class
    val carass = Carassius()
    println("Color of Shark is ${shark.color} and of Plasethomus is ${carass.color}")
    feedFish(shark)
    feedFish(carass)
}

fun main() {
  makeFish()
}
