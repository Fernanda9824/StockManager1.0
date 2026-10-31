
package com.example.recycleview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView lista;
    List<String> nombre;
    List<String> telefonos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.enableEdgeToEdge(getWindow());

        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);

        nombre = new ArrayList<>();
        nombre.add("Sebastián");
        nombre.add("Regina");
        nombre.add("Carlos");
        nombre.add("Angela");

        telefonos = new ArrayList<>();
        telefonos.add("4771234567");
        telefonos.add("4799874561");
        telefonos.add("4773216549");
        telefonos.add("4797894561");

        int[] imagenes = {
                R.drawable.a3,
                R.drawable.a2,
                R.drawable.a1,
                R.drawable.a4
        };

        Adaptador adaptador = new Adaptador(
                this,
                nombre,
                telefonos,
                imagenes
        );

        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setAdapter(adaptador);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );
    }
}
