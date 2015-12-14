package com.archive.jordiie.onboardingscreen.DiscussionRoom;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.archive.jordiie.onboardingscreen.R;

import java.util.List;

/**
 * Created by jordiie on 14/12/15.
 */
public class DRAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public static final int TYPE_HEADER = 0 ;
    public static final int TYPE_ITEM = 1 ;
    public static final int TYPE_REMINDER = 2 ;

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView personName;
        TextView personAge;
        ImageView personPhoto;

        PersonViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            personName = (TextView)itemView.findViewById(R.id.person_name);
            personAge = (TextView)itemView.findViewById(R.id.person_age);
            personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

    public static class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView HeaderText;
        ImageView Headcolor;

        HeaderViewHolder(View itemView) {
            super(itemView);
            HeaderText = (TextView)itemView.findViewById(R.id.header);
            Headcolor = (ImageView)itemView.findViewById(R.id.headercolor);
        }
    }

    public static class  ReminderViewHolder extends  RecyclerView.ViewHolder{

        TextView ReminderTitle ;
        TextView ReminderDate ;

        ReminderViewHolder(View itemView){
            super(itemView);
            ReminderTitle = (TextView)itemView.findViewById(R.id.ReminderTitle) ;
            ReminderDate = (TextView)itemView.findViewById(R.id.ReminderDate) ;
        }
    }

    List<Person> persons;
    List<HeaderList> Heads ;
    List<ReminderList> Remind ;

    DRAdapter(List<Person> persons, List<HeaderList> Heads, List<ReminderList> Remind){
        this.persons = persons;
        this.Heads = Heads ;
        this.Remind = Remind ;
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        if(i == TYPE_HEADER){

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dr_headers, viewGroup, false);
            HeaderViewHolder pvh = new HeaderViewHolder(v);

            return pvh;

        }
        else if(i == TYPE_REMINDER){

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dr_reminder, viewGroup, false);
            ReminderViewHolder pvh = new ReminderViewHolder(v);

            return pvh;

        }
        else {

            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dr_notes, viewGroup, false);
            PersonViewHolder pvh = new PersonViewHolder(v);

            return pvh;


        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder Holder, int i) {

        if(Holder instanceof HeaderViewHolder){
            HeaderViewHolder Header = (HeaderViewHolder) Holder ;
            Header.HeaderText.setText(Heads.get(i/4).HeaderValue);
            Header.Headcolor.setImageResource(Heads.get(i/4).HeaderID);
        }
        else if(Holder instanceof ReminderViewHolder){
            ReminderViewHolder ReminderA = (ReminderViewHolder) Holder ;

            ReminderA.ReminderTitle.setText(Remind.get(i-1).ReminderHead);
            ReminderA.ReminderDate.setText(Remind.get(i - 1).Date);
        }
        else {
            PersonViewHolder personViewHolder = (PersonViewHolder) Holder ;

            personViewHolder.personName.setText(persons.get(i-5).name);
            personViewHolder.personAge.setText(persons.get(i-5).age);
            personViewHolder.personPhoto.setImageResource(persons.get(i-5).photoId);
        }
    }

    @Override
    public int getItemCount() {
        return persons.size()+Heads.size()+Remind.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 4 || position == 8){
            return TYPE_HEADER ;
        }
        else if (position > 0 && position < 4){
            return TYPE_REMINDER ;
        }
        else
            return TYPE_ITEM ;

    }


}
