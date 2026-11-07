
package com.example.recycleview.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class conexion extends SQLiteOpenHelper {

    private static final String BD = "inventario";
    private static final int version = 1;

    public conexion(@Nullable Context context) {
        super(context, BD, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE productos (" +
                "codigo INTEGER PRIMARY KEY, " +
                "nombre TEXT, " +
                "cantidad INTEGER, " +
                "descripcion TEXT, " +
                "categoria TEXT, " +
                "precio REAL, " +
                "stock INTEGER)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS productos");
        onCreate(db);
    }

    public long insertar(producto producto) {

        SQLiteDatabase db = this.getWritableDatabase();

        try {

            ContentValues values = new ContentValues();

            values.put("codigo", producto.getCodigo());
            values.put("nombre", producto.getNombre());
            values.put("cantidad", producto.getCantidad());
            values.put("descripcion", producto.getDescripcion());
            values.put("categoria", producto.getCategoria());
            values.put("precio", producto.getPrecio());
            values.put("stock", producto.getStock());

            long resultado = db.insert("productos", null, values);

            return resultado;

        } finally {
            db.close();
        }
    }
}
