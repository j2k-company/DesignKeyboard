package com.j2k.designkeyboard;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Я не ленивый!
        KeyboardPreferences uwu = new KeyboardPreferences(getBaseContext());
        // int keyWidth = uwu.getKeyWidth();
        // uwu.setKeyWidth(keyWidth);
    }
    public void openSetup(View view) {
        startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS));
    }
    public void openSettings(View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
