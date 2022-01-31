open class WaterSupply(var needsProcessed: Boolean) //blueprint class of water supplies
class TapWater: WaterSupply(true) { //tap water type class
    fun addChemicalCleaners() {   //property function
        needsProcessed = false
    }
}

class PondWater: WaterSupply(true) {  //pond water type class
    fun filtration() {            //property function
        needsProcessed = false
    }
}
class Aquarium<T: WaterSupply> (val waterSupply: T) { //class implementing types of water supplies using generic T
    fun addWater(cleaner: Cleaner<T>) {
        if(waterSupply.needsProcessed)
            cleaner.clean(waterSupply)
        println("Adding water from source: ${waterSupply::class.simpleName}")
    }
}
//inline function checking entered water supply is same as current water supply.
//it uses isCheck which requires variable to be real or reified (as it should be available in its previous stage during runtime after compilation is over)
inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R   //* takes any generic irrespective of its type
  
interface Cleaner<in T: WaterSupply> {  //interface to clean a water supply
    fun clean(waterSupply: T)
}
class TapWaterCleaner: Cleaner<TapWater> {  //class implementing interface to clean water supply specific to tap water
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}
fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {  //function to check whether water supply is clean 
    println("Water added is clean : ${aquarium.waterSupply.needsProcessed}")
}

fun main() {
    val cleaner = TapWaterCleaner()
    val aquarium = Aquarium<TapWater>(TapWater()) //object of type water supply with tap water
    aquarium.addWater(cleaner)
    isWaterClean(aquarium)  //false
    aquarium.hasWaterSupplyOfType<TapWater>()   //true

    val aqua1 = Aquarium<PondWater>(PondWater())  //object of type water supply with pond water
    aqua1.waterSupply.filtration()
}
