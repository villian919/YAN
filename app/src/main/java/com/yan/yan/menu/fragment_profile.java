package com.yan.yan.menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.yan.yan.R;
import com.yan.yan.menu.profile.about;
import com.yan.yan.menu.profile.contact;
import com.yan.yan.menu.profile.profile;
import com.yan.yan.menu.profile.profile_find_me;

public class fragment_profile extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Button btn = (Button) view.findViewById(R.id.btn_provile_provile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.provile_page, new profile());
                fr.commit();
            }
        });

        Button btn2 = (Button) view.findViewById(R.id.btn_contact);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.provile_page, new contact());
                fr.commit();
            }
        });

        Button btn3 = (Button) view.findViewById(R.id.btn_find);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.provile_page, new profile_find_me());
                fr.commit();
            }
        });

        Button btn4 = (Button) view.findViewById(R.id.btn_about);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.provile_page, new about());
                fr.commit();
            }
        });
        return view;
    }

}
