class Person(current: Int) {
    var destination: Int = 0
    init {
            while (true) {
                roll()
                if (destination != (current - 1)) break
            }
        }
    private fun roll() {
        destination =  ranDom(0, (_buildingSize - 1))
    }
}