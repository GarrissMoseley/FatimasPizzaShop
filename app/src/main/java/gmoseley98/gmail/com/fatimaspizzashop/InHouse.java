/********************************
 * Author: Ethan Rimer
 * Class Name: InHouse
 * Class Description: Object class for InHouse subclass.
 * In hindsight, this class is probably unnecessary since
 * it has no unique attributes or methods.
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

public class InHouse extends Order {

    /***********
    * And this is where I'd put my InHouse object attributes...
    *
    * IF I HAD ANY!!
    ***********/

    //  Default constructor
    public InHouse() {

        super.setOrderType("In-House");
    }

    //  Parameterized constructor which takes a Parcel as input
    public InHouse(Parcel in) {

        super(in);
    }

    //  writeToParcel(Parcel, int) method
    //  Writes object info to a Parcel, I guess
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        super.writeToParcel(dest, flags);
    }

    //  Mystey Object: Reloaded
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