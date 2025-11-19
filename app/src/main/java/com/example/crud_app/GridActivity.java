package com.example.crud_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private ArrayList<String> villes;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridView);

        villes = new ArrayList<>();
        villes.add("Casablanca");
        villes.add("Rabat");
        villes.add("Marrakech");
        villes.add("Fès");
        villes.add("Tanger");
        villes.add("Agadir");
        villes.add("Meknès");
        villes.add("Oujda");

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, villes);
        gridView.setAdapter(adapter);
    }
}