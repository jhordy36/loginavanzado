package com.example.oma.loginavanzado;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuario {
    Context c;
    usuario u;
    ArrayList<usuario> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table if not exists usuario(id integer primary key autoincrement, nombre text, telefono text, correo text, contraseña text)";

    public daoUsuario(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        u=new usuario();
    }

    public boolean insertarUsuario(usuario u) {
        if(buscar(u.getCorreo())==0){
            ContentValues cv=new ContentValues();
            cv.put("nombre",u.getNombre());
            cv.put("telefono",u.getTelefono());
            cv.put("correo",u.getCorreo());
            cv.put("contraseña",u.getContraseña());
            return (sql.insert("usuario",null,cv)>0);
        }else{
            return false;
        }
    }

    public int buscar(String u){
        int x=0;
        lista=selectUsuarios();
        for (usuario us:lista) {
            if (us.getCorreo().equals(u)){
                x++;
            }
        }
        return x;
    }
    public ArrayList<usuario> selectUsuarios(){
        ArrayList<usuario> lista=new ArrayList<>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFirst()){
            do {
                usuario u=new usuario();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setTelefono(cr.getString(2));
                u.setCorreo(cr.getString(3));
                u.setContraseña(cr.getString(4));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }
    public int login(String u, String p){
        int a=0;
        Cursor cr=sql.rawQuery("select * from usuario",null);
        if(cr!=null&&cr.moveToFirst()){
            do {
                if(cr.getString(3).equals(u)&&cr.getString(4).equals(p)){
                    a++;
                }
            }while (cr.moveToNext());
        }
        return (a);
    }
    public usuario getUsuario(String u,String p){
        lista=selectUsuarios();
        for (usuario us:lista){
            if (us.getCorreo().equals(u)&&us.getContraseña().equals(p)){
                return (us);
            }
        }
        return null;
    }
    public usuario getUsuarioporID(int id){
        lista=selectUsuarios();
        for (usuario us:lista){
            if (us.getId()==id){
                return (us);
            }
        }
        return null;
    }
}
