// The Elevated Case
// Default values
var _startingFlour = 1
const val _minRandom = 2            // At least 2 Flours or 2 people in the elevator
const val _maxRandom = 100          // Max size or capacity for Randomizer
var _elevatorCapacity = ranDom()    // Elevator capacity value(default if not reset)
var _buildingSize = ranDom()        // Building size value(default if not reset)
// Main method
fun main(args: Array<String>) {
    welcome()
    logic()
}
// The Logic is here!
fun logic() {
    val elevator = Elevator()
    val building = Building()
    val turns = 0 // Debug purposes
    while (true) {
        showElevator(elevator)
        printFlour(building, elevator.currentFlour)
        if (building.isEmpty() and (elevator.isEmpty())) break          // Job is done!
        val transfer = elevator.askAround()             // Asking around if anyone arrived to this flour
        if (transfer.isNotEmpty()) elevator.unload(transfer)            // Unloading if we have anyone to leave
        if (building.currentFlourIsEmpty(elevator.currentFlour - 1) or elevator.isFull()) { elevator.next(); continue; } // Nothing to do here!
        elevator.fillIn(building.flours[elevator.currentFlour - 1].people)  // Time to fill the elevator
        elevator.next()
        println()
    }
    println("Job's done! We spent $turns turns!")
}
// Debug section
// printBuilding(building)
// showFlours(ranDom(1), ranDom(2))