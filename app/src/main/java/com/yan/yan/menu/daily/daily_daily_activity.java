package com.yan.yan.menu.daily;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yan.yan.R;
import com.yan.yan.menu.daily.adapter.daily.adapter_daily_activity;
import com.yan.yan.menu.daily.adapter.daily.helper_adapter_daily_activity;

import java.util.ArrayList;

public class daily_daily_activity extends Fragment {
    @Nullable
    RecyclerView recyclerView;
    ArrayList name_daily, images_daily;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.daily_daily_activity, container, false);
        recyclerView = view.findViewById(R.id.recycleView);
        images_daily = new ArrayList();
        name_daily = new ArrayList();
        for (int i = 0; i<adapter_daily_activity.name_daily.length; i++)
        {
            images_daily.add(adapter_daily_activity.images_daily);
            name_daily.add(adapter_daily_activity.name_daily);
        }
        helper_adapter_daily_activity helperAdapter = new helper_adapter_daily_activity (getContext(), images_daily, name_daily);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(helperAdapter);

        return view;
    }
}