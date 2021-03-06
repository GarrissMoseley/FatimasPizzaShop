/********************************
 * Author: Ethan Rimer
 * Class Name: CreditCard
 * Class Description: Object class for CreditCard
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

public class CreditCard {

    //  Attributes for CreditCard object:
    //  card number, name on card, security number, and expiration
    private String cardNum, name, securityNum, expDate;

    //  Parameterized constructor which takes all attributes as input
    public CreditCard(String cardNum, String name,
                      String securityNum, String expDate) {

        this.name = name;
        this.cardNum = cardNum;
        this.securityNum = securityNum;
        this.expDate = expDate;
    }

    //  Card number setter
    public void setCardNum(String cardNum) {

        this.cardNum = cardNum;
    }

    //  Name setter
    public void setName(String name) {

        this.name = name;
    }


    //  Security number setter
    public void setSecurityNum(String securityNum) {

        this.securityNum = securityNum;
    }

    //  Expiration setter
    public void setExpDate(String expDate) {

        this.expDate = expDate;
    }

    //  Card number getter
    public String getCardNum() {

        return cardNum;
    }

    //  Name getter
    public String getName() {

        return name;
    }

    //  Security number getter
    public String getSecurityNum() {

        return securityNum;
    }

    //  Expiration getter
    public String getExpDate() {

        return expDate;
    }
}