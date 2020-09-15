package com.example.oma.loginavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_ir_crear_cuenta;
    Button btn_iniciar_sesion;
    EditText etcorreo,etcontraseña;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etcorreo=findViewById(R.id.et_correo);
        etcontraseña=findViewById(R.id.et_contraseña);

        dao= new daoUsuario(this);

        btn_ir_crear_cuenta=findViewById(R.id.ir_crear_cuenta);
        btn_ir_crear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Registrar_usuario.class));
                finish();
            }
        });

        btn_iniciar_sesion=findViewById(R.id.iniciar_sesion);
        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u=etcorreo.getText().toString();
                String p=etcontraseña.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(MainActivity.this,"ERROR: campos vacios!!!",Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1){
                    usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(MainActivity.this,"Datos ingresados correctos",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(MainActivity.this,menu_principal.class);
                    i.putExtra("id",ux.getId());
                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this,"Usuario y/o contraseña incorrectos",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}