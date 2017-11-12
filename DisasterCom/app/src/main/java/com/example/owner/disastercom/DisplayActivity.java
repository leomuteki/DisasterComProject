package com.example.owner.disastercom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        /* Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        */

        Bundle extras = getIntent().getExtras();
        String message = extras.getString("EXTRA_MESSAGE");
        String receiver = extras.getString("EXTRA_RECEIVER");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);
        textView = findViewById(R.id.textView6);
        textView.setText("to: " + receiver);
    }
}
