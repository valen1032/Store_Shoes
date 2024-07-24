package com.valentina.tienda_zapatos.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.valentina.tienda_zapatos.R;

public class FragmentServicios extends Fragment {

    @Nullable
    public View onCreateView(@Nullable LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.servicios_fragment,container, false);
        return view;
    }


}
