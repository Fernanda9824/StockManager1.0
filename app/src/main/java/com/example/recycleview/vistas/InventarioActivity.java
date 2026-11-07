
package com.example.recycleview.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recycleview.R;
import com.example.recycleview.modelo.conexion;
import com.example.recycleview.modelo.producto;

public class InventarioActivity extends AppCompatActivity {

    EditText txtCodigo, txtNombre, txtCantidad, txtDescripcion, txtCategoria, txtPrecio, txtStockMinimo;
    Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        txtCodigo = findViewById(R.id.txtCodigo);
        txtNombre = findViewById(R.id.txtNombre);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtCategoria = findViewById(R.id.txtCategoria);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtStockMinimo = findViewById(R.id.txtStockMinimo);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conexion conexion = new conexion(InventarioActivity.this);
                producto producto = new producto();

                producto.setCodigo(Integer.parseInt(txtCodigo.getText().toString().trim()));
                producto.setNombre(txtNombre.getText().toString().trim());
                producto.setCantidad(Integer.parseInt(txtCantidad.getText().toString().trim()));
                producto.setDescripcion(txtDescripcion.getText().toString().trim());
                producto.setCategoria(txtCategoria.getText().toString().trim());
                producto.setPrecio(Double.parseDouble(txtPrecio.getText().toString().trim()));
                producto.setStock(Integer.parseInt(txtStockMinimo.getText().toString().trim()));

                conexion.insertar(producto);

                Intent intent = new Intent(InventarioActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
