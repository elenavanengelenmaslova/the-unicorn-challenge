package nl.vintik.workshop.kotlin.functional

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornHouse


fun UnicornHouse.partyHardy(): List<String> {
    val faceControl = this::filterBigUnicorns
    return party(faceControl)
}

private fun party(faceControl: () -> List<Unicorn>) = faceControl.invoke().map { it.name }

