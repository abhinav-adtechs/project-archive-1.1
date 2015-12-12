package com.archive.jordiie.onboardingscreen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.gc.materialdesign.views.ButtonFloat;
import com.gordonwong.materialsheetfab.AnimatedFab;
import com.gordonwong.materialsheetfab.MaterialSheetFab;

/**
 * Created by jordiie on 12/12/15.
 */
public class DiscussionRoom extends AppCompatActivity implements AnimatedFab{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.discussionroom);

        /*ButtonFloat fab = (ButtonFloat) findViewById(R.id.fab);
        View sheetView = findViewById(R.id.fab_sheet);
       // View overlay = findViewById(R.id.);
        int sheetColor = getResources().getColor(R.color.fab_sheet_color);
        int fabColor = getResources().getColor(R.color.fab_color);

        // Initialize material sheet FAB
        MaterialSheetFab = new MaterialSheetFab<>(fab, sheetView, overlay,
                sheetColor, fabColor);
        */
    }

    @Override
    public void show() {
        // TODO: Animate the FAB into view or simply set its visibility
    }

    /**
     * Shows the FAB and sets the FAB's translation.
     *
     * @param translationX translation X value
     * @param translationY translation Y value
     */
    @Override
    public void show(float translationX, float translationY) {
        // TODO: This is only needed if you want to support moving
        // the FAB around the screen.
    }

    /**
     * Hides the FAB.
     */
    @Override
    public void hide() {
        // TODO: Animate the FAB out of view or simply set its visibility
    }
}
