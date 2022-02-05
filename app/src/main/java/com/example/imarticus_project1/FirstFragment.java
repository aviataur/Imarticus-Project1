package com.example.imarticus_project1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setOnClickListenerToViews(view);
    }

    private void setOnClickListenerToViews(View view) {
        view.findViewById(R.id.optionChat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),R.string.option_chat,Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.optionGallery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),R.string.option_gallery,Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.optionLocation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),R.string.option_location,Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.optionFriends).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),R.string.option_friends,Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.optionMusic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),R.string.option_music,Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.optionNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),R.string.option_notifications,Toast.LENGTH_SHORT).show();
            }
        });

    }
}