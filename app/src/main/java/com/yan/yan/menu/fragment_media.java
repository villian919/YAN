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
import com.yan.yan.menu.media.media_video;
import com.yan.yan.menu.media.media_musik;

public class fragment_media extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_media, container, false);
        Button btn = (Button) view.findViewById(R.id.btn_musik);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.musik_page, new media_musik());
                fr.commit();
            }
        });

        Button btn1 = (Button) view.findViewById(R.id.btn_video);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fr = getFragmentManager().beginTransaction();
                fr.replace(R.id.musik_page, new media_video());
                fr.commit();
            }
        });
        return view;
    }
}
