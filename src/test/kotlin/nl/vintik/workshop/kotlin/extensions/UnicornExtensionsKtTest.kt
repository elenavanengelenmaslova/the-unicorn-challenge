package nl.vintik.workshop.kotlin.extensions

import nl.vintik.workshop.kotlin.basics.Unicorn
import nl.vintik.workshop.kotlin.basics.UnicornType
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

internal class UnicornExtensionsKtTest {

    @Test
    fun `should convert to any unicorn to malicorn`() {
        val unicorn = Unicorn(
            UUID.randomUUID(),
            "Nelly",
            UnicornType.DEMICORN,
            null,
            null,
            null
        )
        val result = unicorn.toMalicorn()
        assertEquals(UnicornType.MALICORN, result.type)
    }
}