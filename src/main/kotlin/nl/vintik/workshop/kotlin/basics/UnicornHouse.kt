package nl.vintik.workshop.kotlin.basics

import nl.vintik.workshop.kotlin.extensions.filterBySize
import nl.vintik.workshop.kotlin.extensions.filterByType
import java.util.UUID

class UnicornHouse {
    /**
     * Collections such as list or map by default are immutable, you need to explicitly specify one as mutable
     * For more see https://kotlinlang.org/docs/list-operations.html
     */
    val unicorns = mutableListOf<Unicorn>()

    /**
     * When expression example, for more see https://kotlinlang.org/docs/control-flow.html#when-expression
     * @param unicorn is defined as not null
     */
    fun enter(unicorn: Unicorn): String {
        unicorns.add(unicorn)
        unicorn.description?.let {
            println("Unicorn description: $it")
        }
        return when (unicorn.type) {
            UnicornType.UNICORN -> "Welcome European Unicorn ${unicorn.name}"
            UnicornType.DEMICORN -> "Welcome Mild Magic Unicorn ${unicorn.name}"
            UnicornType.MALICORN -> "Welcome Malicious Unicorn ${unicorn.name}"
        }
    }

    fun bulkEnter(vararg unicorn: Unicorn): List<String> = unicorn.map { enter(it) }

    fun exit(unicornId: UUID) = unicorns.removeIf { it.id == unicornId }

    fun countUnicorns() = unicorns.size

    fun countUnicornsByType(unicornType: UnicornType) = unicorns.count { it.type == unicornType }

    fun mapUnicornsByType() = unicorns.associateBy { it.type }

    fun orderUnicornsBySizeDescending() = unicorns.sortedByDescending { it.size }

    fun filterUnicornsByType(vararg unicornType: UnicornType) = unicorns.filterByType(*unicornType)

    fun filterUnicornsBySize(sizeFrom: Int) =
        unicorns.filterBySize(sizeFrom)

    fun totalMagicInDaHouse() = unicorns.sumOf { it.magic ?: 0 }

}