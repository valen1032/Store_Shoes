package com.valentina.tienda_zapatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ServicesActivity extends AppCompatActivity {
    EditText txtidPro, txtnombre, txtdescripcion, txtprecio, txtmarca;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        txtidPro = findViewById(R.id.txtidProductos);
        txtnombre = findViewById(R.id.txtNombre);
        txtdescripcion = findViewById(R.id.txtDescripcion);
        txtprecio = findViewById(R.id.txtPrecio);
        txtmarca = findViewById(R.id.txtMarca);

        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeerWS();
                EnviarWs(txtidPro.getText().toString(),txtnombre.getText().toString(),txtdescripcion.getText().toString(),txtprecio.getText().toString(),txtmarca.getText().toString());
                ActualizarWs(txtidPro.getText().toString(),txtnombre.getText().toString(),txtdescripcion.getText().toString(),txtprecio.getText().toString(),txtmarca.getText().toString());
                EliminarWs();

            }
        });

    }

    private void LeerWS() {
        String url = "https://gc8afe71e1ec9c8-dypdrpvscskczmrs.adb.us-chicago-1.oraclecloudapps.com/ords/admin/productos/productos" ;
        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    txtidPro.setText(jsonObject.getString("idproductos"));
                    txtnombre.setText( jsonObject.getString("nombre"));
                    txtdescripcion.setText( jsonObject.getString("descripcion"));
                    txtprecio.setText(jsonObject.getString("precio"));
                    txtmarca.setText( jsonObject.getString("marca"));

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }

    private void EnviarWs(final String nombre, final String descripcion, final String precio , final String marca ,final String idproductos){
        String url = "https://gc8afe71e1ec9c8-dypdrpvscskczmrs.adb.us-chicago-1.oraclecloudapps.com/ords/admin/productos/productos" ;
        StringRequest postResquest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    Toast.makeText(ServicesActivity.this, "RESULTADO POST =  " + response, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        })
        {
            protected Map<String, String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put( "idprductos",idproductos);
                params.put( "nombre",nombre);
                params.put( "descripcion",descripcion);
                params.put( "precio",precio);
                params.put( "marca",marca);
                return params;

            }
        }
                ;
        Volley.newRequestQueue(this).add(postResquest);

    }
    private void ActualizarWs(final String nombre, final String descripcion, final String precio , final String marca ,final String idproductos){
        String url = "https://gc8afe71e1ec9c8-dypdrpvscskczmrs.adb.us-chicago-1.oraclecloudapps.com/ords/admin/productos/productos" ;
        StringRequest postResquest = new StringRequest(Request.Method.PUT, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    Toast.makeText(ServicesActivity.this, "RESULTADO =  " + response, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        })
        {
            protected Map<String, String> getParams(){
                Map<String,String> params = new HashMap<>();
                params.put("idproductos", "1");
                params.put( "nombre",nombre);
                params.put( "descripcion",descripcion);
                params.put( "precio",precio);
                params.put( "marca",marca);
                params.put("idproductos", idproductos);


                return params;

            }
        };
        Volley.newRequestQueue(this).add(postResquest);

    }
    private void EliminarWs() {

        String url = "https://gc8afe71e1ec9c8-dypdrpvscskczmrs.adb.us-chicago-1.oraclecloudapps.com/ords/admin/productos/productos";

        StringRequest postResquest = new StringRequest(Request.Method.DELETE, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Toast.makeText(ServicesActivity.this, "RESULTADO = " + response, Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }
}