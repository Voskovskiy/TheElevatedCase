class Building() {
    var flours: Array<Flour>
    init {
        println("The building is ${_buildingSize} flours high")
        flours = Array(_buildingSize) { Flour() }
        for (i in flours.indices) {
            flours[i] = Flour(i)
        }
    }
    fun countPeople(): Int {
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
//    fun inside(): Int {
//        var people: Int = 0
//        this.flours.forEach {
//            people += it.count()
//        }
//        return people
//    }
//    fun peopleHere(flour: Int): Int {
//        return this.flours[flour-1].count()
//    }
//    fun firstOrLast(current: Int, size: Int = flours.count()): Boolean{
//        return ((current == size) or (current == 1))
//    }
//    fun getAll(flour: Int, quantity: Int): ArrayList<Person> {
//        val transfer = ArrayList<Person>()
//        for (i in 0 until quantity) {
//            transfer.add(flours[flour][i])
//        }
//        println("${peopleOrPerson(transfer.count())} entered the elevator on flour #$flour")
//        flours[flour].removeAll(transfer)
//        return transfer
//    }
}