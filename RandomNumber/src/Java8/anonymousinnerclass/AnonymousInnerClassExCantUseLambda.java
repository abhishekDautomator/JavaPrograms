package Java8.anonymousinnerclass;

public class AnonymousInnerClassExCantUseLambda {
    public int squareNum(int a){
        return a*a;
    }
}
class Test{
     AnonymousInnerClassExCantUseLambda  an = new AnonymousInnerClassExCantUseLambda(){
        public void addNum(int a, int b){
            System.out.println("Anonymous function sum : "+a+b);
        }
    };

    public static void main(String[] args) {
        AnonymousInnerClassExCantUseLambda an = new AnonymousInnerClassExCantUseLambda();
        System.out.println(an.squareNum(2));
    }
}
