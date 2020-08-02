package com.weather.vmware.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testLatLonRoundValues() {
        Location loc = new Location(213.123d, 234.12353452d, "Broomfield", "Colorado");

        assertEquals(213.1230d, loc.getLat());
        assertEquals(234.1235d, loc.getLon());
    }

}