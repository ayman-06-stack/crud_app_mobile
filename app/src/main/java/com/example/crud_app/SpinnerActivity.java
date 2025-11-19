package com.example.crud_app;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView textView;
    private TextView descriptionView;
    private ImageView imageView;
    private ArrayList<String> villes;
    private ArrayAdapter<String> adapter;
    private HashMap<String, Integer> villeImages;
    private HashMap<String, String> villeDescriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);
        descriptionView = findViewById(R.id.descriptionView);
        imageView = findViewById(R.id.imageView);

        villes = new ArrayList<>();
        villes.add("Sélectionnez une ville");
        villes.add("Casablanca");
        villes.add("Rabat");
        villes.add("Marrakech");
        villes.add("Fès");
        villes.add("Tanger");


        villeImages = new HashMap<>();
        villeImages.put("Casablanca", R.drawable.casablanca);
        villeImages.put("Rabat", R.drawable.rabat);
        villeImages.put("Marrakech", R.drawable.marrakech);
        villeImages.put("Fès", R.drawable.fes);
        villeImages.put("Tanger", R.drawable.tanger);


        villeDescriptions = new HashMap<>();
        villeDescriptions.put("Casablanca", "La plus grande ville du Maroc, centre économique et capitale commerciale du pays. Célèbre pour sa mosquée Hassan II.");
        villeDescriptions.put("Rabat", "Capitale administrative du Maroc, située sur la côte atlantique. Connue pour ses monuments historiques et sa médina.");
        villeDescriptions.put("Marrakech", "La ville rouge, célèbre pour sa place Jemaa el-Fna, ses souks colorés et ses magnifiques jardins.");
        villeDescriptions.put("Fès", "Capitale spirituelle et culturelle, abritant la plus ancienne université du monde et une médina classée au patrimoine mondial.");
        villeDescriptions.put("Tanger", "Ville portuaire du nord, porte de l'Afrique, connue pour son mélange culturel et sa vue sur le détroit de Gibraltar.");

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, villes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0) {
                    String villeSelectionnee = villes.get(position);


                    textView.setText(villeSelectionnee);


                    if (villeImages.containsKey(villeSelectionnee)) {
                        imageView.setImageResource(villeImages.get(villeSelectionnee));
                        imageView.setVisibility(View.VISIBLE);
                    }


                    if (villeDescriptions.containsKey(villeSelectionnee)) {
                        descriptionView.setText(villeDescriptions.get(villeSelectionnee));
                        descriptionView.setVisibility(View.VISIBLE);
                    }
                } else {

                    textView.setText("");
                    imageView.setVisibility(View.GONE);
                    descriptionView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                textView.setText("");
                imageView.setVisibility(View.GONE);
                descriptionView.setVisibility(View.GONE);
            }
        });
    }
}