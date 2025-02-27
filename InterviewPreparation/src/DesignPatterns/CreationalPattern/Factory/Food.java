package DesignPatterns.CreationalPattern.Factory;

interface Food {
    public String getType();
}

class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}

class Cake implements Food {

    public String getType() {
        return "Someone ordered a Dessert!";
    }
}
class FoodFactory {
    public Food getFood(String order) {
        if (order.equals("cake")) {
            System.out.println("The factory returned class Cake");
            return new Cake();
        } else if (order.equals("pizza")) {
            System.out.println("The factory returned class Pizza");
            return new Pizza();
        }
        return null;
    }
}
