package tech.bfitzsimmons.parseserverboiler;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

/**
 * Created by Brian on 7/2/2017.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //Enable us to store data locally
        Parse.enableLocalDatastore(this);

        //Initialize Parse Server
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("APP_ID")
                .clientKey("CLIENT_ID")
                .server("SERVER URL + /")
                .build()
        );

        //Example save object to database
        ParseObject parseObject = new ParseObject("SolarSystem");
        parseObject.put("planetCount", 8);
        parseObject.put("moonCount", 184);
        parseObject.put("hasLife", true);
        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                //if not exception, print success message
                if(e == null){
                    Log.i("Parse result:", "Success");
                } else {
                    e.printStackTrace();
                }
            }
        });

        //Set up an anonymous user
        ParseUser.enableAutomaticUser();

        //Grant read/write permissions
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

    }
}
