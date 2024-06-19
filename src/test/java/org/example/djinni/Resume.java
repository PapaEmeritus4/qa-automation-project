package org.example.djinni;

public class Resume {

    private final String gender;
    private final String city;
    private final Integer experience;
    private final boolean isReadyToRelocate;

    public Resume(String gender, String city, Integer experience, boolean isReadyToRelocate) {
        this.gender = gender;
        this.city = city;
        this.experience = experience;
        this.isReadyToRelocate = isReadyToRelocate;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public Integer getExperience() {
        return experience;
    }

    public boolean isReadyToRelocate() {
        return isReadyToRelocate;
    }
}
