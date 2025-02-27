package DesignPatterns.StructuralPattern.AdaptorDesign;

public class Iphone {
    private final AppleCharger appleCharger;

    public Iphone(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }

    public void chargePhone(){
        appleCharger.charger();
    }
}
