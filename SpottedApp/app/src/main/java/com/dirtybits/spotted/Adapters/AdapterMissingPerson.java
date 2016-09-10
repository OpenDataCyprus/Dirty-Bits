package com.dirtybits.spotted.Adapters;


import android.content.Context;
import android.os.Parcel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dirtybits.spotted.Models.MissingPerson;
import com.dirtybits.spotted.Models.Type;
import com.dirtybits.spotted.R;
import com.dirtybits.spotted.ViewHolders.ViewHolderMissingPerson;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AdapterMissingPerson extends RecyclerView.Adapter<ViewHolderMissingPerson> {

    List<MissingPerson> personsList;
    Context _context;
    private static SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    public AdapterMissingPerson(Context context) {
        _context = context;
        MissingPerson missingPerson;
        missingPerson = new MissingPerson(Parcel.obtain());
        missingPerson.setFullName("Eduard Bagdoyan");
        missingPerson.setTimesSpotted(2);
        missingPerson.setType(Type.MissingPerson);
        missingPerson.setPhotographString(context.getResources().getDrawable(R.drawable.no_photo_available));
        personsList= new ArrayList<>();
        personsList.add(missingPerson);
        missingPerson = new MissingPerson(Parcel.obtain());
        missingPerson.setFullName("ΜΑΡΙΑ ΚΑΚΟΓΙΑΝΝΗ");
        missingPerson.setTimesSpotted(0);
        missingPerson.setType(Type.MissingPerson);
        missingPerson.setPhotographString(context.getResources().getDrawable(R.drawable.no_photo_available));
        personsList.add(missingPerson);

    }

    @Override
    public ViewHolderMissingPerson onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_row, parent, false);
        return new ViewHolderMissingPerson(v);
    }

    @Override
    public void onBindViewHolder(ViewHolderMissingPerson holder, int position) {
        if (personsList.size() > 0) {
            holder.textviewName.setText(personsList.get(position).getFullName());
         //   holder.textviewDate.setText(personsList.get(position).getMissingDate().toString());
              holder.textviewSpottedTime.setText(Integer.toString(personsList.get(position).getTimesSpotted()));
            holder.imageButtonPicture.setImageDrawable(personsList.get(position).getPhotographString());
            //  Picasso.with(_context).load(personsList.get(position).getPhotographString().).into( holder.imageButtonPicture);
            //  holder.imageButton.setTag(position);
        }
    }

    public MissingPerson getSelectedPerson(int position) {
        return personsList.get(position);
    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }
}