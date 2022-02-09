package za.co.bakery.domain;

public class Payment {

    private PaymentType paymentType;

    public Payment(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Payment(PaymentType paymentType, Invoice invoice) {
        this.paymentType = paymentType;
    }

    public boolean makePayment() {
        Double total = 259.33;
        
        boolean random=Math.random() * total > (total / 2);
        return random ;
    }
}
