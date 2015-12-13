package asc.com.coy_admin;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;

/**
 * Created by songmho on 15. 12. 13..
 */
public class Coy_admin extends Application {
    String APPLICATION_ID="kIXQWqLpWBsdKAkMZTfY7Z50ecL5UsLLXabHQmn9";
    String CLIENT_KEY="vWtnUeBVZYCR6ZR2EiO4jWUBDLKAvNkKPu5qDe5f";

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
        ParseACL defaultACL=new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL,true);
    }
}
