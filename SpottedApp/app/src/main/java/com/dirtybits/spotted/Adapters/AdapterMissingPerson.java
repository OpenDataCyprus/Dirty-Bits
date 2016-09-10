package com.dirtybits.spotted.Adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dirtybits.spotted.Interfaces.OnRecyclerViewItemClickListener;
import com.dirtybits.spotted.Models.MissingPerson;
import com.dirtybits.spotted.Models.Person;
import com.dirtybits.spotted.Models.Type;
import com.dirtybits.spotted.R;
import com.dirtybits.spotted.ViewHolders.ViewHolderMissingPerson;

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
        personsList = new ArrayList<>();

        MissingPerson missingPerson;
        missingPerson = new MissingPerson(Parcel.obtain());
        missingPerson.setFullName("ΧΑΡΑΛΑΜΠΟΣ ΠΕΛΟΠΙΔΑ");
        missingPerson.setTimesSpotted(13);
        missingPerson.setType(Type.MissingPerson);
        missingPerson.setDescription("Ο Χαράλαμπος ΠΕΛΟΠΙΔΑ από το Καντού, 55 χρόνων, λείπει από την κατοικία του από τις 29.1.02. " +
                                     "Είναι ύψους 1.70 μ., παχουλός, με γκριζόμαυρα μαλλιά, φορεί γυαλιά μυωπίας και κουτσαίνει στο δεξί του πόδι. " +
                                     "Φορούσε σακάκι παραλλαγής, φανέλα με γαλάζιες και άσπρες ρίγες και μαύρο παντελόνι.Ο Αστ. Στ. Επισκοπής εξετάζει.");
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.pelopidas);
        missingPerson.setPhotograph(icon);
        missingPerson.setMissingDate("2002-01-29");
        personsList.add(missingPerson);

        missingPerson = new MissingPerson(Parcel.obtain());
        missingPerson.setFullName("ΒΑΣΟΣ ΚΩΝΣΤΑΝΤΙΝΟΥ");
        missingPerson.setTimesSpotted(8);
        missingPerson.setType(Type.MissingPerson);
        missingPerson.setDescription("Ο Βάσος ΚΩΝΣΤΑΝΤΙΝΟΥ από την Αγγλία, 28 χρόνων, λείπει από την κατοικία εξαδέλφης του στη Λ/κα, από τις 7.7.02. " +
                                     "Είναι ισχυρής σωματικής διάπλασης, ύψους 1.80μ., με μαύρα μαλλιά και καφέ μάτια.Το ΤΑΕ Λ/κας εξετάζει.");
        missingPerson.setMissingDate("2002-07-07");
        icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.konstantinou);
        missingPerson.setPhotograph(icon);
        personsList.add(missingPerson);

        missingPerson = new MissingPerson(Parcel.obtain());
        missingPerson.setFullName("AΝΝΑ ΜΙΛΤΙΑΔΟΥΣ");
        missingPerson.setTimesSpotted(27);
        missingPerson.setType(Type.MissingPerson);
        missingPerson.setDescription("Η Άννα ΜΙΛΤΙΑΔΟΥΣ από τη Λεμεσό, 75 χρόνων, λείπει από την κατοικία της από τις 23/9/02. " +
                                     "Περισσότερες πληροφορίες δεν υπάρχουν.Το ΤΑΕ Λεμεσού εξετάζει.");
        missingPerson.setMissingDate("2002-09-23");
        icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.miltiadous);
        missingPerson.setPhotograph(icon);
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
            holder.textviewDate.setText(personsList.get(position).getMissingDate());
            holder.textviewSpottedTime.setText(Integer.toString(personsList.get(position).getTimesSpotted()));
            Drawable drawable = new BitmapDrawable(_context.getResources(), personsList.get(position).getPhotograph());
            holder.imageButtonPicture.setImageDrawable(drawable);
            holder.reportButton.setTag(position);
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
