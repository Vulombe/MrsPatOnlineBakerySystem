
package za.co.bakery.dbao;

import java.util.List;
import za.co.bakery.domain.User;





/**
 *
 * @author student12
 */
public interface UserDOA {


    public int create(User u);

    public User read(User u);

    public User read();

    public boolean isNewUser(User u);

    boolean isUserValid(String email, String password);



    //lots of user related methods

}
