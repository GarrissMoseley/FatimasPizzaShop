/********************************
 * Author: Ethan Rimer
 * Class Name: InHouse
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

public class InHouse extends Order {

    public InHouse() {

    }

    public InHouse(Parcel in) {

        super(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        super.writeToParcel(dest, flags);
    }

    public static final Parcelable.Creator<InHouse> CREATOR
            = new Parcelable.Creator<InHouse>() {
        public InHouse createFromParcel(Parcel in) {
            return new InHouse(in);
        }

        public InHouse[] newArray(int size) {
            return new InHouse[size];
        }
    };
}