fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false

    // Аура
    val auraColor = auraColor(
        auraVisible(isBlessed, healthPoints, isImmortal)
    );

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    /**
     * fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Guyal"))
    }

    fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
    val currentYear = 2018
    numBuildings += 1
    println("Adding $numBuildings $structureType")
    "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    }
     */
    runSimulation("Guyal", ::printConstructionCost) { playerName, numBuildings ->
        val currentYear = 2018
        println("Adding $numBuildings houses")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }

    // Состояние игрока
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)
    castFireball(3)
    performCombat()
    performCombat("Ulrich")
    performCombat("Hildr", true)

}

private inline fun runSimulation(costPrinter: (Int) -> Unit,
                                 playerName: String,
                                 greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).shuffled().last() // Случайно выберет 1, 2 или 3
    costPrinter(numBuildings)
    println(greetingFunction(playerName, numBuildings))
}

private  fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("${numBuildings}")
    println("construction cost: ${cost * numBuildings}")
}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds, but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }
    return healthStatus
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(
    auraVisible: Boolean
): String = if (auraVisible) "GREEN" else "NONE";


private fun auraVisible (isBlessed: Boolean,
                         healthPoints: Int,
                         isImmortal: Boolean):Boolean = isBlessed && healthPoints > 50 || isImmortal;

/**
 * Уровень Состояние
1–10 Tipsy (навеселе)
11–20 Sloshed (выпивший)
21–30 Soused (пьяный)
31–40 Stewed (сильно пьяный)
41–50 ..t0aSt3d (в стельку)
 */
private fun castFireball(numFireballs: Int = 2) {
    println("A glass of Fireball springs into existence. (x$numFireballs)")
}

fun shouldReturnAString(): String {
    TODO("implement the string building functionality here to return a string")
}

fun performCombat() {
    println("You see nothing to fight!")
}
fun performCombat(enemyName: String) {
    println("You begin fighting $enemyName.")
}
fun performCombat(enemyName: String, isBlessed: Boolean) {
    if (isBlessed) {
        println("You begin fighting $enemyName. You are blessed with 2X damage!")
    } else {
        println("You begin fighting $enemyName.")
    }
}