
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

    @Override
    public String toString() {
        return "Payment{" + "paymentType=" + paymentType + '}';
    }
    
}
