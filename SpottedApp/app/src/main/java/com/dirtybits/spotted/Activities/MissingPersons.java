package com.dirtybits.spotted.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dirtybits.spotted.Adapters.AdapterMissingPerson;
import com.dirtybits.spotted.Listeners.RecyclerItemClickListener;
import com.dirtybits.spotted.Models.MissingPerson;
import com.dirtybits.spotted.Models.Person;
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
        _recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplication(), _recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        ViewInfo(position);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
    }

    public void ReportPerson(View view) {
        int position = (int) view.getTag();
        Person person = _adapterMissingPerson.getSelectedPerson(position);
        Intent personIntent = new Intent(MissingPersons.this, MissingPersonInfo.class);
        personIntent.putExtra("person", person);
        setResult(RESULT_OK, personIntent);
        finish();
    }

    public void ViewInfo(int position)
    {
        Person person = _adapterMissingPerson.getSelectedPerson(position);
        Intent personIntent = new Intent(MissingPersons.this, MissingPersonInfo.class);
        personIntent.putExtra("person", person);
        setResult(RESULT_OK, personIntent);
        startActivity(personIntent);
    }
}
