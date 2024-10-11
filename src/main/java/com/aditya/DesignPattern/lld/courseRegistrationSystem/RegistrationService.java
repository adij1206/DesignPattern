package com.aditya.DesignPattern.lld.courseRegistrationSystem;

import java.util.HashMap;
import java.util.Map;

public class RegistrationService {

    private Map<String, Registration> registrationMap;

    public RegistrationService() {
        registrationMap = new HashMap<>();
    }

    public Registration createRegistration(String courseId, String studentId) {
        Registration registration = new Registration(studentId, courseId);
        registrationMap.put(registration.getRegistrationId(), registration);
        return registration;
    }

    public Registration getRegistration(String registrationId) {
        return registrationMap.get(registrationId);
    }
}
