package games.aeres.smsvote.connection;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import games.aeres.smsvote.exception.LoginException;
import games.aeres.smsvote.exception.RegisterException;
import games.aeres.smsvote.model.User;

public class TestConnectionManager implements ConnectionManagerInterface
{
    private Map<Integer, User> users = new HashMap();
    // Le Password n'étant pas stocké dans User, on a besoin d'un tableau de passwords également
    private Map<Integer, String> passwords = new HashMap();

    public TestConnectionManager()
    {
        users.put(1, new User(1, "John Doe", "test@example.com", "0612345678"));
        passwords.put(1, "1234");
    }

    @Override
    public User login(String email, String password) throws LoginException
    {
        User user = null;
        for(Map.Entry<Integer, User> entry : users.entrySet())
        {
            if(entry.getValue().getEmail().equals(email) && passwords.get(entry.getKey()).equals(password))
            {
                user = entry.getValue();
                break;
            }
        }

        if(user == null)
            throw new LoginException("Email ou Mot de passe incorrect");

        return new User(user);
    }

    @Override
    public User register(String username, String email, String password, String phone) throws RegisterException
    {
        for(Map.Entry<Integer, User> entry : users.entrySet())
            if(entry.getValue().getEmail().equals(email))
                throw new RegisterException("L'adresse mail est déjà utilisée");

        User user = new User(users.size() + 1, username, email, phone);
        users.put(user.getId(), user);
        passwords.put(user.getId(), password);

        return new User(user);
    }
}
