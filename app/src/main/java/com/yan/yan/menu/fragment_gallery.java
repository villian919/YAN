package com.yan.yan.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yan.yan.R;
import com.yan.yan.menu.galley.adapter_gallery;

import java.util.ArrayList;

public class fragment_gallery extends Fragment {
    ArrayList<String> ImgUrl= new ArrayList<>();
    RecyclerView recyclerView;
    adapter_gallery adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        ImgUrl.add("https://github.com/villian919/klikshowtime/raw/master/IMG_20210920_100142.jpg");
        ImgUrl.add("https://github.com/villian919/klikshowtime/blob/master/IMG_20220305_144639.jpg?raw=true");
        ImgUrl.add("https://github.com/villian919/klikshowtime/blob/master/myfoto.jpg?raw=true");


        this.recyclerView = (RecyclerView)view.findViewById(R.id.recycleView);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));
        adapter = new adapter_gallery(ImgUrl, getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
