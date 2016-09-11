package com.dirtybits.spotted.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dirtybits.spotted.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class SightingsMaps extends AppCompatActivity implements OnMapReadyCallback {

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
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                LinearLayout info = new LinearLayout(getApplicationContext());
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(getApplicationContext());
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(getApplicationContext());
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });

        LatLng idea = new LatLng(35.17249, 33.362331999999924);
        Marker ideaMarker = mMap.addMarker(new MarkerOptions().position(idea).title("IDEA CY").snippet("Ο αγνοούμενος θεάθηκε στην περιόχη Λήδρας στη Λευκωσία κοντά στο IDEA.\n" +
                                                                "Φορούσε τζιν, μαύρη φανέλα και φαινόταν να μην είναι στα λογικά του!\n" +
                                                                "Η Αστυνομία Λευκωσίας συνεχίζει να διερευνά την υπόθεση."));
        //ideaMarker.showInfoWindow();

        LatLng gsp = new LatLng(35.1143324, 33.36151070000005);
        mMap.addMarker(new MarkerOptions().position(gsp).title("GSP Stadium").snippet("Ο αγνοούμενος θεάθηκε στην περιόχη Στροβόλου στη Λευκωσία κοντά στο στάδιο ΓΣΠ.\n" +
                                                               "Φορούσε μπλε βερμούδα και άσπρη φανέλα. Ο αγνοούμενος πήγαινε ήταν πεζός και είχε κατέυθηνση προς Λευκωσία.\n" +
                                                               "Η Αστυνομία Λευκωσίας συνεχίζει να διερευνά την υπόθεση και κάνει έκληση σε όλους του πολίτες για βοήθεια.."));

        LatLng faneromeniChurch = new LatLng(35.1734049, 33.36263269999995);
        mMap.addMarker(new MarkerOptions().position(faneromeniChurch).title("Faneromeni Church").snippet("Ο αγνοούμενος θεάθηκε στην περιόχη Φανερωμένης στη Λευκωσία κοντά στην εκκλησία.\n" +
                                                                            "Φορούσε τζιν, μαύρη φανέλα και φαινόταν να μην είναι στα λογικά του!\n" +
                                                                            "Η Αστυνομία Λευκωσίας συνεχίζει να διερευνά την υπόθεση."));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(idea));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(35.17249, 33.362331999999924), 15), 4000, null);
    }
}
