class Elevator {
    private var people: ArrayList<Person>
    private var capacity: Int = _elevatorCapacity
    var currentFlour: Int = _startingFlour
    var goingUp: Boolean? = null
    init {
        println("The elevator is able to fit $capacity people, this time")
        this.people = ArrayList<Person>(capacity)
    }
    fun inside(): Int {
        return this.people.count()
    }
    fun isEmpty(): Boolean {
        return this.inside() == 0
    }
    fun checkCapacity(quantity: Int): Boolean {
        return (quantity > this.capacity)
    }
    fun leftCapacity(quantity: Int): Int {
        return capacity - people.count() // How many people we may fit in?
    }
    fun fill(data: ArrayList<Person>) {
        people.addAll(data)
    }
    fun isFull(): Boolean {
        return (people.count() == capacity)
    }
    fun firstOrLast(): Boolean {
        return when (currentFlour) {
            1 -> {
                this.goingUp = true
                true
            }
            _buildingSize -> {
                this.goingUp = false
                true
            }
            else -> {
                false
            }
        }
    }
    fun askAround(): HashSet<Person> {
        val transfer = HashSet<Person>()
        people.forEach {
            if (it.destination == currentFlour) {
                transfer.add(it)
            }
        }
        return transfer
    }
    fun unload(transfer: HashSet<Person>) {
        people.removeAll { transfer.contains(it) }
        println("${peopleOrPerson(transfer.count())} just left.")
    }
    private fun atTheRoof(): Boolean {
        return currentFlour == _buildingSize
    }
    fun next() {
        if (people.count() == 0) {  // We do not have any people to ask the direction
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
    }
    private fun goUp() {
        currentFlour++
        goingUp = true
    }
    private fun goDown() {
        currentFlour--
        goingUp = false
    }
    private fun noDirection() {
        val peopleGoingUp = HashSet<Person>()
        val peopleGoingDown = HashSet<Person>()
        for (person in people) {
            if (person.destination > currentFlour) {
                peopleGoingUp.add(person)
            } else {
                peopleGoingDown.add(person)
            }
        }
        if (peopleGoingUp.count() > peopleGoingDown.count()) {
            goUp()
        } else {
            goDown()
        }
    }
}