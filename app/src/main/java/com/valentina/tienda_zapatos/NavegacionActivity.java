package com.valentina.tienda_zapatos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.valentina.tienda_zapatos.Fragments.MainFragments;

public class NavegacionActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegacion);

        bottomNavigationView = findViewById(R.id.botom_navigation);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if ( id == R.id.nav_home){
                    Intent intent = new Intent(NavegacionActivity.this, MainFragments.class);
                    startActivity(intent);
                    
                }  else if (id == R.id.nav_ubicacion) {
                    Intent intent = new Intent(NavegacionActivity.this,SurcusalActivity.class);
                    startActivity(intent);
                    
                }
                return false;
            }
        });
    }
}