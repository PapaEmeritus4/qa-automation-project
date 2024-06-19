package org.example.djinni;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.example.utils.BaseTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.*;

public class DjinniTest extends BaseTest {

    private final static String URL = "https://djinni.co/q/6a448d8f5a/";

    @Test
    public void testCheckAttributesByHashMap() {
        DjinniResumePage djinniResumePage = new DjinniResumePage(URL);

        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(DjinniResumePage.GENDER, "Ч");
        expectedAttributes.put(DjinniResumePage.EXPERIENCE, 6);
        expectedAttributes.put(DjinniResumePage.CITY, "Одеса");
        expectedAttributes.put(DjinniResumePage.READY_TO_RELOCATE, true);

        Map<String, Object> actualAttributes = djinniResumePage.getAttributes();

        assertNotNull(actualAttributes);
        assertEquals(expectedAttributes, actualAttributes);
    }

    @Test
    public void testCheckAttributesByObject() {
        DjinniResumePage djinniResumePage = new DjinniResumePage(URL);
        Resume expectedAttributes = new Resume("Ч", "Одеса", 6, true);
        Resume actualAttributes = new Resume(
                djinniResumePage.getGenderByTitle(),
                djinniResumePage.getCity(),
                djinniResumePage.getExperience(),
                djinniResumePage.isReadyToRelocate()
        );

        assertNotNull(actualAttributes);
        assertTrue(EqualsBuilder.reflectionEquals(expectedAttributes, actualAttributes));
    }
}