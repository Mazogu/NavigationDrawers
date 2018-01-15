package com.example.micha.navigationactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.Format;

public class NumberActivity extends MainActivity{

    private TextView number;
    private TextView power;
    private TextView answer;
    private SeekBar numberBar;
    private SeekBar powerBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewGroup view = (ViewGroup) findViewById(R.id.content);
        getLayoutInflater().inflate(R.layout.activity_number,view);
        
        number = findViewById(R.id.number);
        power = findViewById(R.id.power);
        answer = findViewById(R.id.answer);
        numberBar = findViewById(R.id.numberBar);
        powerBar = findViewById(R.id.powerBar);

        numberBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                number.setText(Integer.toString(numberBar.getProgress()));
                calcuatePower();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        powerBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                power.setText(Integer.toString(powerBar.getProgress()));
                calcuatePower();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void calcuatePower() {
        int num = numberBar.getProgress();
        int power = powerBar.getProgress();
        Format formatter = new DecimalFormat("#,####");
        double exponent = Math.pow(num,power);
        String text = formatter.format(exponent);
        answer.setText(text);
    }
}
