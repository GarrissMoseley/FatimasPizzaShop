/********************************
 * Author: Ethan Rimer
 * Class Name: CreditCard
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

public class CreditCard {

    private String cardNum, name, securityNum, expDate;

    public CreditCard(String cardNum, String name,
                      String securityNum, String expDate) {

        this.name = name;
        this.cardNum = cardNum;
        this.securityNum = securityNum;
        this.expDate = expDate;
    }

    public void setCardNum(String cardNum) {

        this.cardNum = cardNum;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setSecurityNum(String securityNum) {

        this.securityNum = securityNum;
    }

    public void setExpDate(String expDate) {

        this.expDate = expDate;
    }

    public String getCardNum() {

        return cardNum;
    }

    public String getName() {

        return name;
    }

    public String getSecurityNum() {

        return securityNum;
    }

    public String getExpDate() {

        return expDate;
    }
}