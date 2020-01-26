class Person(current: Int) {
    var destination: Int = 0
    init {
            while (true) {
                destination = roll()
                if (destination != current) break
            }
        }
    private fun roll() = ranDom(0, (_buildingSize - 1))
}