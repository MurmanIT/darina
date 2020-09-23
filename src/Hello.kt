const val MAX_EXPERIENCE: Int = 500;

private fun hasStreed (hasStreed: Boolean = false) {
    if (hasStreed) {
        println("You have streed");
    } else {
        println("You don't have streed");
    }
}

private fun karma(healthPoints: Int): Int {
    return  (Math.pow(Math.random(), (110 - healthPoints) / 100.0 )*20).toInt();
}

private fun aura(healthPoints: Int, karma: Int): String {
    val aura: String = when(karma) {
        in 16..20 -> "GREEN"
        in 11..15 -> "PURPLE"
        in 6..10 -> "ORANGE"
        else -> "RED"
    }
    return aura;
}

private fun isBlessed(isBlessed:Boolean = true) =  if (isBlessed) {
        " has some minor wounds but is...";
    } else {
        " has some minor wounds";
    }

private fun madrigal(playerName: String, healthPoints: Int = 100, isBld: Boolean = true):String {
    val health: String = when (healthPoints) {
        100 -> " is in excellent condition!"
        in 90..99 -> " has a few scratches"
        in 75..89 -> isBlessed(isBld)
        in 15..74 -> " looks pretty hurt."
        else -> " is in awful condition!"
    }
    return "$playerName $health";
}

fun main(args: Array<String>) {
    val playerName: String = "Estragon";
    val healthPoints = 89;
    println("(HP: $healthPoints)(Aura: ${aura(healthPoints, karma(healthPoints))})->${madrigal("Madrigal", healthPoints, true)}")
}