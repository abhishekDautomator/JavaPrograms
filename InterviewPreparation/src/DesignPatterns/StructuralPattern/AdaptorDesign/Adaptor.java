package DesignPatterns.StructuralPattern.AdaptorDesign;

public class Adaptor implements AppleCharger{
    private AndroidCharger charger;

    public Adaptor(AndroidCharger charger) {
        this.charger = charger;
    }

    @Override
    public void charger() {
        charger.chargerAndroid();
    }
}
