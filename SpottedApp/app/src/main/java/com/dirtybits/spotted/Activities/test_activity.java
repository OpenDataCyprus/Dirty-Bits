package com.dirtybits.spotted.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dirtybits.spotted.Models.Person;
import com.dirtybits.spotted.R;

public class test_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activity);
        Person _missingPerson = getIntent().getParcelableExtra("person");
        TextView textViewName = (TextView) findViewById(R.id.textViewName);
        TextView textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        TextView textViewSpotted = (TextView) findViewById(R.id.textViewSpotted);
        TextView textViewMissingSince = (TextView) findViewById(R.id.textViewDate);
        textViewName.setText(_missingPerson.getFullName());
        textViewDescription.setText(_missingPerson.getDescription());
        textViewSpotted.setText(Integer.toString(_missingPerson.getTimesSpotted()));
       // textViewMissingSince.setText(_missingPerson.get);
    }
}
