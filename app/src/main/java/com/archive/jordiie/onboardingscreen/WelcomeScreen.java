package com.archive.jordiie.onboardingscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


/**
 * Created by jordiie on 13/12/15.
 */
public class WelcomeScreen extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        TextView Username = (TextView)findViewById(R.id.textView8) ;
        Bundle User = getIntent().getExtras() ;

        if(User == null){
            return ;
        }

        String s = User.getString("UserName") ;
        Username.setText(s);

    }
}
