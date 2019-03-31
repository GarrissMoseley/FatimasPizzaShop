/********************************
 * Author: Ethan Rimer
 * Class Name: Delivery
 * Class Description: Object class for Delivery subclass
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

public class Delivery extends Order {

    //  Additional attributes for Delivery object:
    //  customer address and phone number
    private String address, phoneNumber;

    //  Default constructor
    public Delivery() {

    }

    //  Parameterized constructor which takes a Parcel as input
    //  NOTE: From what I've read, it is *vital* that the values here
    //  are in the same order as they are declared.
    public Delivery(Parcel in) {

        super(in);
        address = in.readString();
        phoneNumber = in.readString();
    }

    //  writeToParcel(Parcel, int) method
    //  Writes object info to a Parcel, I guess
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        super.writeToParcel(dest, flags);
        dest.writeString(address);
        dest.writeString(phoneNumber);
    }

    //  Mystery Object
    public static final Parcelable.Creator<Delivery> CREATOR
            = new Parcelable.Creator<Delivery>() {
        public Delivery createFromParcel(Parcel in) {
            return new Delivery(in);
        }

        public Delivery[] newArray(int size) {
            return new Delivery[size];
        }
    };

    //  Address setter
    public void setAddress(String address) {

        this.address = address;
    }

    //  Phone number setter
    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    //  Address getter
    public String getAddress() {

        return address;
    }

    //  Phone Number getter
    public String getPhoneNumber() {

        return phoneNumber;
    }
}