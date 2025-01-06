package DesignPatterns.StructuralPattern.AdaptorDesign;

public class AppleChargerImpl implements AppleCharger{
    @Override
    public void charger() {
        System.out.println("Charging phone");
    }
}
