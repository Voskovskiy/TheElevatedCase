class Building {
    var flours: Array<Flour>
    init {
        println("The building is $_buildingSize flours high")
        flours = Array(_buildingSize) {Flour()}
        for (i in flours.indices)
            flours[i] = Flour(i)
    }
    fun isEmpty() = (inside() == 0)
    fun currentFlourIsEmpty(currentFlourIndex: Int) = (flours[currentFlourIndex].count() == 0)
    fun inside() = flours.fold(0) { result, floor -> result + floor.count() }
}