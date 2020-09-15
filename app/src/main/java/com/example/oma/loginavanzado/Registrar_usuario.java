package com.example.oma.loginavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.AlignmentSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar_usuario extends AppCompatActivity {
    EditText nombre,telefono,correo,contraseña;
    Button btn_ir_inicio_sesion;
    Button btn_crearcuenta;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_usuario);

        dao=new daoUsuario(this);
        nombre=findViewById(R.id.regi_nombre);
        telefono=findViewById(R.id.regi_telefono);
        correo=findViewById(R.id.regi_correo);
        contraseña=findViewById(R.id.regi_contraseña);

        btn_crearcuenta=findViewById(R.id.crear_cuenta);
        btn_ir_inicio_sesion=findViewById(R.id.ir_inicio_sesion);

        btn_ir_inicio_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registrar_usuario.this,MainActivity.class));
                finish();
            }
        });

        btn_crearcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario u=new usuario();
                u.setNombre(nombre.getText().toString());
                u.setTelefono(telefono.getText().toString());
                u.setCorreo(correo.getText().toString());
                u.setContraseña(contraseña.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(Registrar_usuario.this, "Por favor, llenar todos los campos", Toast.LENGTH_SHORT).show();
                }else if (dao.insertarUsuario(u)){
                    Toast.makeText(Registrar_usuario.this, "Registro exitoso", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Registrar_usuario.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(Registrar_usuario.this, "El correo ya ha sido registrado, utilice otro", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}