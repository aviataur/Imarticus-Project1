package com.example.imarticus_project1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSecond#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FragmentSecond extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSecond.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSecond newInstance(String param1, String param2) {
        FragmentSecond fragment = new FragmentSecond();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSecond() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.buttonSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });
    }

    private void sendMessage(View v){
        EditText receiver = v.findViewById(R.id.editTextReceiverName);
        EditText msgBody = v.findViewById(R.id.editTextMessageBody);



        if(!receiver.getText().toString().isEmpty()){

            Message message =
                    Message.builder()
                    .putData("From:", "850")
                    .putData("msg", msgBody.getText().toString())
                    .setTopic(receiver.getText().toString())
                    .build();
            String response = null;
            try {
                response = FirebaseMessaging.getInstance().send(message);
            } catch (FirebaseMessagingException e) {
                e.printStackTrace();
            }
            Log.d("Firebase message sent response: ", response);
        }
        else
        {
            Toast.makeText(getActivity(), R.string.invalid_user, Toast.LENGTH_SHORT).show();
        }
    }

}