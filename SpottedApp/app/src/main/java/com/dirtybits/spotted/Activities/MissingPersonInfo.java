package com.dirtybits.spotted.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dirtybits.spotted.Models.MissingPerson;
import com.dirtybits.spotted.Models.Person;
import com.dirtybits.spotted.R;

public class MissingPersonInfo extends AppCompatActivity {
    // ActivityMissingPersonInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_person_info);
        Person _missingPerson = getIntent().getParcelableExtra("person");
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_missing_person_info);
        // binding.setMissingPerson(_missingPerson);
//binding.textViewName.setText(_missingPerson.getFullName());
        TextView textViewName = (TextView) findViewById(R.id.textViewName);
        TextView textViewSpotted = (TextView) findViewById(R.id.textViewSpotted);
        TextView textViewdescription = (TextView) findViewById(R.id.textViewDescription);
        textViewSpotted.setText(Integer.toString(_missingPerson.getTimesSpotted()));
        textViewName.setText(_missingPerson.getFullName());
        textViewdescription.setText(_missingPerson.getDescription());
        TextView textViewdescription1 = (TextView) findViewById(R.id.textViewDescription1);
        textViewdescription1.setText(_missingPerson.getDescription());
    }
}
