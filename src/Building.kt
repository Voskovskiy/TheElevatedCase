class Building {
    var flours: Array<Flour>
    init {
        println("The building is $_buildingSize flours high")
        flours = Array(_buildingSize) {Flour()}
        for (i in flours.indices) {
            flours[i] = Flour(i)
        }
    }
    fun isEmpty(): Boolean = (inside() == 0)
    fun currentFlourIsEmpty(currentFlourIndex: Int): Boolean = (flours[currentFlourIndex].count() == 0)
    fun peopleAtThisFlour(currentFlourIndex: Int): Int = flours[currentFlourIndex].count()
    private fun inside(): Int {
        var quantity = 0
        flours.forEach { quantity += it.count() }
        return quantity
    }
}