package com.example.vinylvault;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class VinylAdapter extends RecyclerView.Adapter<VinylAdapter.VinylViewHolder>{
    ArrayList<Vinyl> vinylList;
    Context context;
    public VinylAdapter(ArrayList<Vinyl> vinylList, Context context) {
        this.vinylList = vinylList;
        this.context = context;
    }
    @NonNull
    @Override
    public VinylAdapter.VinylViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemvinyl, parent, false);
        return new VinylViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull VinylViewHolder holder, int position) {
        Vinyl vinyl = vinylList.get(position);
        holder.photo.setImageResource(vinyl.getFoto());
        holder.title.setText(vinyl.getTitle());
        holder.artist.setText(vinyl.getArtist());
        holder.genero.setText(vinyl.getGenero());
        holder.released.setText(vinyl.getReleased());

        holder.itemView.setOnClickListener(v -> {
            String mensaje = vinyl.getTitle() + "\n" +
                    "RPM: " + vinyl.getRpm();
            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
        });
        holder.button1.setOnClickListener(v -> {
            String snackbarMessage = context.getString(R.string.toast_message);
            Snackbar.make(v, snackbarMessage, Snackbar.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return vinylList.size();
    }
    // Método para actualizar la lista
    public void updateList(ArrayList<Vinyl> newList) {
        vinylList.clear();
        vinylList.addAll(newList);
        notifyDataSetChanged();
    }
    public static class VinylViewHolder extends RecyclerView.ViewHolder{
        ImageView photo;
        TextView title, artist, released,genero;
        Button button1;

        public VinylViewHolder(@NonNull View itemView) {
            super(itemView);
            photo=itemView.findViewById(R.id.photo1);
            title=itemView.findViewById(R.id.title1);
            artist=itemView.findViewById(R.id.artist1);
            released=itemView.findViewById(R.id.released1);
            genero=itemView.findViewById(R.id.genero1);
            button1 = itemView.findViewById(R.id.button2);
        }
    }
}
