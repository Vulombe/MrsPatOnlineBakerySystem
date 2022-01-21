
package za.co.bakery.domain;

import java.util.Objects;

/**
 *
 * @author Stuart Littles
 */
public class User 
{
    private int ID;
    private String title;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String contactNumber;
    private String password;
    private Role userRole;

      public User(String emailAddress,String password) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.userRole = userRole;
    }

    public User(int ID, String title, String firstName, String lastName, String emailAddress, String contactNumber, String password, Role userRole) {
        this.ID = ID;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.contactNumber = contactNumber;
        this.password = password;
        this.userRole = userRole;
    }
     
    public User() {
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.ID, other.ID)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "ID=" + ID + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress + ", contactNumber=" + contactNumber + ", password=" + password + ", userRole=" + userRole + '}';
    }

 
}
