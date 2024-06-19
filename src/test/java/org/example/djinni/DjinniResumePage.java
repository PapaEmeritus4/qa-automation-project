package org.example.djinni;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static java.lang.Integer.parseInt;

public class DjinniResumePage {

    private final SelenideElement gender = $("h1");
    private final SelenideElement experience = $x("//li[@class='d-flex align-items-baseline mb-1 ']//span[contains(text(), '6 місяців')]");
    private final SelenideElement city = $x("//li[@class='d-flex align-items-baseline mb-1 ']//span[contains(text(), 'Україна, Одеса')]");
    private final SelenideElement relocateInformation = $x("//li[@class='d-flex align-items-baseline mb-1 ']//span[contains(text(), 'Переїзд в інше місто')]");

    public static String GENDER = "Gender";
    public static String EXPERIENCE = "Experience";
    public static String CITY = "City";
    public static String READY_TO_RELOCATE = "Ready to relocate";

    public DjinniResumePage(String url) {
        open(url);
    }

    public Map<String, Object> getAttributes() {
        return new HashMap<>(){{
            put(GENDER, getGenderByTitle());
            put(EXPERIENCE, getExperience());
            put(CITY, getCity());
            put(READY_TO_RELOCATE, isReadyToRelocate());
        }};

    }

    public String getGenderByTitle() {
        return gender.text().startsWith("Java") ? "Ч" : "Ж";
    }

    public Integer getExperience() {
        return parseInt(experience.getText().replaceAll("\\D+", ""));
    }

    public String getCity() {
        return city.getText().replaceAll(".*?,\\s*", "");
    }

    public boolean isReadyToRelocate() {
        return relocateInformation.exists();
    }
}
