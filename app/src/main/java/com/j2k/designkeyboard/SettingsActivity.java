package com.j2k.designkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {
    private final KeyboardPreferences keyboardPreferences =
            new KeyboardPreferences(getBaseContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }
    public void changeKeyWidth(View view) {
        EditText editText = (EditText) findViewById(R.id.input_width);
        String message = editText.getText().toString();
        int newWidth = Integer.parseInt(message);
        if (newWidth > 0) {
            keyboardPreferences.setKeyWidth(newWidth);
        }
    }
    public void openMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}