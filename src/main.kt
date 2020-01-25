// The Elevated Case
// Global variables
var _startingFlour = 1
const val _minRandom = 2
const val _maxRandom = 100
var _elevatorCapacity = ranDom()
var _buildingSize = ranDom()
// Main method
fun main(args: Array<String>) {
    println("Welcome to the Elevated Case")
    separator()
    val elevator = Elevator()
    val building = Building()
    var turns = 0
    while (true) {
        showBuilding(building)
        showElevator(elevator)
        if (building.isEmpty() and (elevator.isEmpty())) break      // Job is done!
        if (!elevator.isEmpty()) {
            val transfer = elevator.askAround()                     // Asking around if anyone arrived to this flour
            if (transfer.isNotEmpty()) elevator.unload(transfer)    // Unloading if we have anyone to leave
        }
        if (building.currentFlourIsEmpty(elevator.currentFlourIndex) or elevator.isFull()) {
            elevator.next(); turns++; continue
        }
        if (elevator.roomLeft() > 0) {
            elevator.fillIn(building.flours[elevator.currentFlourIndex].people)
        }
        elevator.next()
        turns++
        println("Flour #${elevator.currentFlourIndex + 1}:")
        val peopleLeftToDeliver = building.flours.count()
        if (peopleLeftToDeliver > 0) println("People left: $peopleLeftToDeliver")
        println("Elevator: ${elevator.inside()}")
        separator()
    }
    separator()
    println("All set! We finished in $turns")
}
// Custom methods
fun separator() { repeat(20) { print("-") }; println() }
fun ranDom(min: Int = _minRandom, max: Int = _maxRandom): Int = (min..max).random()
fun peopleOrPerson(quantity: Int): String {
    return when(quantity) {
        0    -> "Nobody"
        1    -> "One person"
        else -> "$quantity people"
    }
}
// Debug methods
fun showBuilding(building: Building) {
    println("Building start")
    building.flours.forEach {
        showFlour(it)
    }
}
fun showFlour(flour: Flour) {
    print("Flour: ")
    flour.people.forEach {
        print("[${it.destination}] ")
    }
    println()
}
fun showElevator(elevator: Elevator) {
    print("Elevator: ")
    elevator.get().forEach {
        print("[${it.destination}] ")
    }
    println()
}