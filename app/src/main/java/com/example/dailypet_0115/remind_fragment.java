package com.example.dailypet_0115;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class remind_fragment extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{

    private GoogleMap mMap;
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    LocationRequest mLocationRequest;
    ImageView MapBack;

    private int PROXIMITY_RADIUS = 2500;

    public remind_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_maps, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()/////////////
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //return inflater.inflate(R.layout.activity_maps, container, false);

        return rootView;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkLocationPermission();


        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) this.getActivity().getSupportFragmentManager()/////////////
                .findFragmentById(R.id.map);
        //Toast.makeText(getActivity(),"22", Toast.LENGTH_LONG).show();/////////////
        //Toast.makeText(getActivity(),String.valueOf(mapFragment), Toast.LENGTH_LONG).show();/////////////
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
            //Toast.makeText(getActivity(),"333", Toast.LENGTH_LONG).show();/////////////
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
//        mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        //Toast.makeText(getActivity(),"4444", Toast.LENGTH_LONG).show();/////////////
        //Initialize Google Play Services
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getActivity().getApplication(),///////////////////////////////
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);

                //Toast.makeText(getActivity(),"55555", Toast.LENGTH_LONG).show();/////////////
            }
        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }

        ImageView btncare = getView().findViewById(R.id.B_veterinaryhospital);
        btncare.setOnClickListener(new View.OnClickListener() {
            String Restaurant = "restaurant";
            String veterinary_care="veterinary_care";
            @Override
            public void onClick(View v) {
                mMap.clear();

                String url = getUrl(mLastLocation.getLatitude(), mLastLocation.getLongitude(), veterinary_care);
                Object[] DataTransfer = new Object[2];
                DataTransfer[0] = mMap;
                DataTransfer[1] = url;
                GetNearbyPlaces getNearbyPlacesData = new GetNearbyPlaces();
                getNearbyPlacesData.execute(DataTransfer);
                Toast.makeText(getActivity(),"附近的寵物醫院...", Toast.LENGTH_LONG).show();/////////////
            }
        });

        ImageView btnstore = getView().findViewById(R.id.B_petsalon);
        btnstore.setOnClickListener(new View.OnClickListener() {
            String pet_store = "pet_store";
            @Override
            public void onClick(View v) {
                mMap.clear();
                String url = getUrl(mLastLocation.getLatitude(), mLastLocation.getLongitude(), pet_store);
                Object[] DataTransfer = new Object[2];
                DataTransfer[0] = mMap;
                DataTransfer[1] = url;
                GetNearbyPlaces getNearbyPlacesData = new GetNearbyPlaces();
                getNearbyPlacesData.execute(DataTransfer);
                Toast.makeText(getActivity(),"附近的寵物店...", Toast.LENGTH_LONG).show();//////////////
            }
        });
    }


    protected synchronized void buildGoogleApiClient() {///////////////protect
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity().getApplication())////////////////////
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(getActivity().getApplication(),//////////////////////////
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {

        mLastLocation = location;
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker.remove();
        }

        //Place current location marker
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.title("當前位置");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mCurrLocationMarker = mMap.addMarker(markerOptions);

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11));

        //stop location updates
        if (mGoogleApiClient != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    public void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity().getApplication(),///////////////////////
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (shouldShowRequestPermissionRationale(///////////////////////////////
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {

                //Prompt the user once explanation has been shown
                requestPermissions(////////////////////////////////
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);


            } else {
                requestPermissions(/////////////////////////////////
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(getActivity().getApplication(),//////////////////////////
                            android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                } else {
                    Toast.makeText(getActivity(), "permission denied", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

//////==============   ===========  ==========  =========  =======  ============  ==========  =========  ============  ====== =====  ====

    private boolean CheckGooglePlayServices() {////////////private
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(getActivity());//////////////////////////////
        if(result != ConnectionResult.SUCCESS) {
            if(googleAPI.isUserResolvableError(result)) {
                googleAPI.getErrorDialog(getActivity(), result,///////////////////
                        0).show();
            }
            return false;
        }
        return true;
    }

    private String getUrl(double latitude, double longitude, String nearbyPlace) {////////////////private
        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=").append(latitude).append(",").append(longitude);
        googlePlacesUrl.append("&radius=").append(PROXIMITY_RADIUS);
        googlePlacesUrl.append("&types=").append(nearbyPlace);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + "AIzaSyBt7_eLLSV66gAbwMPvv8bqp5b9QklPYzc");
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

}

