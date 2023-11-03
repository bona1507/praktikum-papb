package com.example.papb;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ioText extends AppCompatActivity {
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private TextView textViewFullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iotext);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        textViewFullName = findViewById(R.id.textViewFullName);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("firstName", editTextFirstName.getText().toString());
        outState.putString("lastName", editTextLastName.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String firstName = savedInstanceState.getString("firstName");
        String lastName = savedInstanceState.getString("lastName");
        editTextFirstName.setText(firstName);
        editTextLastName.setText(lastName);
        updateFullName();
    }

    public void showFullName(View view) {
        updateFullName();
    }

    private void updateFullName() {
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String fullName = firstName + " " + lastName;
        textViewFullName.setText(fullName);
    }
}
