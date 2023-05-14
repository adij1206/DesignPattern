package com.aditya.DesignPattern.pattern.structure;

class Firefox {
    public static String getDriver() {
        return "Firefox";
    }

    public static void generateHTMLReport(String test, String driver) {
        System.out.println("Generating report for HTML");
    }

    public static void generateJUnitReport(String test, String driver) {
        System.out.println("Generating report for JUnit");
    }
}

class Chrome {
    public static String getDriver() {
        return "Chrome";
    }

    public static void generateHTMLReport(String test, String driver) {
        System.out.println("Generating report for HTML");
    }

    public static void generateJUnitReport(String test, String driver) {
        System.out.println("Generating report for JUnit");
    }
}

class FacadeHelper {
    public static void generateReports(String explorer, String report, String test) {
        String driver;
        switch (explorer) {
            case "Firefox" -> {
                driver = Firefox.getDriver();
                switch (report) {
                    case "HTML" -> Firefox.generateHTMLReport(test, driver);
                    case "JUnit" -> Firefox.generateJUnitReport(test, driver);
                }
            }
            case "Chrome" -> {
                driver = Chrome.getDriver();
                switch (report) {
                    case "HTML" -> Firefox.generateHTMLReport(test, driver);
                    case "JUnit" -> Firefox.generateJUnitReport(test, driver);
                }
            }
        }
    }
}

public class FacadeDesignPattern {
    public static void main(String[] args) {
        FacadeHelper.generateReports("Firefox", "HTML","checkElementPresent");
        FacadeHelper.generateReports("Firefox", "JUnit","checkElementPresent");
        FacadeHelper.generateReports("Chrome", "HTML","checkElementPresent");
        FacadeHelper.generateReports("Chrome", "JUnit","checkElementPresent");
    }
}
