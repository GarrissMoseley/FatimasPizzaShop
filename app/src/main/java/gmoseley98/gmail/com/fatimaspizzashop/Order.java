/********************************
 * Author: Ethan Rimer
 * Class Name: Order
 *
 * NOTE: This class and its subclasses are currently not integrated into the
 * main code. These classes are just placeholders for now.
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

public class Order {

    private int orderID = 0;
    private double price = 0;
    private String paymentType = "";
    private String name = "";

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
}