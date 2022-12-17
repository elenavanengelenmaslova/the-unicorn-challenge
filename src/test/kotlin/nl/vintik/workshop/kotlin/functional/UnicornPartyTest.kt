package nl.vintik.workshop.kotlin.functional

import nl.vintik.workshop.kotlin.basics.UnicornHouse
import org.junit.jupiter.api.Test

internal class UnicornPartyTest {

    @Test
    fun `should allow only big and bad unicorns to party hardy`() {
        val result = UnicornHouse().partyHardy()
    }

    @Test
    fun `should allow only good unicorns to party mildly`() {
        val result = UnicornHouse().partyMildly()
    }
}