package com.archive.jordiie.onboardingscreen.onBoarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.archive.jordiie.onboardingscreen.R;

/**
 * Created by jordiie on 22/9/15.
 */
public class screen4_fragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        return inflater.inflate(
                R.layout.screen4,
                container,
                false
        );

    }
}
