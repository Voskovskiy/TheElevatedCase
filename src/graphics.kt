// Graphics tools
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
        for (i in 1..10) print(".")
    } else {

    }
    print("]")
    println()
}
fun other(reps: Int) {
    for (i in 0 until reps)
        print("....")
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