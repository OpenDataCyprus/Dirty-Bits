package com.dirtybits.spotted;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.dirtybits.spotted.Activities.MissingCars;
import com.dirtybits.spotted.Activities.MissingPersons;
import com.dirtybits.spotted.Activities.MissingPlates;
import com.dirtybits.spotted.Activities.WantedPersons;

public class MainActivityWithoutDrawer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_without_drawer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    public void OpenMissinqPersons(View view) {
        Intent intent = new Intent(MainActivityWithoutDrawer.this, MissingPersons.class);
        startActivity(intent);
    }

    public void OpenWantedPersons(View view) {
        Intent intent = new Intent(MainActivityWithoutDrawer.this, WantedPersons.class);
        startActivity(intent);
    }

    public void OpenStolenVehicles(View view) {
        Intent intent = new Intent(MainActivityWithoutDrawer.this, MissingCars.class);
        startActivity(intent);
    }

    public void OpenLicensePlates(View view) {
        Intent intent = new Intent(MainActivityWithoutDrawer.this, MissingPlates.class);
        startActivity(intent);
    }

}
