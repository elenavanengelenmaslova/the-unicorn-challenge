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

fun Unicorn.computePower() = this.size?.let { this.magic?.times(this.size) }

fun List<Unicorn>.filterByType(vararg unicornType: UnicornType) = this.filter { it.type in unicornType }

fun List<Unicorn>.filterBySize(sizeFrom: Int) =
    this.filter { unicorn -> unicorn.size?.let { it >= sizeFrom } ?: false }
