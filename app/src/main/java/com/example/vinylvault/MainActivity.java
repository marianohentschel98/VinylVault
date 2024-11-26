package com.example.vinylvault;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Vinyl> listaVinyl;
    private VinylAdapter vinylAdapter;

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

        listaVinyl = new ArrayList<>();
        cargarVinyls(); // Método para cargar los vinilos en la lista

        RecyclerView vinylList = findViewById(R.id.vinylList);
        vinylList.setLayoutManager(new LinearLayoutManager(this));
        vinylAdapter = new VinylAdapter(new ArrayList<>(listaVinyl), this);
        vinylList.setAdapter(vinylAdapter);

        // Switches
        Switch switchPop = findViewById(R.id.switch1);
        Switch switchRock = findViewById(R.id.switch2);
        Switch switchDisco = findViewById(R.id.switch3);
        Switch switchHipHop = findViewById(R.id.switch4);

        CompoundButton.OnCheckedChangeListener listener = (buttonView, isChecked) -> filtrarVinilos(
                switchPop.isChecked(),
                switchRock.isChecked(),
                switchDisco.isChecked(),
                switchHipHop.isChecked()
        );

        switchPop.setOnCheckedChangeListener(listener);
        switchRock.setOnCheckedChangeListener(listener);
        switchDisco.setOnCheckedChangeListener(listener);
        switchHipHop.setOnCheckedChangeListener(listener);
    }

    private void cargarVinyls() {
        try{
        listaVinyl.add(new Vinyl(R.drawable.oceans_of_fantasy, "Oceans of Fantasy", "Boney M", "33", "1979", "Disco"));
        listaVinyl.add(new Vinyl(R.drawable.el_hombre_hace_planes, "El Hombre Hace Planes Dios Se Ríe", "Dano", "33", "2023", "Hip Hop"));
        listaVinyl.add(new Vinyl(R.drawable.thriller, "Thriller", "Michael Jackson", "33", "1982", "Pop"));
        listaVinyl.add(new Vinyl(R.drawable.the_colour_and_the_shape, "The Colour and the Shape", "Foo Fighters", "33", "1997", "Rock"));
        listaVinyl.add(new Vinyl(R.drawable.i_am, "I Am", "Earth, Wind & Fire", "33", "1979", "Disco"));
        listaVinyl.add(new Vinyl(R.drawable.cruisin, "Cruisin'", "Village People", "33", "1978", "Disco"));
        listaVinyl.add(new Vinyl(R.drawable.dark_side_of_the_moon, "The Dark Side of the Moon", "Pink Floyd", "33", "1973", "Rock"));
        listaVinyl.add(new Vinyl(R.drawable.so_much_fun, "So Much Fun", "Young Thug", "33", "2019", "Hip Hop"));
        listaVinyl.add(new Vinyl(R.drawable.stadium_arcadium, "Stadium Arcadium", "Red Hot Chili Peppers", "33", "2006", "Rock"));
        listaVinyl.add(new Vinyl(R.drawable.am, "AM", "Arctic Monkeys", "33", "2013", "Rock"));
        listaVinyl.add(new Vinyl(R.drawable.notorious, "Ready to Die", "The Notorious B.I.G.", "33", "1994", "Hip Hop"));
            Log.d("MainActivity", "Lista de vinilos cargada con éxito");
        } catch (Exception e) {
            Log.e("MainActivity", "Error al cargar la lista de vinilos");
        }
    }
    private void filtrarVinilos(boolean pop, boolean rock, boolean disco, boolean hipHop) {
        ArrayList<Vinyl> listaFiltrada = new ArrayList<>();

        if (!pop && !rock && !disco && !hipHop) {
            // Si no hay switches activos, mostrar todos
            listaFiltrada.addAll(listaVinyl);
        } else {
            // Filtrar según switches activos
            for (Vinyl vinyl : listaVinyl) {
                if ((pop && vinyl.getGenero().equalsIgnoreCase("Pop")) ||
                        (rock && vinyl.getGenero().equalsIgnoreCase("Rock")) ||
                        (disco && vinyl.getGenero().equalsIgnoreCase("Disco")) ||
                        (hipHop && vinyl.getGenero().equalsIgnoreCase("Hip Hop"))) {
                    listaFiltrada.add(vinyl);
                }
            }
        }

        // Actualizar el RecyclerView
        vinylAdapter.updateList(listaFiltrada);
    }
}