package com.example.k_popprofile.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.k_popprofile.MainActivity;
import com.example.k_popprofile.R;


public class CallFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_call, container, false);
    }

    EditText et_call;
    Button btn_call;
    String number_call;
    private static final int REQUEST_CALL = 1;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        et_call = view.findViewById(R.id.et_call);
        btn_call = view.findViewById(R.id.btn_call);


        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode ==  REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            } else{
                Toast.makeText(getContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void makePhoneCall(){
        number_call = et_call.getText().toString();

//                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(number_call));
        if(number_call.length() > 4){

            if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            }
            else{
                number_call = "tel:"+number_call;
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(number_call));
                startActivity(callIntent);
            }
        }
        else{
            Toast.makeText(getContext(), "Field minimal 4 angka", Toast.LENGTH_SHORT).show();
        }
    }
}