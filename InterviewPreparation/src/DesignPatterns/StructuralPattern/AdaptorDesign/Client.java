package DesignPatterns.StructuralPattern.AdaptorDesign;

public class Client {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new AndroidChargerImpl();
        AppleCharger appleCharger = new Adaptor(androidCharger);
        Iphone iphone = new Iphone(appleCharger);
        iphone.chargePhone();
    }
}
