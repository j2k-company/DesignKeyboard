package com.j2k.designkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity
        implements SeekBar.OnSeekBarChangeListener {
    private KeyboardPreferences keyboardPreferences;
    private TextView mViewWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        keyboardPreferences = new KeyboardPreferences(getBaseContext());

        final SeekBar seekBarWidth = (SeekBar) findViewById(R.id.seekBarWidth);
        seekBarWidth.setOnSeekBarChangeListener(this);

        mViewWidth = (TextView) findViewById(R.id.viewWidth);
        mViewWidth.setText("0");
    }

    public void openMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        mViewWidth.setText(String.valueOf(seekBar.getProgress()));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mViewWidth.setText(String.valueOf(seekBar.getProgress()));
        int newWidth = seekBar.getProgress();
        if (newWidth > 0) {
            keyboardPreferences.setKeyWidth(newWidth);
        }
    }
}
