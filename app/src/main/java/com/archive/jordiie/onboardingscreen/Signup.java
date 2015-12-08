package com.archive.jordiie.onboardingscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gc.materialdesign.views.Button;
import com.gc.materialdesign.views.ProgressBarIndeterminate;

/**
 * Created by jordiie on 23/9/15.
 */
public class Signup extends AppCompatActivity{

//    private ProgressBarIndeterminate progressbar1 ;
    private Button Register ;
    private Button Login ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_activity);

        //progressbar1 = (ProgressBarIndeterminate)findViewById(R.id.progressbar1) ;
   /* Register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           //OAuth 2.0 Registration Success Check
            RegistrationSuccess() ;
        }
    });

    Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            //OAuth 2.0 Google Play Services LogIN Check
            LoginSuccess() ;
        }
    });

    */


    }

    private void LoginSuccess() {

        Intent goback = new Intent(this, MainActivity.class) ;
        startActivity(goback);
    }

    private void RegistrationSuccess() {

        Intent goback = new Intent(this, MainActivity.class) ;
        startActivity(goback);

    }
}
