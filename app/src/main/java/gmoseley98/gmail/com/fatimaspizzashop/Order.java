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
    //  price, orderID, payment type, customer name, pizza type, pizza size,
    //  toppings, and credit card.
    //  (Side note: It took a good bit to figure out how have ArrayList
    //  compatible with Parcelable. I knew I had to have some sort of String
    //  array for toppings and ArrayList seemed like the best choice.)
    private double price = 0;
    private String orderID, paymentType, name, pizzaType, pizzaSize;
    private ArrayList<String> toppings = new ArrayList<>();
    private CreditCard creditCard;

    //  Default constructor
    public Order() {

    }

    //  Parameterized constructor which takes a Parcel as input
    //  NOTE: From what I've read, it is *vital* that the values here
    //  are in the same order as they are declared.
    public Order(Parcel in) {

        price = in.readDouble();
        orderID = in.readString();
        paymentType = in.readString();
        name = in.readString();
        pizzaType = in.readString();
        pizzaSize = in.readString();
        toppings = in.createStringArrayList();
    }

    //  writeToParcel(Parcel, int) method
    //  Writes object info to a Parcel, I guess
    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeDouble(price);
        dest.writeString(orderID);
        dest.writeString(paymentType);
        dest.writeString(name);
        dest.writeString(pizzaType);
        dest.writeString(pizzaSize);
        dest.writeStringList(toppings);
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

    //  Order ID setter
    public void setOrderID(String orderID) {

        this.orderID = orderID;
    }

    //  Price setter
    public void setPrice(double price) {

        this.price = price;
    }

    //  Payment type setter
    public void setPaymentType(String paymentType) {

        this.paymentType = paymentType;
    }

    //  Name setter
    public void setName(String name) {

        this.name = name;
    }

    //  Pizza type setter
    public void setPizzaType(String pizzaType) {

        this.pizzaType = pizzaType;
    }

    //  Pizza size setter
    public void setPizzaSize(String pizzaSize) {

        this.pizzaSize = pizzaSize;
    }

    //  Method to add toppings
    public void addToppings(String s) {

        toppings.add(s);
    }

    //  Method to remove toppings
    public void removeToppings(String s) {

        toppings.remove(s);
    }

    //  Credit card setter
    public void setCreditCard(CreditCard c) {

        creditCard = c;
    }

    //  Order ID getter
    public String getOrderID() {

        return orderID;
    }

    //  Price getter
    public double getPrice() {

        return price;
    }

    //  Payment type getter
    public String getPaymentType() {

        return paymentType;
    }

    //  Name getter
    public String getName() {

        return name;
    }

    //  Pizza type getter
    public String getPizzaType() {

        return pizzaType;
    }

    //  Pizza size getter
    public String getPizzaSize() {

        return pizzaSize;
    }

    //  Toppings getter
    public ArrayList<String> getToppings() {

        return toppings;
    }

    //  Credit card getter
    public CreditCard getCreditCard() {

        return creditCard;
    }
}