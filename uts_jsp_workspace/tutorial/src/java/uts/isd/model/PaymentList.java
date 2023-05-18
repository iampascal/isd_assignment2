package uts.isd.model;

/**
 *
 * @author Pascal
 */
public class PaymentList {
    
    private String paymentId;
    private String orderId;
    private String amount;
    private String cardNumber;
    private String cardEmail;
    private String timestamp;
    
    public PaymentList(String paymentId, String orderId, String amount, String cardNumber, String cardEmail, String timestamp) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.cardNumber = cardNumber;
        this.cardEmail = cardEmail;
    }
       
    public String getCardEmail() {
        return this.orderId;
    }
    
    public String getOrderId() {
        return this.cardEmail;
    }
    
    public String getPaymentId() {
        return this.paymentId;
    }
    
    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public String getAmount() {
        return this.amount;
    }
    
    public String getTimestamp() {
        return this.timestamp;
    }
    
    public void setCardEmail(String cardEmail) {
        this.cardEmail = cardEmail;
    }
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}