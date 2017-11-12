package com.example.owner.disastercom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";
    private TextView mTextMessage;
    private BluetoothController mainController = new BluetoothController();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void sendMessage(View view) throws IOException {
        Intent intent = new Intent(this, DisplayActivity.class);
        // Get Message
        EditText editText = (EditText) findViewById(R.id.editText3);
        String message = editText.getText().toString();
        //  Get Receiver
        editText = (EditText) findViewById(R.id.editText5);
        String receiver = editText.getText().toString();

        Bundle extras = new Bundle();
        extras.putString("EXTRA_MESSAGE",message);
        extras.putString("EXTRA_RECEIVER",receiver);
        intent.putExtras(extras);
        startActivity(intent);

        // Send through bluetooth
        //mainController.init();
        mainController.init();
        mainController.write("hello world");
        mainController.run();
    }
}
