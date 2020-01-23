// Debugging tools
fun printBuilding(data: Building) {
    var flourNum = 0
    for (flour in data.flours) {
        flourNum++
        print("Flour#$flourNum: ")
        flour.showDestination()
        println()
    }
}
fun printFlour(data: Building, currentFlour: Int) {
    val people = data.flours[currentFlour].people
    println("[Flour#${currentFlour}]")
    if (people.count() == 0) { println("Empty") } else {
        people.forEach {
            print("[$it.destination] ")
        }
        println()
    }
}
fun insideTheElevator(elevator: Elevator) {
    println("We are at the flour#${elevator.currentFlour} with ${peopleOrPerson(elevator.inside())}")
}