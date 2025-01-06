package DesignPatterns.StructuralPattern.AdaptorDesign;

public class Iphone {
    private AppleCharger appleCharger;

    public Iphone(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }

    public void chargePhone(){
        appleCharger.charger();
    }
}
