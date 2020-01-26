class Flour(current : Int = 0) {
    var people: ArrayList<Person> = ArrayList()
    init {
        for (i in 0 until ranDom())
            people.add(Person(current))
    }
    fun count() = people.count()
}