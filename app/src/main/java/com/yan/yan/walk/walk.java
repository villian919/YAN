package com.yan.yan.walk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;
import com.yan.yan.R;
import com.yan.yan.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class walk extends AppCompatActivity {

    private onboardinAdapter onboardinAdapter;
    private LinearLayout layoutOnboardingIndicator;
    private MaterialButton buttonOnboardingAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);

        layoutOnboardingIndicator = findViewById(R.id.layoutonboardingIndicator);
        buttonOnboardingAction = findViewById(R.id.buttonOnboardingAction);

        setupOnboardingItems();


        ViewPager2 onboardingViewPager = findViewById(R.id.onboardingView);
        onboardingViewPager.setAdapter(onboardinAdapter);

        setupOnboardIndicator();
        setCurrentOnboardingIndicator(0);

        onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentOnboardingIndicator(position);
            }
        });

        buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onboardingViewPager.getCurrentItem() + 1 < onboardinAdapter.getItemCount()) {
                    onboardingViewPager.setCurrentItem(onboardinAdapter.getItemCount() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });
    }

    private void setupOnboardingItems() {
        List<OnboardingItem> onboardingItems = new ArrayList<>();

        OnboardingItem view1 = new OnboardingItem();
        view1.setTitle("Selamat Datang");
        view1.setDesc("App My Self");
        view1.setImage(R.drawable.logo);

        OnboardingItem view2 = new OnboardingItem();
        view2.setTitle("Tidak Login dan Daftar");
        view2.setDesc("Slide to Next page");
        view2.setImage(R.drawable.logo);

        OnboardingItem view3 = new OnboardingItem();
        view3.setTitle("Selamat Menggunakan");
        view3.setDesc("YanApp");
        view3.setImage(R.drawable.logo);

        onboardingItems.add(view1);
        onboardingItems.add(view2);
        onboardingItems.add(view3);

        onboardinAdapter = new onboardinAdapter(onboardingItems);
    }

    private void setupOnboardIndicator() {
        ImageView[] indicator = new ImageView[onboardinAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );

        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicator.length; i++){
            indicator[i] = new ImageView(getApplicationContext());
            indicator[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(), R.drawable.onboarding_indicator_inactive
            ));
            indicator[i].setLayoutParams(layoutParams);
            layoutOnboardingIndicator.addView(indicator[i]);
        }
    }

    private void setCurrentOnboardingIndicator(int index) {
        int count = layoutOnboardingIndicator.getChildCount();
        for (int i = 0; i < count; i++) {
            ImageView imageView = (ImageView) layoutOnboardingIndicator.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),
                                R.drawable.onboarding_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),
                                R.drawable.onboarding_indicator_inactive)
                );
            }
        }
        if (index == onboardinAdapter.getItemCount() - 1) {
            buttonOnboardingAction.setText("Start");
        } else {
            buttonOnboardingAction.setText("Next");
        }
    }
}