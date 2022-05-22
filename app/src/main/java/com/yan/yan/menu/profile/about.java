package com.yan.yan.menu.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yan.yan.MainActivity;
import com.yan.yan.R;

public class about extends Fragment  {

    private Button ShowDialog;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View viewe = inflater.inflate(R.layout.profile_about, container, false);

        ShowDialog = viewe.findViewById(R.id.showDialog);
        ShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());

                //Memasang Title / Judul pada Custom Dialog
                dialog.setTitle("Contoh Custom Dialog");

                //Memasang Desain Layout untuk Custom Dialog
                dialog.setContentView(R.layout.dialog_custome);

                //Memasang Listener / Aksi saat tombol OK di Klik
                Button DialogButton = dialog.findViewById(R.id.ok);
                DialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });

        return viewe;
    }
}