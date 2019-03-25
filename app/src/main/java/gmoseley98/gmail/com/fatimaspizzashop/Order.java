/********************************
 * Author: Ethan Rimer
 * Class Name: Order
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
    private CreditCard creditCard;

    public Order() {

    }

    public Order(Parcel in) {

        orderID = in.readInt();
        price = in.readDouble();
        paymentType = in.readString();
        name = in.readString();
        pizzaType = in.readString();
        pizzaSize = in.readString();

        toppings = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(orderID);
        dest.writeDouble(price);
        dest.writeString(paymentType);
        dest.writeString(name);
        dest.writeString(pizzaType);
        dest.writeString(pizzaSize);

        dest.writeStringList(toppings);
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

    public void setPrice(double price) {

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

    public void addToppings(String s) {

        toppings.add(s);
    }

    public void removeToppings(String s) {

        toppings.remove(s);
    }

    public void setCreditCard(CreditCard c) {

        creditCard = c;
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

    public ArrayList<String> getToppings() {

        return toppings;
    }

    public CreditCard getCreditCard() {

        return creditCard;
    }
}