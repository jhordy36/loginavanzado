package com.example.oma.loginavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.Button;

public class Registrar_usuario extends AppCompatActivity {
    Button btn_ir_inicio_sesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        btn_ir_inicio_sesion=findViewById(R.id.ir_inicio_sesion);
        btn_ir_inicio_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registrar_usuario.this,MainActivity.class));
                finish();
            }
        });
    }
}