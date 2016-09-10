package com.dirtybits.spotted.Activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.dirtybits.spotted.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class SightingsMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sightings_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng idea = new LatLng(35.17249, 33.362331999999924);
        mMap.addMarker(new MarkerOptions().position(idea).title("IDEA Cyprus"));

        LatLng gsp = new LatLng(35.1143324, 33.36151070000005);
        mMap.addMarker(new MarkerOptions().position(gsp).title("GSP Stadium"));

        LatLng faneromeniChurch = new LatLng(35.1734049, 33.36263269999995);
        mMap.addMarker(new MarkerOptions().position(faneromeniChurch).title("Faneromeni Church"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(idea));
    }
}
