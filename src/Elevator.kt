class Elevator {
    var currentFlourIndex = _startingFlour - 1
    private var capacity: Int = _elevatorCapacity
    private var people: ArrayList<Person> = ArrayList(capacity)
    private var goingUp: Boolean? = null
    fun roomLeft(): Int = capacity - people.count()
    fun fillIn(people: ArrayList<Person>, quantity: Int) {
        val transfer = HashSet<Person>()
        var turns = quantity
        loop@ for (person in people) {
            if (turns == 0) break
            when(firstOrLast()) {
                true -> { transfer.add(person) }
                else -> { // Pick according to the direction
                    when(goingUp) {
                        true -> {
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
                        null -> {
                            transfer.add(person)
                            turns--
                        }
                    }
                }
            }
        }
        this.people.addAll(transfer)
        people.removeAll {transfer.contains(it)}
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
        if (firstOrLast()) {    // Checking if we reached top or bottom
            if (atTheRoof()) goDown() else goUp()
        } else {
            when (goingUp) {
                null -> noDirection()
                true -> goUp()
                false -> goDown()
            }
        }
    }
    fun isEmpty(): Boolean {
        return this.inside() == 0
    }
    fun inside(): Int {
        return this.people.count()
    }
    private fun firstOrLast(): Boolean {
        return when (currentFlourIndex) {
            0 -> {
                this.goingUp = true
                true
            }
            (_buildingSize - 1) -> {
                this.goingUp = false
                true
            }
            else -> {
                false
            }
        }
    }
    private fun atTheRoof(): Boolean {
        return currentFlourIndex == (_buildingSize - 1)
    }
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