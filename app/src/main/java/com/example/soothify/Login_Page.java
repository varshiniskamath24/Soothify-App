package com.example.soothify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
class hospitals {
    int id;
    String name;
    double latitude;
    double longitude;
    String phone;
}

public class Login_Page extends AppCompatActivity {
    //private saveSharedPreferences SaveSharedPreferences;

    private static final int REQUEST_CALL = 1;
    public Button quiz_button,progress_button,profile_button,about_button;
    FusedLocationProviderClient mFusedLocationClient;
    Location location;
    int PERMISSION_ID = 44;
    String condition;
    hospitals h[] = new hospitals[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Intent intent = getIntent();
        if(intent.getStringExtra("Condition") != null) {
            condition = intent.getStringExtra("Condition");
        }

        h[0] = new hospitals();
        h[0].id = 1;
        h[0].name = "KMC";
        h[0].latitude = 13.3537;
        h[0].longitude = 74.7897;
        h[0].phone = "9644441909";
        h[1] = new hospitals();
        h[1].id = 2;
        h[1].name = "Manipal Hospital";
        h[1].latitude = 12.9584;
        h[1].longitude = 74.6488;
        h[1].phone = "8762315288";
        h[2] = new hospitals();
        h[2].id = 3;
        h[2].name = "Smt. Sharada Madhav Pai OPD";
        h[2].latitude = 13.3378;
        h[2].longitude = 74.7371;
        h[2].phone = "9928681590";
        //SaveSharedPreferences=new saveSharedPreferences(getApplicationContext());
        quiz_button = (Button) findViewById(R.id.Quiz_button_1);
        quiz_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Page.this, Quiz_for_Stress.class);
                startActivity(intent);
            }
        });
        progress_button = (Button) findViewById(R.id.Status_button_1);
        progress_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Page.this, Progress_page.class);
                intent.putExtra("Condition", condition);
                startActivity(intent);
            }
        });
        profile_button = (Button) findViewById((R.id.Profile_button_1));
        profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Page.this, MainActivity.class);
                startActivity(intent);
            }
        });
        about_button = (Button) findViewById((R.id.About_button_1));
        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_Page.this, About.class);
                startActivity(intent);
            }
        });

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        FloatingActionButton emergency = findViewById(R.id.emergency);
        if (!checkPermissions()) {
            requestPermissions();
        }
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLastLocation();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @SuppressLint("MissingPermission")
    private void getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        location = task.getResult();
                        if (location == null) {
                            requestNewLocationData();
                        } else {
                            int minIndex=0;
                            double minDist = 99999;
                            for(int i=0; i<3; i++) {
                                double dist = Math.sqrt(Math.pow(h[i].latitude - location.getLatitude(), 2) +
                                        Math.pow(h[i].longitude - location.getLongitude(), 2) * 1.0);
                                if(dist <= minDist) {
                                    minDist = dist;
                                    minIndex = i;
                                }
                            }
                            makeCall(h[minIndex].phone);
                           // makeCall("9644441909");
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            requestPermissions();
        }
    }
    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location location = locationResult.getLastLocation();
            int minIndex=0;
            double minDist = 99999;
            for(int i=0; i<3; i++) {
                double dist = Math.sqrt(Math.pow(h[i].latitude - location.getLatitude(), 2) +
                        Math.pow(h[i].longitude - location.getLongitude(), 2) * 1.0);
                if(dist <= minDist) {
                    minDist = dist;
                    minIndex = i;
                }
            }
            makeCall(h[minIndex].phone);
            //makeCall("9644441909");
        }
    };

    // method to check for permissions
    private boolean checkPermissions() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;
    }

    // method to request for permissions
    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CALL_PHONE}, PERMISSION_ID);
    }

    // method to check
    // if location is enabled
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }
    private void makeCall(String number) {
        if(number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(Login_Page.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Login_Page.this,
                        new String[] {Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(Login_Page.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }
    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }
    /*public void logout()
    {
        SaveSharedPreferences.login_status(false);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }*/

}

