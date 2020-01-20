// The Elevated Case
// Default values
var _startingFlour = 1
const val _minRandom = 2 // At least 2 Flours or 2 people in the elevator
const val _maxRandom = 100 // Max size or capacity for Randomizer
var _elevatorCapacity = ranDom() // Elevator capacity value(default if not reset)
var _buildingSize = ranDom() // Building size value(default if not reset)
// Main method
fun main(args: Array<String>) {
    welcome()
    val elevator = Elevator()
    val building = Building()
    // Debug
    // printBuilding(building)
    showFlours(ranDom(1))
}