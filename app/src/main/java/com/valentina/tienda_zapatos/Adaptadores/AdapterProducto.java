package com.valentina.tienda_zapatos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.valentina.tienda_zapatos.Entidades.Producto;
import com.valentina.tienda_zapatos.R;

import java.util.ArrayList;

public class AdapterProducto extends RecyclerView.Adapter<AdapterProducto.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList <Producto> listaProductos;
    private View.OnClickListener listener;

    public AdapterProducto(ArrayList<Producto> listaProducto) {
        this.listaProductos = listaProductos;
    }


    public AdapterProducto(Context context, ArrayList<Producto> productos){
        this.listaProductos = productos;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View filaproductos = inflater.inflate(R.layout.fila_productos, parent, false);
        filaproductos.setOnClickListener(this);
        return new ViewHolder(filaproductos);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombre = listaProductos.get(position).getNombre();
        String descripcion = listaProductos.get(position).getDescripcion();
        String precio = listaProductos.get(position).getPrecio();
        String marca = listaProductos.get(position).getMarca();
        holder.nombre.setText(nombre);
        holder.descripcion.setText(descripcion);
        holder.precio.setText(precio);
        holder.marca.setText(marca);

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }

    }

    public void setListaProductos(ArrayList<Producto> listaProducto) {
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView nombre,descripcion,precio,marca;



         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             nombre = itemView.findViewById(R.id.nombre_producto);
             descripcion = itemView.findViewById(R.id.nombre_producto);
             precio = itemView.findViewById(R.id.precio_adidas);
             marca = itemView.findViewById(R.id.marca_adidas);
         }
     }
}
