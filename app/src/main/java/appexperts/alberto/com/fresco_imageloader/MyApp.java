package appexperts.alberto.com.fresco_imageloader;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.flurry.android.FlurryAgent;

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        // configure Flurry
        FlurryAgent.setLogEnabled(false);

        // init Flurry****YOU WILL NEED TO REGISTER AND GET AN API UNIQUE KEY FOR YOUR PROJECT******passing the global Application context is not recommended.
       //also after registering make sure you check it out for reporting tools  >>>   https://y.flurry.com/metrics/1
        FlurryAgent.init(this, "YZV4JKRZ3S8WQQ2K3DRW");
//        FlurryAgent.onStartSession(getApplicationContext());
        //FlurryAgent.onStartSession(this, "YZV4JKRZ3S8WQQ2K3DRW");
    }

}
