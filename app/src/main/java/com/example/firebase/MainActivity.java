package com.example.firebase;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference HumedadRef = 	database.getReference("Sensores/Humedad");
        DatabaseReference PresionRef = database.getReference("Sensores/Presion");
        DatabaseReference VelocidadRef = 	database.getReference("Sensores/Movimiento");
        DatabaseReference TemperauraRef = 	database.getReference("Sensores/Temperatura");

        HumedadRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView Humedad = findViewById(R.id.valor_Humedad);
                Humedad.setText(snapshot.getValue(Float.class).toString() + "%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        PresionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView Presion = findViewById(R.id.valor_Presion);
                Presion.setText(snapshot.getValue(Float.class).toString() + "psi");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        VelocidadRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView Velocidad = findViewById(R.id.valor_Velocidad);
                Velocidad.setText(snapshot.getValue(Float.class).toString() + "km/s");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        TemperauraRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                TextView Temperatura = findViewById(R.id.valor_Temperatura);
                Temperatura.setText(snapshot.getValue(Float.class).toString() + "ºF");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}