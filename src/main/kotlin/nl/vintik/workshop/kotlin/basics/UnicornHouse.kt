package nl.vintik.workshop.kotlin.basics

class UnicornHouse {
    /**
     * Collections such as list or map by default are immutable, you need to explicitly specify one as mutable
     * For more see https://kotlinlang.org/docs/list-operations.html
     */
    private val unicorns = mutableListOf<Unicorn>()

    /**
     * When expression example, for more see https://kotlinlang.org/docs/control-flow.html#when-expression
     * @param unicorn is defined as not null
     */
    fun enter(unicorn: Unicorn): String {
        unicorns.add(unicorn)
        return when (unicorn.type) {
            UnicornType.UNICORN -> "Welcome European Unicorn ${unicorn.name}"
            UnicornType.DEMICORN -> "Welcome Mild Magic Unicorn ${unicorn.name}"
            UnicornType.MALICORN -> "Welcome Malicious Unicorn ${unicorn.name}"
        }
    }

    fun exit(unicornId: String) = unicorns.removeIf { it.id == unicornId }
}