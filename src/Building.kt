class Building {
    var flours: Array<Flour>
    init {
        println("The building is ${_buildingSize} flours high")
        flours = Array(_buildingSize) { Flour() }
        for (i in flours.indices) {
            flours[i] = Flour(i)
        }
    }
    fun isEmpty(): Boolean {
        return this.inside() == 0
    }
    fun inside(): Int {
        var quantity: Int = 0
        flours.forEach { quantity += it.count() }
        return quantity
    }
    fun anyoneOnThisFlour(currentFlour: Int): Boolean {
        return flours[currentFlour].count() > 0
    }
    fun getPeopleFromThisFlour(currentFlour: Int, qty: Int, goingUp: Boolean): HashSet<Person> {
        var capacity = qty
        val transfer = HashSet<Person>()
        val flour = flours[currentFlour] // Pick a flour
        for (person in flour.people) {
            if (capacity == 0) break
            if (goingUp) {
                if (person.destination > currentFlour) transfer.add(person)
            } else {
                if (person.destination < currentFlour) transfer.add(person)
            }
            capacity--
        }
        return transfer
    }
    fun currentFlourIsEmpty(currentFlour: Int): Boolean {
        return flours[currentFlour].count() == 0
    }
}