class Elevator() {
    private var people: ArrayList<Person>
    private var capacity: Int = _elevatorCapacity
    var currentFlour: Int = _startingFlour
    var goingUp: Boolean = false
    init {
        println("The elevator is able to fit $capacity people, this time")
        this.people = ArrayList<Person>(capacity)
    }
    fun inside(): Int {
        return this.people.count()
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
}