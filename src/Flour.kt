class Flour(var current: Int = 1) {
    private var people: ArrayList<Person> = ArrayList<Person>()
    init {
        for (i in 0 until ranDom()) {
            people.add(Person(current))
        }
    }
    fun count(): Int {
        return people.count()
    }
    fun showDestination() {
        people.forEach() {
            print("${it.destination} ")
        }
    }
}