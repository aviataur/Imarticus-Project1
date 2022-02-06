package com.example.imarticus_project1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import static android.content.ContentValues.TAG;

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
        view.findViewById(R.id.buttonLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLogin(view);
            }
        });

    }
    private void onLogin(View v){
        EditText username = (EditText) v.findViewById(R.id.editTextUsername);
        String credentials = username.toString();
        if(!credentials.isEmpty()) {
            FirebaseMessaging.getInstance().subscribeToTopic(credentials)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            String msg = getString(R.string.msg_subscribed);
                            if (task.isSuccessful()) {
                                NavHostFragment.findNavController(FirstFragment.this)
                                        .navigate(R.id.action_FirstFragment_to_fragmentSecond);
                            } else {
                                msg = getString(R.string.msg_subscribe_failed);
                                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
                            }
                            Log.d(TAG, msg);
                        }
                    });
        }
        else
        {
            Toast.makeText(getActivity(), R.string.invalid_user, Toast.LENGTH_SHORT).show();
        }
    }



}