/********************************
 * Author: Ethan Rimer
 * Class Name: Delivery
 ********************************/
package gmoseley98.gmail.com.fatimaspizzashop;

public class Delivery extends Order {

    private String address = "";
    private String phoneNumber = "";

    public void setAddress(String Address) {

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
