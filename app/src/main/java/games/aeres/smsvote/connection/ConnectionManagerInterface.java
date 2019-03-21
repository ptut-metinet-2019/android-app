package games.aeres.smsvote.connection;

import games.aeres.smsvote.exception.LoginException;
import games.aeres.smsvote.exception.RegisterException;
import games.aeres.smsvote.model.User;

public interface ConnectionManagerInterface
{
    public User login(String email, String password) throws LoginException;
    public User register(String username, String email, String password, String phone) throws RegisterException;
}
