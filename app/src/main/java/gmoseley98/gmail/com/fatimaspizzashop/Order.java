/********************************
 * Author: Ethan Rimer
 * Class Name: Order
 * Class Description: Object class for Order superclass.
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Order implements Parcelable {

    //  Attributes for Order:
    //  totalPrice, orderID, payment type, customer name, pizzas, and credit card.
    //  (Side note: It took a good bit to figure out how have ArrayList
    //  compatible with Parcelable. I knew I had to have some sort of String
    //  array for toppings and ArrayList seemed like the best choice.)
    private double totalPrice = 0;
    private String orderID, paymentType, orderType, name;
    private  ArrayList<Pizza> pizzas = new ArrayList<>();
    private CreditCard creditCard;

    //  Default constructor
    public Order() {

    }

    //  Parameterized constructor which takes a Parcel as input
    //  NOTE: From what I've read, it is *vital* that the values here
    //  are in the same order as they are declared.
    public Order(Parcel in) {

        totalPrice = in.readDouble();
        orderID = in.readString();
        paymentType = in.readString();
        orderType = in.readString();
        name = in.readString();
    }

    //  writeToParcel(Parcel, int) method
    //  Writes object info to a Parcel, I guess
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeDouble(totalPrice);
        dest.writeString(orderID);
        dest.writeString(paymentType);
        dest.writeString(orderType);
        dest.writeString(name);
        dest.writeTypedList(pizzas);
    }

    //  I'll be perfectly honest.
    //  I've not the slightest idea of what this does,
    //  but I assume that it's necessary for this class to be Parcelable.
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

    //  Again, I have no clue as to what this is supposed to do,
    //  But it's required for implementing Parcelable
    public int describeContents() {

        return 0;
    }

    public double getTotalPrice() {

        return totalPrice;
    }

    public String getOrderID() {

        return orderID;
    }

    public String getPaymentType() {

        return paymentType;
    }

    public String getOrderType() {

        return orderType;
    }

    public String getName() {

        return name;
    }

    public ArrayList<Pizza> getPizzas() {

        return pizzas;
    }

    public CreditCard getCreditCard() {

        return creditCard;
    }

    public Pizza getCurrentPizza() {

        return pizzas.get(pizzas.size() - 1);
    }

    public void setTotalPrice(double d) {

        totalPrice = d;
    }

    public void incrementTotalPrice(double d) {

        totalPrice += d;
    }

    public void setOrderID(String s) {

        orderID = s;
    }

    public void setPaymentType(String s) {

        paymentType = s;
    }

    public void setOrderType(String s) {

        orderType = s;
    }

    public void setName(String s) {

        name = s;
    }

    public void addPizza() {

        pizzas.add(new Pizza());
    }

    public void setCreditCard(CreditCard c) {

        creditCard = c;
    }

    public void calculateTotalPrice() {

        totalPrice = 0;

        for(int i = 0; i < pizzas.size() - 1; i++) {

            totalPrice += pizzas.get(i).getCost();
        }
    }
}