class Elevator {
    var currentFlourIndex = _startingFlour - 1
    private var capacity: Int = _elevatorCapacity
    private var people: ArrayList<Person> = ArrayList(capacity)
    private var goingUp: Boolean? = null
    fun roomLeft(): Int = capacity - people.count()
    fun fillIn(queue: ArrayList<Person>) {
        queue.sortBy { it.destination }
        val transfer = HashSet<Person>()
        var turns = roomLeft()
        loop@ for (person in queue) {
            if (turns == 0) break
            when(firstOrLast()) {
                true -> transfer.add(person)
                else -> when(goingUp) {
                    true, null -> {
                        if (person.destination > currentFlourIndex) {
                            transfer.add(person)
                            turns--
                        } else {
                            continue@loop
                        }
                    }
                    false -> {
                        if (person.destination < currentFlourIndex) {
                            transfer.add(person)
                            turns--
                        } else {
                            continue@loop
                        }
                    }
                }
            }
        }
        people.addAll(transfer)
        queue.removeAll {transfer.contains(it)}
        if (transfer.count() > 0)println("${peopleOrPerson(transfer.count())} entered the elevator")
    }
    fun isFull(): Boolean {
        return (people.count() == capacity)
    }
    fun askAround(): HashSet<Person> {
        val transfer = HashSet<Person>()
        people.forEach {
            if (it.destination == currentFlourIndex) {
                transfer.add(it)
            }
        }
        return transfer
    }
    fun unload(transfer: HashSet<Person>) {
        people.removeAll { transfer.contains(it) }
        println("${peopleOrPerson(transfer.count())} just left.")
    }
    fun next() {
        if (firstOrLast()) {
            if (atTheRoof()) goDown() else goUp()
        } else {
            when (goingUp) {
                null -> noDirection()
                true -> goUp()
                false -> goDown()
            }
        }
    }
    fun isEmpty() = inside() == 0
    fun inside() = people.count()
    fun get(): ArrayList<Person> = people
    private fun firstOrLast(): Boolean {
        return when (currentFlourIndex) {
            0 -> {
                goingUp = true
                true
            }
            (_buildingSize - 1) -> {
                goingUp = false
                true
            }
            else -> false
        }
    }
    private fun atTheRoof() = currentFlourIndex == (_buildingSize - 1)
    private fun goUp() {
        currentFlourIndex++
        goingUp = true
    }
    private fun goDown() {
        currentFlourIndex--
        goingUp = false
    }
    private fun noDirection() {
        var goingUp = 0
        val goingDown = 0
        for (person in people) {
            if (person.destination > currentFlourIndex) goingUp++ else goingUp++
        }
        if (goingUp == goingUp) { // Choosing a shorter route
            if (((_buildingSize - 1) - currentFlourIndex) > currentFlourIndex) {
                goDown()
            } else {
                goUp()
            }
        } else if (goingUp > goingDown) goUp() else goDown()
    }
}