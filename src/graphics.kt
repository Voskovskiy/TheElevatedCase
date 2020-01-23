// Graphics tools
fun welcome() = println("Welcome to the Elevated Case") // Going to use it for Args
fun showElevator(elevator: Elevator) {
    val num: Int = elevator.currentFlour
    val qty: Int = elevator.inside()
    print("[The Elevator][")
    when (num) {
        1         -> { print("$num..."); other(4) }
        in 1..5   -> { print(".$num.."); other(4) }
        in 5..9   -> { print("..$num."); other(4) }
        in 10..20 -> { other(1); mid(num); other(3) }
        in 20..40 -> { other(1); mid(num); other(3) }
        in 40..60 -> { other(2); mid(num); other(2) }
        in 60..80 -> { other(3); mid(num); other(1) }
        in 80..99 -> { other(4); mid(num); }
        100       -> { other(3); print(".$num")}
    }
    print("][Current flour][")
    if (qty == 0) {
        other(10, false)
    } else {
        when (qty) {
            in 1..20 -> {
                other(1, empty = false, two = false)
                other(2, empty = true, two = false)
            }
            in 21..40 -> {
                other(1, empty = false, two = false)
                other(3, empty = true, two = true)
            }
            in 41..60 -> {
                other(3, empty = false)
                other(1, empty = true)
            }
            in 61..80 -> {
                other(2, empty = false, two = false)
                other(1, empty = true)
            }
            in 81..100     -> { other(5, empty = true, two = true) }
        }
    }
    print("][Capacity]")
    println()
}
fun other(reps: Int, empty: Boolean = false, two: Boolean = true) {
    val j: Int = if (two) 1 else 2
    val char: String = if (empty) ".." else "#"
    repeat(reps) {
        repeat(j) {
            print(char)
        }
    }
}
fun mid(num: Int) {
    when (num % 10) {
        in 1..4 -> { print("$num..") }
        5       -> { print(".$num.") }
        in 6..9 -> { print("..$num") }
    }
}
fun peopleOrPerson(quantity: Int): String {
    return when(quantity) {
        0    -> "nobody"
        1    -> "one person"
        else -> "$quantity people"
    }
}