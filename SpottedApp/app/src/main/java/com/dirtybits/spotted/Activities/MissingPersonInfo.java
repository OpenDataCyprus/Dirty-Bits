package com.dirtybits.spotted.Activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dirtybits.spotted.Models.MissingPerson;
import com.dirtybits.spotted.Models.Person;
import com.dirtybits.spotted.R;
import com.dirtybits.spotted.databinding.ActivityMissingPersonInfoBinding;

public class MissingPersonInfo extends AppCompatActivity {
    ActivityMissingPersonInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_person_info);
        Person _missingPerson = getIntent().getParcelableExtra("person");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_missing_person_info);
        binding.setMissingPerson(_missingPerson);

    }
}
