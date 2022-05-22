package com.yan.yan.walk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yan.yan.R;

import java.util.List;

public class onboardinAdapter extends RecyclerView.Adapter<onboardinAdapter.OnboardingViewHolder> {

    private List<com.yan.yan.walk.OnboardingItem> onboardingItems;

    public onboardinAdapter(List<com.yan.yan.walk.OnboardingItem> onboardingItems) {
        this.onboardingItems = onboardingItems;
    }

    @NonNull
    @Override
    public OnboardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnboardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_onboarding, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnboardingViewHolder holder, int position) {
        holder.setOnboardingData(onboardingItems.get(position));
    }

    @Override
    public int getItemCount() {
        return onboardingItems.size();
    }

    class OnboardingViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;
        private TextView textdec;
        private ImageView imageOnboarding;

        OnboardingViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textdec = itemView.findViewById(R.id.textdec);
            imageOnboarding = itemView.findViewById(R.id.imageOnboarding);
        }

        void setOnboardingData(com.yan.yan.walk.OnboardingItem onboardingItem) {
            textTitle.setText(onboardingItem.getTitle());
            textdec.setText(onboardingItem.getDesc());
            imageOnboarding.setImageResource(onboardingItem.getImage());
        }
    }

}
