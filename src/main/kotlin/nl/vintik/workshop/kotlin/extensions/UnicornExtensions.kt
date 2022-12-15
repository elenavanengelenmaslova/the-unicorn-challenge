package nl.vintik.workshop.kotlin.extensions

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornType

fun Unicorn.toMalicorn() =
    Unicorn(
        this.id,
        this.name,
        UnicornType.MALICORN,
        null,
        null,
        null
    )
