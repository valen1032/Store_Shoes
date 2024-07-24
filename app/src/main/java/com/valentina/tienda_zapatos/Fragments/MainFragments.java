package com.valentina.tienda_zapatos.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;


import com.valentina.tienda_zapatos.R;

import java.util.Set;

public class MainFragments extends Fragment {

    @Nullable
    public View onCreateView(@Nullable LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container, false);
        return view;
    }


}
