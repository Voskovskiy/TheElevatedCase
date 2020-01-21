// The Elevated Case
/* ToDo:
    1. Build a logic!
    2. Fix showElevator - It is broken!
    3. Rework Person class
*/
// Default values
var _startingFlour = 1
const val _minRandom = 2 // At least 2 Flours or 2 people in the elevator
const val _maxRandom = 100 // Max size or capacity for Randomizer
var _elevatorCapacity = ranDom() // Elevator capacity value(default if not reset)
var _buildingSize = ranDom() // Building size value(default if not reset)
// Main method
fun main(args: Array<String>) {
    welcome()
    // ToDo: Need to put Args checker or reset default val's!
    logic()
}
fun logic() {
    val elevator = Elevator()
    val building = Building()
    val turns: Int = 0 // Debug purposes
    while (true) {
        val transfer = elevator.askAround() // Asking around if anyone arrived to this flour
        if (transfer.isNotEmpty()) elevator.unload(transfer) // If we have to
        if (building.countPeople() == 0) break // Do we have any more people to move?
        when (elevator.firstOrLast()) {
            true -> { // First or Last Flour we take all, if we have any room left

            }
            false -> { // Middle case

            }
        }
    }
    println("Job's done! We spent $turns turns!")
}

// Debug section
// printBuilding(building)
// showFlours(ranDom(1), ranDom(2))