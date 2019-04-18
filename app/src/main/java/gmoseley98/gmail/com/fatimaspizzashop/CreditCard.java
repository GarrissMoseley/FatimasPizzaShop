/********************************
 * Author: Ethan Rimer
 * Class Name: CreditCard
 * Class Description: Object class for CreditCard
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

public class CreditCard implements Parcelable {

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

    public CreditCard(Parcel in) {

        cardNum = in.readString();
        name = in.readString();
        securityNum = in.readString();
        expDate = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(cardNum);
        dest.writeString(name);
        dest.writeString(securityNum);
        dest.writeString(expDate);
    }

    public static final Parcelable.Creator<CreditCard> CREATOR
            = new Parcelable.Creator<CreditCard>() {

        public CreditCard createFromParcel(Parcel in) {

            return new CreditCard(in);
        }

        @Override
        public CreditCard[] newArray(int size) {
            return new CreditCard[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
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