package Interface;

public class InterfaceBenefitExample{
    public static void main(String[] args) {

        PaymentInterface paymentInterface = new CreditCardPayment();
        Payment payment1 = new Payment(paymentInterface);
        payment1.doPayment();

        PaymentInterface paymentInterface2 = new NetBankingPayment();
        Payment payment2 = new Payment(paymentInterface2);
        payment2.doPayment();

        PaymentInterface paymentInterface3 = new UpiPayment();
        Payment payment3 = new Payment(paymentInterface3);
        payment3.doPayment();
    }
}

class Payment{
    private final PaymentInterface payment;

    public Payment(PaymentInterface payment) {
        this.payment = payment;
    }

    void doPayment(){
        payment.pay();
    }
}

class CreditCardPayment implements PaymentInterface{

    @Override
    public void pay() {
        System.out.println("Paying through credit card");
    }
}

class UpiPayment implements PaymentInterface{

    @Override
    public void pay() {
        System.out.println("Paying through UPI");
    }
}

class NetBankingPayment implements PaymentInterface{

    @Override
    public void pay() {
        System.out.println("Paying through Net Banking");
    }
}
