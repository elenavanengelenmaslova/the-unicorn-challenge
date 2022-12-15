package nl.vintik.workshop.kotlin.basics

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.UUID

internal class UnicornHouseTest {
    private lateinit var unicornHouse: UnicornHouse
    private lateinit var badUnicornId: UUID
    private lateinit var badUnicorn: Unicorn
    private lateinit var europeanUnicorn: Unicorn
    private lateinit var mildUnicorn: Unicorn

    @BeforeEach
    fun setUp() {
        unicornHouse = UnicornHouse()
        badUnicornId = UUID.randomUUID()
        badUnicorn = Unicorn(
            badUnicornId,
            "Bob",
            UnicornType.MALICORN,
            20,
            10,
            "Bad unicorn"
        )
        europeanUnicorn = Unicorn(
            UUID.randomUUID(),
            "Jane",
            UnicornType.UNICORN,
            10,
            30,
            "Euro unicorn"
        )
        mildUnicorn = Unicorn(
            UUID.randomUUID(),
            "John",
            UnicornType.DEMICORN,
            null,
            null,
            null
        )
    }

    @Test
    fun `should add unicorn on enter`() {
        assertEquals("Welcome European Unicorn Jane", unicornHouse.enter(europeanUnicorn))
        assertEquals("Welcome Malicious Unicorn Bob", unicornHouse.enter(badUnicorn))
        assertEquals(2, unicornHouse.countUnicorns())
        assertEquals(1, unicornHouse.countUnicornsByType(UnicornType.MALICORN))
        assertEquals(1, unicornHouse.countUnicornsByType(UnicornType.UNICORN))
    }

    @Test
    fun `should remove unicorn on exit`() {
        unicornHouse.enter(badUnicorn)
        unicornHouse.enter(europeanUnicorn)
        assertEquals(2, unicornHouse.countUnicorns())

        unicornHouse.exit(badUnicornId)
        assertEquals(0, unicornHouse.countUnicornsByType(UnicornType.MALICORN))
        assertEquals(1, unicornHouse.countUnicorns())
        assertEquals(1, unicornHouse.countUnicornsByType(UnicornType.UNICORN))
    }

    @Test
    fun `should map unicorns by type`() {
        unicornHouse.enter(badUnicorn)
        unicornHouse.enter(europeanUnicorn)

        val result = unicornHouse.mapByType()
        assertEquals(2, result.size)
        assertSame(badUnicorn, result[UnicornType.MALICORN])
        assertSame(europeanUnicorn, result[UnicornType.UNICORN])
    }

    @Test
    fun `should order unicorns by size`() {
        unicornHouse.enter(mildUnicorn)
        unicornHouse.enter(badUnicorn)
        unicornHouse.enter(europeanUnicorn)

        val result = unicornHouse.orderBySizeDescending()
        assertEquals(UnicornType.MALICORN, result[0].type)
        assertEquals(UnicornType.UNICORN, result[1].type)
        assertEquals(UnicornType.DEMICORN, result[2].type)
    }

    @Test
    fun `should count total magic in the house`() {
        unicornHouse.enter(mildUnicorn)
        unicornHouse.enter(badUnicorn)
        unicornHouse.enter(europeanUnicorn)

        assertEquals(40, unicornHouse.totalMagicInDaHouse())
    }
}