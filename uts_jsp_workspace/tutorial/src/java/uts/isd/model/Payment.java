package uts.isd.model;

/**
 *
 * @author Pascal
 */
public class Payment {
    
    private String cardEmail;
    private String cardName;
    private String cardNumber;
    private String cardExpiry;
    private String cardCvv;
    
    public Payment(String cardEmail, String cardName, String cardNumber, String cardExpiry, String cardCvv) {
        this.cardEmail = cardEmail;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.cardCvv = cardCvv;
    }
    
    
    public String getCardEmail() {
        return this.cardEmail;
    }
    
    public String getCardName() {
        return this.cardName;
    }
    
    public String getCardNumber() {
        return this.cardNumber;
    }
    
    public String getCardExpiry() {
        return this.cardExpiry;
    }
    
    public String getCardCvv() {
        return this.cardCvv;
    }
    public void setCardEmail(String cardEmail) {
        this.cardName = cardEmail;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }
    
    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }
}