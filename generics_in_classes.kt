open class BaseBuildingMaterial(var numberNeeded: Int = 1)  //blueprint class describing building material
class Wood: BaseBuildingMaterial(4)   //type class of Wood
class Brick: BaseBuildingMaterial(8)  //type class of Brick

class Buildings<out T: BaseBuildingMaterial>(private val material: T) { //main class implementing building materials to build a building
                                                                        //T represents data type of class BaseBuildingMaterial
                                                                        //it takes constructor of class type BasicBuildingMaterial as its Parameter
    private val baseMaterialNeeded = 100
    private val actualMaterialsNeeded = material.numberNeeded * baseMaterialNeeded  //calculating total base material required

    fun build() {             //function displaying the building material used and no. of units required
        println("Material is ${material::class.simpleName} and units required are $actualMaterialsNeeded")
    }
}

fun main() {
    val woody = Buildings<Wood>(Wood()) //object of a buliding creating with wood
    println(woody.build())

    val apt = Buildings<Brick>(Brick()) //object of a building created with brick
    println(apt.build())
}
