/********************************
 * Author: Ethan Rimer
 * Class Name: TakeOut
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

public class TakeOut extends Order {

    private String phoneNumber;

    public TakeOut() {

    }

    public TakeOut(Parcel in) {

        super(in);
        phoneNumber = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        super.writeToParcel(dest, flags);
        dest.writeString(phoneNumber);
    }

    public static final Parcelable.Creator<TakeOut> CREATOR
            = new Parcelable.Creator<TakeOut>() {
        public TakeOut createFromParcel(Parcel in) {
            return new TakeOut(in);
        }

        public TakeOut[] newArray(int size) {
            return new TakeOut[size];
        }
    };

    public void setPhoneNumber(String phoneNumber) {

        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }
}