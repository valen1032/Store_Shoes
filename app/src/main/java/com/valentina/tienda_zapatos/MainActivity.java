package com.valentina.tienda_zapatos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.valentina.tienda_zapatos.Entidades.Producto;
import com.valentina.tienda_zapatos.Fragments.FragmentServicios;
import com.valentina.tienda_zapatos.Fragments.MainFragments;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, iComunicaFragments {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    ArrayList<Producto> ListaProducto;




    // variables para cargar el fragment principal
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    // variable del fragmentdetalle






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);

        //establecer evento onclick al navigationView
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        // cargar fragment principal

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new MainFragments());
        fragmentTransaction.commit();

    }




    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (menuItem.getItemId() == R.id.principal){
            //Toast.makeText(MainActivity.this, "futura función se implementará en la siguiente versión (Reto 2).", Toast.LENGTH_SHORT).show();
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new MainFragments());
            fragmentTransaction.commit();

        }
        if (menuItem.getItemId() == R.id.productos){
           // Toast.makeText(MainActivity.this, "futura función se implementará en la siguiente versión (Reto 2).", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,ProductosActivity.class);
            startActivity(intent);
            return true;


        }
        if (menuItem.getItemId() == R.id.servicios){
            //Toast.makeText(MainActivity.this, "futura función se implementará en la siguiente versión .", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,ServicesActivity.class);
            startActivity(intent);
            return true;


        }
        if (menuItem.getItemId() == R.id.surcusales){
            //Toast.makeText(MainActivity.this, "futura función se implementará en la siguiente versión .", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,NavegacionActivity.class);
            startActivity(intent);
            return true;
        }

        return false;
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            
        } else if (id == R.id.favorites) {
            
        }
        return super.onOptionsItemSelected(item);
    }

   @Override
    public void enviarProducto(Producto producto) {
        //Aqui se realiza toda la logica necesaria para realizar el envio

        /*detalleProducto = new DetalleProductoFragment();*/
        //objeto bundle para teletransportar la informacion
        Bundle bundleEnvio = new Bundle();

        // enviar el objeto que esta llegando con Serialziable
        bundleEnvio.putSerializable("objeto", producto);
        /*detalleProducto.setArguments(bundleEnvio);*/

        // abrir fragment
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
       /* fragmentTransaction.replace(R.id.container_fragment, new DetalleProductoFragment());*/
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
}