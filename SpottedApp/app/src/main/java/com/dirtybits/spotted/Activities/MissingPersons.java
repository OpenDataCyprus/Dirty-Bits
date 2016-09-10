package com.dirtybits.spotted.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dirtybits.spotted.Adapters.AdapterMissingPerson;
import com.dirtybits.spotted.Models.MissingPerson;
import com.dirtybits.spotted.R;

public class MissingPersons extends AppCompatActivity {

    private RecyclerView _recyclerView;
    private RecyclerView.LayoutManager _recyclerViewLayoutManager;
    private AdapterMissingPerson _adapterMissingPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_missing_persons);

        _recyclerView = (RecyclerView) findViewById(R.id.recycleViewMissingPersons);
        _recyclerView.setHasFixedSize(true);
        _recyclerViewLayoutManager = new LinearLayoutManager(this);
        _recyclerView.setLayoutManager(_recyclerViewLayoutManager);
        _adapterMissingPerson = new AdapterMissingPerson(getApplicationContext());
        _recyclerView.setAdapter(_adapterMissingPerson);
    }

    public void OpenPeron(View view) {
        int position = (int) view.getTag();
        MissingPerson person = _adapterMissingPerson.getSelectedPerson(position);
        Intent personIntent = new Intent();
        personIntent.putExtra("person", person);
        setResult(RESULT_OK,personIntent);
        finish();
    }
}
