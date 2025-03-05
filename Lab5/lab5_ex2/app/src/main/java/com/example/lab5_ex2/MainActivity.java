package com.example.lab5_ex2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button startReadingButton = findViewById(R.id.startReadingButton);
        startReadingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startReadingButton.setVisibility(View.GONE);
                Fragment fragment = Chapter1.newInstance();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


                transaction.replace(R.id.fragment_layout, fragment);
                transaction.commit();
            }
        });
    }
}