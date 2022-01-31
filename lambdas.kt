enum class Directions { //repository of all directions
    NORTH,
    SOUTH,
    EAST,
    WEST,
    START,
    END
}
class Game {  //class to initialize all directin variables using lambda functions
    var path = mutableListOf<Directions>(Directions.START)  //initialising path which is list of all directions
    val north = {path.add(Directions.NORTH)}  //lambda to assign NORTH
    val south = {path.add(Directions.SOUTH)}
    val east = {path.add(Directions.EAST)}
    val west = {path.add(Directions.WEST)}
    val end = { //lambda function returning Boolean value 
        path.add(Directions.END);
        println("Game Over");
        println(path);
        path.clear();
        false
    }
}

fun main() {  //main method to call other member functions
    val ga = Game()
    println(ga.path)
    ga.north()
    ga.east()
    ga.south()
    ga.west()
    ga.end()
    println(ga.path)
}
