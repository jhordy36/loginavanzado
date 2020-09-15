package com.example.oma.loginavanzado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class menu_principal extends AppCompatActivity {
    TextView nombre;
    int id;
    usuario u;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        nombre=findViewById(R.id.textView);
        dao= new daoUsuario(this);

        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        u=dao.getUsuarioporID(id);
        nombre.setText(u.getNombre());

    }
}