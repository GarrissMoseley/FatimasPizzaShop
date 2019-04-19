/********************************
 * Author: Ethan Rimer
 * Class Name: TakeOut
 * Class Description: Object class for TakeOut subclass
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

public class TakeOut extends Order {

    //  Additional attribute for TakeOut object:
    //  customer phone number
    private String phoneNumber;
    private boolean wasLate;

    //  Default constructor
    public TakeOut() {

        super.setOrderType("Takeout");
    }

    //  Parameterized constructor which takes a Parcel as input
    //  NOTE: From what I've read, it is *vital* that the values here
    //  are in the same order as they are declared.
    public TakeOut(Parcel in) {

        super(in);
        phoneNumber = in.readString();
        wasLate = in.readByte() != 0;
    }

    //  writeToParcel(Parcel, int) method
    //  Writes object info to a Parcel, I guess
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        super.writeToParcel(dest, flags);
        dest.writeString(phoneNumber);
        dest.writeByte((byte) (wasLate ? 1 : 0));
    }

    //  Mystery Object: Revolutions
    public static final Parcelable.Creator<TakeOut> CREATOR
            = new Parcelable.Creator<TakeOut>() {
        public TakeOut createFromParcel(Parcel in) {
            return new TakeOut(in);
        }

        public TakeOut[] newArray(int size) {
            return new TakeOut[size];
        }
    };

    //  Phone number setter
    public void setPhoneNumber(String s) {

        phoneNumber = s;
    }

    public void setWasLate(Boolean b) {

        wasLate = b;
    }

    //  Phone number getter
    public String getPhoneNumber() {

        return phoneNumber;
    }

    public boolean getWasLate() {

        return wasLate;
    }

    @Override
    public void calculateTotalPrice() {

        super.calculateTotalPrice();

        if(wasLate) {

            incrementTotalPrice(2);
        }
    }
}