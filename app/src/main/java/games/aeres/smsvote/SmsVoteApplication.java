package games.aeres.smsvote;

import android.app.Application;

import games.aeres.smsvote.connection.ConnectionManagerInterface;
import games.aeres.smsvote.connection.TestConnectionManager;
import games.aeres.smsvote.model.User;

public class SmsVoteApplication extends Application
{
    public final ConnectionManagerInterface connectionManager = new TestConnectionManager();

    public User user = null;

    @Override
    public void onCreate()
    {
        super.onCreate();
    }
}
