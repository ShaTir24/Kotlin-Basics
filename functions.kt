/*in this code we are implementing two things:
1. Checking if there is any need of cleanliness.
2. Control the temperature of refrigerator*/

/* Main focus is to highlight the use of various 
kind of function types available in Kotlin */

fun main() {  //accepts input and checks by invoking other methods
    print("Enter the dirty index : ")
    val dirty = readLine()?.toInt() ?: 1  //if null is entered, 1 takes as default value
    print("Enter the temperature of refrigerator : ")
    val temp = readLine()?.toInt() ?: 15  //if null is entered, 15 takes as default value
  
    println(tempManage(isTooHot, temp)) 
    println(tempManage(isTooCold, temp))
    println(dirtyManager(dirty))
}
//member function to check whether entered temperature value is ideal for a refrigerator
fun tempManage(operation : (Int) -> Boolean, temp : Int) : String{  //takes a function as an argument and an integer variable. 
    return when {                                                   //represents higher order function
        operation(temp) -> "Turn the temperature dial down."
        operation(temp) -> "Turn the temperature dial up."
        else -> "Temperature is fine."
    }
}
fun dirtyManager(dirt : Int) : String { //traditional function taking an integer variable as an argument
    return when {
        dirt > 30 -> "Needs to clean."
        dirt < 10 -> "Very clean."
        else -> "Not very dusty."
    }
}
var isTooHot : (Int) -> Boolean = {temp -> temp > 18} //lambda function checks if temp is too hot
var isTooCold : (Int) -> Boolean = {temp -> temp < 0} //lambda function checks if temp is too cold
