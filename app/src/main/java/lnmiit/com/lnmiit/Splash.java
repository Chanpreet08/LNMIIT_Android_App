package lnmiit.com.lnmiit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class Splash extends AppCompatActivity {

    Thread splash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        splash = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(3000);
                }

                catch( Exception e )
                {
                    e.printStackTrace();
                }

                finally
                {   // Launching to the main Activity
                    Intent main_intent = new Intent("lnmiit.com.lnmiit.main");
                    startActivity(main_intent);
                    finish();
                }
            }
        };
        splash.start();
    }
}
