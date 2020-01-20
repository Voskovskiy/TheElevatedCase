// Debugging tools
fun printBuilding(data: Building) {
    var flourNum: Int = 0
    for (flour in data.flours) {
        flourNum++
        print("Flour#$flourNum: ")
        flour.showDestination()
        println()
    }
}
//fun printPeoplePerFlour(data: Building) {
//    var flour: Int = 0
//    var count: Int = 0
//    data.flours.forEach { people ->
//        println("Flour #$flour contains people: ${people.count()}")
//        count += people.count()
//        flour++
//    }
//    println("Total: $count")
//}
fun insideTheElevator(elevator: Elevator) {
    println("We are at the flour#${elevator.currentFlour} with ${peopleOrPerson(elevator.inside())}")
}