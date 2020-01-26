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
        if (turns != 0) {
            println("Flour #${elevator.currentFlourIndex + 1}:")
            val peopleLeftToDeliver = building.inside()
            if (peopleLeftToDeliver > 0) println("People waiting for the elevator: $peopleLeftToDeliver")
            println("Elevator: ${elevator.inside()}")
            separator()
        }
        if (building.isEmpty() and (elevator.isEmpty())) break      // Job is done!
        if (!elevator.isEmpty()) {
            val transfer = elevator.askAround()                     // Asking around if anyone arrived to this flour
            if (transfer.isNotEmpty())
                elevator.unload(transfer)    // Unloading if we have anyone to leave
        }
        if (building.currentFlourIsEmpty(elevator.currentFlourIndex) or elevator.isFull()) {
            elevator.next()
            turns++
            continue
        }
        if (elevator.roomLeft() > 0) {
            elevator.fillIn(building.flours[elevator.currentFlourIndex].people)
        }
        elevator.next()
        turns++
    }
    separator()
    println("All set! We finished in $turns turns!")
}
// Custom methods
fun separator() { repeat(30) { print("-") }; println() }
fun ranDom(min: Int = _minRandom, max: Int = _maxRandom): Int = (min..max).random()
fun peopleOrPerson(quantity: Int): String {
    return when(quantity) {
        0    -> "Nobody"
        1    -> "One person"
        else -> "$quantity people"
    }
}