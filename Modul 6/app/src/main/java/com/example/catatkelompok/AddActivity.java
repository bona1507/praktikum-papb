package com.example.catatkelompok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText editTextNama;
    private EditText editTextProdi;
    private EditText editTextAngkatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        editTextNama = findViewById(R.id.editTextNama);
        editTextProdi = findViewById(R.id.editTextProdi);
        editTextAngkatan = findViewById(R.id.editTextAngkatan);

        Button addButton = findViewById(R.id.buttonAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the user's input from EditText fields
                String nama = editTextNama.getText().toString();
                String prodi = editTextProdi.getText().toString();
                int angkatan = Integer.parseInt(editTextAngkatan.getText().toString());

                // Create a new Mahasiswa object with user input
                Mahasiswa newMahasiswa = new Mahasiswa(nama, prodi, angkatan);

                // Return the new Mahasiswa object to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Mahasiswa", newMahasiswa);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
