/********************************
 * Author: Ethan Rimer
 * Class Name: Order
 *
 * NOTE: This class and its subclasses are currently not integrated into the
 * main code. These classes are just placeholders for now.
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Order implements Parcelable {

    private int orderID = 0;
    private double price = 0;
    private String paymentType, name, pizzaType, pizzaSize;
    private ArrayList<String> toppings = new ArrayList<>();

    public Order() {

    }

    public Order(Parcel in) {

        orderID = in.readInt();
        price = in.readDouble();
        paymentType = in.readString();
        name = in.readString();
        pizzaType = in.readString();
        pizzaSize = in.readString();
//        toppings = in.readStringList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(orderID);
        dest.writeDouble(price);
        dest.writeString(paymentType);
        dest.writeString(name);
        dest.writeString(pizzaType);
        dest.writeString(pizzaSize);
//        dest.readArrayList();
    }

    public static final Parcelable.Creator<Order> CREATOR
            = new Parcelable.Creator<Order>() {

        public Order createFromParcel(Parcel in) {

            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };

    public int describeContents() {

        return 0;
    }

    public void setOrderID(int orderID) {

        this.orderID = orderID;
    }

    public void setPrice(int price) {

        this.price = price;
    }

    public void setPaymentType(String paymentType) {

        this.paymentType = paymentType;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setPizzaType(String pizzaType) {

        this.pizzaType = pizzaType;
    }

    public void setPizzaSize(String pizzaSize) {

        this.pizzaSize = pizzaSize;
    }

    public int getOrderID() {

        return orderID;
    }

    public double getPrice() {

        return price;
    }

    public String getPaymentType() {

        return paymentType;
    }

    public String getName() {

        return name;
    }

    public String getPizzaType() {

        return pizzaType;
    }

    public String getPizzaSize() {

        return pizzaSize;
    }
}