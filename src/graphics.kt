// Graphics tools // ToDo: Need to finish Show flours!
fun welcome() = println("Welcome to the Elevated Case") // Going to use it for Args
fun showFlours(num: Int, qty: Int) {
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
        other(10, true)
    } else {
        var num2: Int = qty / _elevatorCapacity * 100
        when (qty) {
            in 1..10 -> {
                other(1,true, false)
                other(1, false, false)
                other(2, true)
            }
            in 10..20 -> {
                other(1,true, true)
                other(1, true, true)
                other(2, true)
            }
            in 30..40 -> {
                other(1,true, true)
                other(1, true, true)
                other(2, true)
            }
            in 50..60 -> {
                other(1,true, true)
                other(1, true, true)
                other(2, true)
            }
            in 70..80 -> {
                other(1,true, true)
                other(1, true, true)
                other(2, true)
            }
            in 90..99 -> {
                other(1,true, true)
                other(1, true, true)
                other(2, true)
            }
            100     -> { other(5, true, true) }
        }
    }
    print("][Capacity]")
    println()
}
fun other(reps: Int, type: Boolean = false, two: Boolean = true) {
    val j: Int = if (two) 2 else 1
    val char: String = if (type) "#" else ".."
    for (i in 0 until reps) {
        for (i: Int in 0 until j) print(char)
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