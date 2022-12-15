package nl.vintik.workshop.kotlin.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornHouse
import nl.vintik.workshop.kotlin.basics.UnicornType
import java.util.*
import kotlin.random.Random

// Check out what zip does
// Debug to see coroutines working
// Fill unicorn house with unicorns
// make unicorns list accessible from outside the class
// and let them eat Christmas dinner, display name of unicorn for each println

val plates = listOf(
    "Stuffed Turkey",
    "Roast Potatoes",
    "Pigs in Blankets",
    "Yorkshire Pudding",
    "Brussel Sprouts"
).zip(listOf("30", "20", "15", "20", "15"))

fun main() {
    runBlocking {
        eatChristmasDinner(fillDaHouse().unicorns)
    }
}

suspend fun eatChristmasDinner(unicorns: List<Unicorn>) {
    coroutineScope {
        unicorns.forEach { unicorn ->
            println("The Unicorn ${unicorn.name} came in!")
            plates.forEach { plate ->
                launch {
                    serveAndEat(unicorn, plate)
                }
            }
        }

    }
    println("Is everyone done?")
}

suspend fun serveAndEat(unicorn: Unicorn, plate: Pair<String, String>) {
    val (dish, size) = plate
    delay(Random.nextLong(100, 3000))
    println("${unicorn.name}: I got my food, let me start eating this: $dish that's $size cm")
    delay(Random.nextLong(100, 3000))
    println("${unicorn.name} I'm done eating: $dish that's $size cm")
}

fun fillDaHouse(): UnicornHouse {
    val badUnicorn = Unicorn(
        UUID.randomUUID(),
        "Bob",
        UnicornType.MALICORN,
        20,
        10,
        "Bad unicorn"
    )
    val europeanUnicorn = Unicorn(
        UUID.randomUUID(),
        "Jane",
        UnicornType.UNICORN,
        10,
        30,
        "Euro unicorn"
    )
    val mildUnicorn = Unicorn(
        UUID.randomUUID(),
        "John",
        UnicornType.DEMICORN,
        null,
        null,
        null
    )
    val daHouse = UnicornHouse()
    daHouse.enter(badUnicorn)
    daHouse.enter(europeanUnicorn)
    daHouse.enter(mildUnicorn)
    return daHouse
}
