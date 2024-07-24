package com.valentina.tienda_zapatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.library.BuildConfig;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class SurcusalActivity extends AppCompatActivity {
    private MapView mapView;
    private IMapController controller;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surcusal);
        Configuration.getInstance().setUserAgentValue(BuildConfig.BUILD_TYPE);
        isStoragePermissionGranted();

        mapView = findViewById(R.id.mapViewReto4);
        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setVisibility(View.VISIBLE);
        mapView.setMultiTouchControls(true);
        controller=mapView.getController();
        controller.setZoom(15.0);
        GeoPoint puntoGranEstacion = new GeoPoint(4.647250,-74.101606);
        controller.setCenter(puntoGranEstacion);
        Marker pointGE = new Marker(mapView);
        pointGE.setTitle("Surcusal Tienda Adidas, Gran Estacion");
        pointGE.setPosition(puntoGranEstacion);
        pointGE.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(pointGE);
        GeoPoint puntoPortal80 = new GeoPoint(4.7095276,-74.1221168);
        controller.setCenter(puntoPortal80);
         Marker pointP80 = new Marker(mapView);
        pointP80.setTitle("Surcusal Tienda Nike, Portal 80");
        pointP80.setPosition(puntoPortal80);
        pointP80.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(pointP80);
        GeoPoint puntoCCEden = new GeoPoint(4.646601,-74.1292825);
        controller.setCenter(puntoCCEden);
        Marker pointCE = new Marker(mapView);
        pointCE.setTitle("Surcusal Tienda Reebok, El Eden");
        pointCE.setPosition(puntoCCEden);
        pointCE.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(pointCE);
        GeoPoint puntoUsaquen = new GeoPoint(4.6981956,-74.0347981);
        controller.setCenter(puntoUsaquen);
        Marker pointU = new Marker(mapView);
        pointU.setTitle("Surcusal Tienda Adidas, Usaquen");
        pointU.setPosition(puntoUsaquen);
        pointU.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(pointU);

        GeoPoint puntoCandelaria = new GeoPoint(4.5995859,-74.0949381);
        controller.setCenter(puntoCandelaria);
        Marker pointC = new Marker(mapView);
        pointC.setTitle("Surcusal Tienda Nike,La candelaria");
        pointC.setPosition(puntoCandelaria);
        pointC.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
        mapView.getOverlays().add(pointC);
        GeoPoint puntoLa93 = new GeoPoint(4.6782257,-74.0571086);
        controller.setCenter(puntoLa93);
       Marker pointG93 = new Marker(mapView);
        pointG93.setTitle("Surcusal Tienda Reebok, el parque de la 93");
        pointG93.setPosition(puntoLa93);
        pointG93.setAnchor(Marker.ANCHOR_CENTER,Marker.ANCHOR_BOTTOM);
       mapView.getOverlays().add(pointG93);

    }



    protected void onResume(){
        super.onResume();
        if (mapView!=null){
            mapView.onResume();
        }
    }protected void onPause(){
        super.onPause();
        if (mapView!=null){
            mapView.onPause();
        }
    }

    private boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                return false;
            } else{
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION},1);
                return false;

            }
        }else {
            return true;
        }

    }
}