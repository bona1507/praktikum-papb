package com.example.catatkelompok;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Mahasiswa> daftarMahasiswa;
    private Adapter adapter;
    private static final int ADD_EDIT_REQUEST_CODE = 1;
    private int editedPosition = -1;
    private Button tambahButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Initialize daftarMahasiswa with your data
        daftarMahasiswa = new ArrayList<>();

        // Create and set up your Mahasiswa objects
        Mahasiswa mahasiswa1 = new Mahasiswa("Bonaventura", "Sistem Informasi", 2021);
        Mahasiswa mahasiswa2 = new Mahasiswa("Bonaventura", "Sistem Informasi", 2021);
        Mahasiswa mahasiswa3 = new Mahasiswa("Bonaventura", "Sistem Informasi", 2021);
        Mahasiswa mahasiswa4 = new Mahasiswa("Bonaventura", "Sistem Informasi", 2021);
        Mahasiswa mahasiswa5 = new Mahasiswa("Bonaventura", "Sistem Informasi", 2021);
        Mahasiswa mahasiswa6 = new Mahasiswa("Bonaventura", "Sistem Informasi", 2021);
        Mahasiswa mahasiswa7 = new Mahasiswa("Bonaventura", "Sistem Informasi", 2021);
        Mahasiswa mahasiswa8 = new Mahasiswa("Bonaventura", "Sistem Informasi", 2021);

        // Add Mahasiswa objects to the list
        daftarMahasiswa.add(mahasiswa1);
        daftarMahasiswa.add(mahasiswa2);
        daftarMahasiswa.add(mahasiswa3);
        daftarMahasiswa.add(mahasiswa4);
        daftarMahasiswa.add(mahasiswa5);
        daftarMahasiswa.add(mahasiswa6);
        daftarMahasiswa.add(mahasiswa7);
        daftarMahasiswa.add(mahasiswa8);

        // Initialize the adapter
        adapter = new Adapter(daftarMahasiswa);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Handle item clicks (edit and delete)
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {
                // Handle edit button click
                // You can open an editing activity for this item
                editedPosition = position;
                openEditActivity(daftarMahasiswa.get(position));
            }

            @Override
            public void onDeleteClick(int position) {
                // Handle delete button click
                // Remove the item from the list and update the RecyclerView
                daftarMahasiswa.remove(position);
                adapter.notifyItemRemoved(position);
            }
        });

        tambahButton = findViewById(R.id.buttonTambah);
        tambahButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the activity for adding new data
                openAddActivity();
            }
        });
    }

    private void openEditActivity(Mahasiswa mahasiswa) {
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("Mahasiswa", mahasiswa);
        startActivityForResult(intent, ADD_EDIT_REQUEST_CODE);
    }

    private void openAddActivity() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, ADD_EDIT_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_EDIT_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                Mahasiswa editedMahasiswa = data.getParcelableExtra("Mahasiswa");

                if (editedPosition != -1) {
                    // Editing an existing item
                    daftarMahasiswa.set(editedPosition, editedMahasiswa);
                    adapter.notifyItemChanged(editedPosition);
                    editedPosition = -1; // Reset the edited position
                } else {
                    // Adding a new item
                    daftarMahasiswa.add(editedMahasiswa);
                    adapter.notifyItemInserted(daftarMahasiswa.size() - 1);
                }
            }
        }
    }
}
