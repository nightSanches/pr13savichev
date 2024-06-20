package com.example.pr13savichev;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LocationManager _LocationManager;
    private int ACCESS_FINE_LOCATION;
    private int ACCESS_COARSE_LOCATION;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        _LocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    LocationListener _LocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(@NonNull Location location) {
            if(location == null) return;
            else{
                String message = "";
                if(location.getProvider().equals(LocationManager.GPS_PROVIDER)){
                    message += "\nМестоположение определено с помощью GPS: долгота - " +
                            location.getLatitude() + " широта - " + location.getLatitude();
                }
                if(location.getProvider().equals(LocationManager.NETWORK_PROVIDER)){
                    message += "\nМестоположение определено с помощью интернета: долгота - " +
                            location.getLatitude() + " широта - " + location.getLatitude();
                }
                result.setText(message);
            }
        }
    };

}