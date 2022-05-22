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
import com.yan.yan.menu.daily.friend.adapter_friend;
import com.yan.yan.menu.daily.friend.adapter_helper_friend;

import java.util.ArrayList;

public class daily_friends_list extends Fragment {

    RecyclerView recyclerView;
    ArrayList imagesTeman, namaTeman;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.daily_friends_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewteman);
        imagesTeman = new ArrayList();
        namaTeman = new ArrayList();
        for (int i = 0; i< adapter_friend.namaTeman.length; i++)
        {
            imagesTeman.add(adapter_friend.fotoTeman);
            namaTeman.add(adapter_friend.namaTeman);
        }
        adapter_helper_friend helperAdapterFriend = new adapter_helper_friend(getContext(), imagesTeman, namaTeman);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(helperAdapterFriend);

        return view;
    }
}