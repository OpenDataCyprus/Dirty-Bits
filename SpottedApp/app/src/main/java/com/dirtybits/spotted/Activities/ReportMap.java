package com.dirtybits.spotted.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.dirtybits.spotted.R;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class ReportMap extends AppCompatActivity implements OnMapReadyCallback,
        GoogleMap.OnMapLongClickListener,
        SlidingUpPanelLayout.PanelSlideListener,
        View.OnCreateContextMenuListener{

    private GoogleMap mMap;
    private SlidingUpPanelLayout slidingUpPanelLayout;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        slidingUpPanelLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        slidingUpPanelLayout.setPanelHeight(150);
        slidingUpPanelLayout.setPanelSlideListener(this);
        button = (ImageButton) findViewById(R.id.imageButtonPhoto);
        registerForContextMenu(button);

    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, v.getId(), 0, "Capture");
        menu.add(0, v.getId(), 0, "Upload");
        menu.add(0, v.getId(), 0, "Remove");
        menu.add(0, v.getId(), 0, "View");
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Capture") {
            TakePicture();
        }
        else if (item.getTitle() == "Upload") {
            Toast.makeText(this, "Action 2 invoked", Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle() == "Remove") {
            Toast.makeText(this, "Action 3 invoked", Toast.LENGTH_SHORT).show();
        }
        else if (item.getTitle() == "View") {
            Toast.makeText(this, "Action 3 invoked", Toast.LENGTH_SHORT).show();
        }
        else {
            return false;
        }
        return true;
    }

    private void TakePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            button.setImageBitmap(imageBitmap);
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(this);
    }

    public void ReportPerson(View view) {

        Toast.makeText(getApplicationContext(), "Reported", Toast.LENGTH_LONG);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions().position(latLng)
                .draggable(false));

        slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (slidingUpPanelLayout.getPanelState() == SlidingUpPanelLayout.PanelState.EXPANDED)
            slidingUpPanelLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }

    @Override
    public void onPanelSlide(View view, float v) {

    }

    @Override
    public void onPanelCollapsed(View view) {

    }

    @Override
    public void onPanelExpanded(View view) {

    }

    @Override
    public void onPanelAnchored(View view) {

    }

    @Override
    public void onPanelHidden(View view) {

    }

    @Override
    public void onPanelHiddenExecuted(View view, Interpolator interpolator, int i) {

    }

    @Override
    public void onPanelShownExecuted(View view, Interpolator interpolator, int i) {

    }

    @Override
    public void onPanelExpandedStateY(View view, boolean b) {

    }

    @Override
    public void onPanelCollapsedStateY(View view, boolean b) {

    }

    @Override
    public void onPanelLayout(View view, SlidingUpPanelLayout.PanelState panelState) {

    }
}
