package za.co.bakery.domain;

public class Payment {

    private PaymentType paymentType;
    private Invoice invoice;

    public Payment(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Payment(PaymentType paymentType, Invoice invoice) {
        this.paymentType = paymentType;
        this.invoice = invoice;
    }

    public boolean makePayment() {
        Double total = this.getInvoice().getOrder().getLineItem().grandTotal();
        return Math.random() * total > (total / 2);
    }
}
