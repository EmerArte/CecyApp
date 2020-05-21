package com.example.cecyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.cecyapp.layout.FormularioRegistro;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView tvRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRegistro =(TextView) findViewById(R.id.tv_registro);
        tvRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FormularioRegistro.class));
            }
        });
    }
}
