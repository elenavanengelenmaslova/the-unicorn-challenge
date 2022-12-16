package nl.vintik.workshop.kotlin.functional

import nl.vintik.workshop.kotlin.basics.UnicornHouse
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class UnicornPartyTest {

    @Test
    fun `should allow only big unicorns to party hardy`() {
        val result = UnicornHouse().partyHardy()
    }
}