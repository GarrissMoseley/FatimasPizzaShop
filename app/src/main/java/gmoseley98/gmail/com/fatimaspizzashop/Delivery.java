/********************************
 * Author: Ethan Rimer
 * Class Name: Delivery
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

public class Delivery extends Order {

    private String address, phoneNumber;

    public Delivery() {

    }

    public Delivery(Parcel in) {

        super(in);
        address = in.readString();
        phoneNumber = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        super.writeToParcel(dest, flags);
        dest.writeString(address);
        dest.writeString(phoneNumber);
    }

    public static final Parcelable.Creator<Delivery> CREATOR
            = new Parcelable.Creator<Delivery>() {
        public Delivery createFromParcel(Parcel in) {
            return new Delivery(in);
        }

        public Delivery[] newArray(int size) {
            return new Delivery[size];
        }
    };

    public void setAddress(String address) {

        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {

        return address;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }
}