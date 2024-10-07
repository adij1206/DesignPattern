package com.aditya.DesignPattern.lld.linkedIn;

import lombok.Data;

import java.util.List;

@Data
public class Profile {

    private String userId;
    private String description;
    private String summary;
    private List<Skills> skillsList;
    private List<Experience> experiences;
    private List<Education> educations;
    private String profilePicture;

    public Profile(String userId) {
        this.userId = userId;
    }
}
