package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Pizza implements Parcelable {

    private String type, size;
    private ArrayList<String> toppings = new ArrayList<>();
    private double cost = 0;

    public Pizza() {

    }

    public Pizza(Parcel in) {

        type = in.readString();
        size = in.readString();
        toppings = in.createStringArrayList();
        cost = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(type);
        dest.writeString(size);
        dest.writeStringList(toppings);
        dest.writeDouble(cost);
    }

    public static final Parcelable.Creator<Pizza> CREATOR
            = new Parcelable.Creator<Pizza>() {

        public Pizza createFromParcel(Parcel in) {

            return new Pizza(in);
        }

        @Override
        public Pizza[] newArray(int size) {
            return new Pizza[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getType() {
        return type;
    }

    public String getSize() {

        return size;
    }

    public ArrayList<String> getToppings() {

        return toppings;
    }

    public double getCost() {

        return cost;
    }

    public void setType(String s) {

        type = s;
    }

    public void setSize(String s) {

        size = s;
    }

    public void addTopping(String s) {


        toppings.add(s);
    }

    public void removeTopping(String s) {


        toppings.remove(s);
    }

    public void setCost(double d) {

        cost = d;
    }

    public void incrementCost(double d) {

        cost += d;
    }
}