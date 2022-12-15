package nl.vintik.workshop.kotlin.basics

data class Unicorn(
    val id: String,
    val name: String,
    val type: UnicornType,
    /**
     * Nullable fields are explicit https://kotlinlang.org/docs/null-safety.html#nullable-types-and-non-null-types
     */
    val size: Int?,
    val magic: Int?,
    val description: String?
)