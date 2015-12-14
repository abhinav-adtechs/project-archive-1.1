package com.archive.jordiie.onboardingscreen.DiscussionRoom;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

//import com.gc.materialdesign.views.ButtonFloat;
import com.archive.jordiie.onboardingscreen.R;
import com.gordonwong.materialsheetfab.AnimatedFab;
import com.gordonwong.materialsheetfab.MaterialSheetFab;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordiie on 12/12/15.
 */
public class DiscussionRoom extends AppCompatActivity implements AnimatedFab{

    private List<Person> persons;
    private List<HeaderList> Heads ;
    private List<ReminderList> Remind ;
    private RecyclerView rv;



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

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();





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

    private void initializeData(){
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.lillie));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.lillie));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.lillie));

        Heads = new ArrayList<>();
        Heads.add(new HeaderList("Reminders", R.drawable.redline)) ;
        Heads.add(new HeaderList("Notes", R.drawable.redline)) ;
        Heads.add(new HeaderList("Conversations", R.drawable.redline)) ;

        Remind = new ArrayList<>();
        Remind.add(new ReminderList("Quiz 1", "18th May")) ;
        Remind.add(new ReminderList("Quiz 2", "20th May")) ;
        Remind.add(new ReminderList("Quiz 3", "30th May")) ;
    }


    private void initializeAdapter(){
        DRAdapter adapter = new DRAdapter(persons, Heads, Remind);
        rv.setAdapter(adapter);

    }


}
