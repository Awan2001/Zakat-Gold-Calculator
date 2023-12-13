package com.example.zakatforgold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btZakatCalc, btProfile;
    FloatingActionButton fabShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow_gold)));
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.yellow_gold));

        btZakatCalc = findViewById(R.id.btZakatCalc);
        btProfile = findViewById(R.id.btProfile);
        fabShare = findViewById(R.id.fabShare);

        btZakatCalc.setOnClickListener(this);
        btProfile.setOnClickListener(this);
        fabShare.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == btZakatCalc){
            Intent intent = new Intent(this, zakatGoldCalc.class);
            startActivity(intent);
        }
        else if (v == btProfile){
            Intent intent =  new Intent(this, about.class);
            startActivity(intent);
        }
        else if(v == fabShare){
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://github.com/Awan2001/Zakat-Gold-Calculator");
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TITLE,"Github Repository");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }
    }
}