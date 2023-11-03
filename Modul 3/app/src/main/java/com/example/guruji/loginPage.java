package com.example.guruji;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class loginPage extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login_page);


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
    }
}
