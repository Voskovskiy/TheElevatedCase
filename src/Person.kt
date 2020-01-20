class Person(current: Int) {
    var destination: Int
    init {
        destination = ranDom(1, _buildingSize)
        if (destination == current) { destination = ranDom(1, _buildingSize) } // Reroll in case match
    }
}