package com.example.catatkelompok;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MahasiswaViewHolder> {

    private List<Mahasiswa> daftarMahasiswa;

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Adapter(List<Mahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.mahasiswa, parent, false);
        return new MahasiswaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Mahasiswa mahasiswa = daftarMahasiswa.get(position);

        holder.textViewNama.setText("Nama: " + mahasiswa.getNama());
        holder.textViewProdi.setText("Program Studi: " + mahasiswa.getProdi());
        holder.textViewAngkatan.setText("Angkatan: " + mahasiswa.getAngkatan());

        holder.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onEditClick(position);
                }
            }
        });

        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onDeleteClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return daftarMahasiswa.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewNama;
        public TextView textViewProdi;
        public TextView textViewAngkatan;
        public Button buttonEdit;
        public Button buttonDelete;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            textViewNama = itemView.findViewById(R.id.textViewNama);
            textViewProdi = itemView.findViewById(R.id.textViewProdi);
            textViewAngkatan = itemView.findViewById(R.id.textViewAngkatan);
            buttonEdit = itemView.findViewById(R.id.buttonEdit);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
