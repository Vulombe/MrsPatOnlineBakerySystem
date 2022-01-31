
package za.co.bakery.domain;

public class UserAddress {

    private int AddressId;
    private int houseNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    private User user;

    public UserAddress(int houseNumber, String streetAddress, String city, String state, String zipCode, User user) {
        this.houseNumber = houseNumber;
        this.streetName = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.user = user;
    }

    public UserAddress(int AddressId, int houseNumber, String streetName, String city, String state, String zipCode, User user) {
        this.AddressId = AddressId;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.user = user;
    }
 

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
  
    public UserAddress() {

    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    @Override
    public String toString() {
        return "UserAddress{" + "AddressId=" + AddressId + ", houseNumber=" + houseNumber + ", streetName=" + streetName + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", user=" + user + '}';
    }
 

}
