package com.archive.jordiie.onboardingscreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.internal.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jordiie on 22/9/15.
 */
public class screen5_fragment extends android.support.v4.app.Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {


        return inflater.inflate(
                R.layout.screen5,
                container,
                false
        );

    }
}
