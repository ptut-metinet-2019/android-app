package games.aeres.smsvote.connection;

import games.aeres.smsvote.exception.LoginException;
import games.aeres.smsvote.exception.RegisterException;
import games.aeres.smsvote.model.User;

public class ConnectionManager implements ConnectionManagerInterface
{
    @Override
    public User login(String email, String password) throws LoginException
    {
        return null;
    }

    @Override
    public User register(String username, String email, String password, String phone) throws RegisterException
    {
        return null;
    }
}
