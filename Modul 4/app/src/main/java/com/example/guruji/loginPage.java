package com.example.guruji;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class loginPage extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_page);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.loginButton);

        TextView registerTextView = findViewById(R.id.register);
        TextView tcTextView = findViewById(R.id.tc);

        SpannableString span1 = new SpannableString(registerTextView.getText());
        SpannableString span2 = new SpannableString(tcTextView.getText());

        ForegroundColorSpan yellowColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.yellow));
        UnderlineSpan underlineSpan = new UnderlineSpan();

        span1.setSpan(yellowColorSpan, 23, span1.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(yellowColorSpan, 38, span2.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        span1.setSpan(underlineSpan, 23, span1.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);
        span2.setSpan(underlineSpan, 38, span2.length(), SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

        registerTextView.setText(span1);
        tcTextView.setText(span2);

        // Set an OnClickListener for the LOGIN button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the text from the email and password EditText
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                // Check if email and password match the criteria
                if (email.equals("bonaventura@gmail.com") && password.equals("215150401111051")) {
                    // Login is successful, show a success Toast
                    Toast.makeText(loginPage.this, "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    // Login failed, show a failure Toast
                    Toast.makeText(loginPage.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
