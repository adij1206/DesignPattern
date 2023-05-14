package com.aditya.DesignPattern.pattern.structure;

interface WebDriver {
    void getElement();

    void selectElement();
}

class ChromeDriver implements WebDriver {
    @Override
    public void getElement() {
        System.out.println("Get Element from Chrome");
    }

    @Override
    public void selectElement() {
        System.out.println("Select Element from Chrome");
    }
}

class IEDriver {

    public void findElement() {
        System.out.println("Find Element from IE");
    }

    public void clickElement() {
        System.out.println("Click Element from IE");
    }
}

class WebDriverAdapter implements WebDriver {

    private IEDriver ieDriver;

    public WebDriverAdapter(IEDriver ieDriver) {
        this.ieDriver = ieDriver;
    }

    @Override
    public void getElement() {
        ieDriver.findElement();
    }

    @Override
    public void selectElement() {
        ieDriver.clickElement();
    }
}


public class AdapterDesignPattern {

    public static void main(String[] args) {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.getElement();
        chromeDriver.selectElement();

        IEDriver ieDriver = new IEDriver();
        ieDriver.clickElement();
        ieDriver.findElement();

        WebDriver webDriver = new WebDriverAdapter(ieDriver);
        webDriver.getElement();
        webDriver.selectElement();

        /*
         * Here as we have 2 different driver and they 2 different methods but they work similarly.
         * So to make them look similar , we have made one class to adapt accordingly as second class
         */
    }
}
