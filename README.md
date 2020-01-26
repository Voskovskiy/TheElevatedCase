# TheElevatedCase

Simple console application written in Kotlin.

**Task:**
We have a building with random number of flours (2-100 by default). You have an elevator with random capacity(2-100) and random number of people around.
The idea is to delvier people to the destonation flour as faster as possible.
In the main.kt file you may find:
// Global variables
* **var _startingFlour** : Starting flour, do not confuse with Array Index(let the code do the work)
* **const val _minRandom** : Minimal Int for the Randomizer method ranDom (Int, Int) -> Int
* **const val _maxRandom** : Maximum value for the Randomizer
* **var _elevatorCapacity** : This is how we get the elevator sized
* **var _buildingSize** : Same with the quantity of the flour of the generated building
