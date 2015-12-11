package com.archive.jordiie.onboardingscreen.onBoarding;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.archive.jordiie.onboardingscreen.MainActivity;
import com.archive.jordiie.onboardingscreen.R;
import com.archive.jordiie.onboardingscreen.Animations.ZoomOut;
import com.gc.materialdesign.views.ButtonFlat;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

/**
 * Created by jordiie on 22/9/15.
 */

public class onboardingMain extends FragmentActivity {

    private ViewPager pager;
    private SmartTabLayout indicator;
    private ButtonFlat skip;
    private ButtonFlat next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.start_onboarding);

        //TextView textViewCustom = (TextView) findViewById(R.id.textView2) ;
        Typeface regular = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf") ;
        //textViewCustom.setTypeface(regular);


        pager = (ViewPager) findViewById(R.id.pager);
        indicator = (SmartTabLayout) findViewById(R.id.indicator);
        skip = (ButtonFlat) findViewById(R.id.skip);
        next = (ButtonFlat) findViewById(R.id.next);

        pager.setAdapter(adapter);
        indicator.setViewPager(pager);
        pager.setPageTransformer(true, new ZoomOut());



        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishOnboarding();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pager.getCurrentItem() == 4) { // The last screen
                    finishOnboarding();
                } else {
                    pager.setCurrentItem(
                            pager.getCurrentItem() + 1,
                            true
                    );
                }
            }
        });

        indicator.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == 4) {
                    skip.setVisibility(View.GONE);
                    next.setText("Done");
                } else {
                    skip.setVisibility(View.VISIBLE);
                    next.setText("Next");
                }
            }
        });


    }

    FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0 : return new screen1_fragment();
                case 1 : return new screen2_fragment();
                case 2 : return new screen3_fragment();
                case 3 : return new screen4_fragment();
                case 4 : return new screen5_fragment();
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 5;
        }

    };






    private void finishOnboarding() {
        // Get the shared preferences
        SharedPreferences preferences =
                getSharedPreferences("my_preferences", MODE_PRIVATE);

        // Set onboarding_complete to true
        preferences.edit()
                .putBoolean("onboarding_complete",true).apply();

        // Launch the main Activity, called MainActivity
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

        // Close the OnboardingActivity
        finish();
    }



}




