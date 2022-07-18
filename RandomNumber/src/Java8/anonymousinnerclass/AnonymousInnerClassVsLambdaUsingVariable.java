package Java8.anonymousinnerclass;

public interface AnonymousInnerClassVsLambdaUsingVariable {
    public void m1();
}

class Test1{
    int x = 10;
    public void m() {
        AnonymousInnerClassVsLambdaUsingVariable a = new AnonymousInnerClassVsLambdaUsingVariable() {
            int x = 20;
            @Override
            public void m1() {
                System.out.println("Printing inner class variable "+this.x);
            }
        };
        a.m1();
    }
    public void m2() {
        AnonymousInnerClassVsLambdaUsingVariable c = () -> {
            int x = 20;
            System.out.println("Printing lambda variable"+this.x);
        };
        c.m1();
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.m();
        t.m2();
    }
}
