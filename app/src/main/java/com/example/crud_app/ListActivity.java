package com.example.crud_app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private Button btnAjouter, btnModifier, btnSupprimer;
    private ArrayList<String> villes;
    private ArrayAdapter<String> adapter;
    private int positionSelectionnee = -1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);
        btnAjouter = findViewById(R.id.btnAjouter);
        btnModifier = findViewById(R.id.btnModifier);
        btnSupprimer = findViewById(R.id.btnSupprimer);

        villes = new ArrayList<>();
        villes.add("Casablanca");
        villes.add("Rabat");
        villes.add("Marrakech");
        villes.add("Fès");
        villes.add("Tanger");

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_single_choice, villes);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                positionSelectionnee = position;
            }
        });

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ajouterVille();
            }
        });

        btnModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionSelectionnee != -1) {
                    modifierVille();
                } else {
                    Toast.makeText(ListActivity.this, "Sélectionnez une ville",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSupprimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (positionSelectionnee != -1) {
                    supprimerVille();
                } else {
                    Toast.makeText(ListActivity.this, "Sélectionnez une ville",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ajouterVille() {
        final EditText input = new EditText(this);
        input.setHint("Nom de la ville");

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajouter une ville");
        builder.setView(input);

        builder.setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nomVille = input.getText().toString().trim();
                if (!nomVille.isEmpty()) {
                    villes.add(nomVille);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ListActivity.this, "Ville ajoutée avec succès",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListActivity.this, "Veuillez saisir un nom",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void modifierVille() {
        String nomActuel = villes.get(positionSelectionnee);

        final EditText input = new EditText(this);
        input.setText(nomActuel);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Modifier la ville");
        builder.setView(input);

        builder.setPositiveButton("Modifier", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nouveauNom = input.getText().toString().trim();
                if (!nouveauNom.isEmpty()) {
                    villes.set(positionSelectionnee, nouveauNom);
                    adapter.notifyDataSetChanged();
                    Toast.makeText(ListActivity.this, "Ville modifiée avec succès",
                            Toast.LENGTH_SHORT).show();
                    positionSelectionnee = -1;
                } else {
                    Toast.makeText(ListActivity.this, "Veuillez saisir un nom",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void supprimerVille() {
        String nomVille = villes.get(positionSelectionnee);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmer la suppression");
        builder.setMessage("Voulez-vous supprimer \"" + nomVille + "\" ?");

        builder.setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                villes.remove(positionSelectionnee);
                adapter.notifyDataSetChanged();
                Toast.makeText(ListActivity.this, "Ville supprimée avec succès",
                        Toast.LENGTH_SHORT).show();
                positionSelectionnee = -1;
            }
        });

        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}