package com.example.catatkelompok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    private EditText editTextNama;
    private EditText editTextProdi;
    private EditText editTextAngkatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        editTextNama = findViewById(R.id.editTextNama);
        editTextProdi = findViewById(R.id.editTextProdi);
        editTextAngkatan = findViewById(R.id.editTextAngkatan);

        // Retrieve the Mahasiswa object passed from MainActivity
        Mahasiswa mahasiswa = getIntent().getParcelableExtra("Mahasiswa");

        // Populate the EditText fields with the data of the selected Mahasiswa
        editTextNama.setText(mahasiswa.getNama());
        editTextProdi.setText(mahasiswa.getProdi());
        editTextAngkatan.setText(String.valueOf(mahasiswa.getAngkatan()));

        Button saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the updated user input from EditText fields
                String updatedNama = editTextNama.getText().toString();
                String updatedProdi = editTextProdi.getText().toString();
                int updatedAngkatan = Integer.parseInt(editTextAngkatan.getText().toString());

                // Create an updated Mahasiswa object
                Mahasiswa updatedMahasiswa = new Mahasiswa(updatedNama, updatedProdi, updatedAngkatan);

                // Return the updated Mahasiswa object to MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("Mahasiswa", updatedMahasiswa);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
