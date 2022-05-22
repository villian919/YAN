package com.yan.yan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.yan.yan.menu.fragment_daily;
import com.yan.yan.menu.fragment_gallery;
import com.yan.yan.menu.fragment_home;
import com.yan.yan.menu.fragment_media;
import com.yan.yan.menu.fragment_profile;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new fragment_home()).commit();

        bottomNavigationView=findViewById(R.id.bottom_navigaton);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment f = null;
                switch (item.getItemId()){
                    case R.id.menu1:
                        f = new fragment_home();
                        break;
                    case R.id.menu2:
                        f = new fragment_daily();
                        break;
                    case R.id.menu3:
                        f = new fragment_gallery();
                        break;
                    case R.id.menu4:
                        f = new fragment_media();
                        break;
                    case R.id.menu5:
                        f = new fragment_profile();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
                return true;
            }
        });
    }
}