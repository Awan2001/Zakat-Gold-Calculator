package com.example.zakatforgold;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class zakatGoldCalc extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button calcZakat, btReset;
    TextView tvOutTotVal, tvOutGoldPay, tvOutTotZakat;
    EditText etWeight, etGoldVal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zakat_gold_calc);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.yellow_gold)));
        getWindow().setStatusBarColor(ContextCompat.getColor(zakatGoldCalc.this,R.color.yellow_gold));

        etWeight = findViewById(R.id.etWeight);
        etGoldVal = findViewById(R.id.etGoldVal);

        radioGroup =findViewById(R.id.radioGroup);
        calcZakat = findViewById(R.id.btCalc);
        calcZakat.setOnClickListener(this);

        btReset = findViewById(R.id.btReset);
        btReset.setOnClickListener(this);


        tvOutTotVal = findViewById(R.id.tvOutTotVal);
        tvOutGoldPay = findViewById(R.id.tvOutGoldPay);
        tvOutTotZakat = findViewById(R.id.tvOutTotZakat);

    }

    @Override
    public void onClick(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);
        String choice = (String) radioButton.getText();

        try {
            double weight = Double.parseDouble(etWeight.getText().toString());
            double goldVal = Double.parseDouble(etGoldVal.getText().toString());
            double totValGold = 0, zPay = 0, totZ = 0;
            if (v.getId() == R.id.btCalc) {
                if (choice.equalsIgnoreCase("keep")){
                    totValGold = weight * goldVal;
                    zPay = (weight - 85) * goldVal;
                    if (zPay <= 0){
                        zPay = 0;
                    }
                    totZ = zPay * 0.025;
                }
                else if (choice.equalsIgnoreCase("wear")){
                    totValGold = weight * goldVal;
                    zPay = (weight - 200) * goldVal;
                    if (zPay <= 0){
                        zPay = 0;
                    }
                    totZ = zPay * 0.025;
                }
                tvOutTotVal.setText("RM "+totValGold);
                tvOutGoldPay.setText("RM "+zPay);
                tvOutTotZakat.setText("RM "+ totZ);
            } else if (v.getId() == R.id.btReset) {
                tvOutTotVal.setText("");
                tvOutGoldPay.setText("");
                tvOutTotZakat.setText("");
                etWeight.setText("");
                etGoldVal.setText("");
            }
        } catch (NumberFormatException e){
            Toast.makeText(zakatGoldCalc.this, "Fill the number properly", Toast.LENGTH_SHORT).show();
        }

    }

}