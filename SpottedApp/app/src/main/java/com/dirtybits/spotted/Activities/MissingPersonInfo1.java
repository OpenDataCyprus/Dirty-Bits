package com.dirtybits.spotted.Activities;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dirtybits.spotted.Models.MissingPerson;
import com.dirtybits.spotted.Models.Person;
import com.dirtybits.spotted.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class MissingPersonInfo1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activity);
        MissingPerson _missingPerson = getIntent().getParcelableExtra("person");
        TextView textViewName = (TextView) findViewById(R.id.textViewName);
        TextView textViewDescription = (TextView) findViewById(R.id.textViewDescription);
        TextView textViewSpotted = (TextView) findViewById(R.id.textViewSpotted);
        TextView textViewMissingSince = (TextView) findViewById(R.id.textViewMissingSince);
        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.profile_image);
        Drawable drawable = new BitmapDrawable(getResources(), _missingPerson.getPhotograph());
        circleImageView.setImageDrawable(drawable);
        textViewName.setText(_missingPerson.getFullName());
        textViewDescription.setText(_missingPerson.getDescription());
        textViewSpotted.setText(Integer.toString(_missingPerson.getTimesSpotted()));
        textViewMissingSince.setText(_missingPerson.getMissingDate());
    }

    public void showSightingsMap(View view)
    {
        Intent intent = new Intent(this, SightingsMaps.class);
        startActivity(intent);
    }
}
