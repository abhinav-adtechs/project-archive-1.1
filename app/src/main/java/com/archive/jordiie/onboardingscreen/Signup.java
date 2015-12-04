package com.archive.jordiie.onboardingscreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.gc.materialdesign.views.ProgressBarIndeterminate;

/**
 * Created by jordiie on 23/9/15.
 */
public class Signup extends AppCompatActivity{

    private ProgressBarIndeterminate progressbar1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.signup_activity);

        //progressbar1 = (ProgressBarIndeterminate)findViewById(R.id.progressbar1) ;

    }
}
