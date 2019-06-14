package com.aware.ui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aware.Aware;
import com.aware.R;

public class DeMMIEpisode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demmi_episode);
        Aware.debug(getApplicationContext(), "episode|open");
    }

    public void logEpisode(View i) {
        Button logEpisodeButton = findViewById(R.id.episode);
        logEpisodeButton.setEnabled(false);
        logEpisodeButton.setBackground(getResources().getDrawable(R.drawable.ic_brightness_1_pink_24dp));
        logEpisodeButton.setText(getResources().getString(R.string.log_episode_clicked));

        Toast.makeText(this.getApplicationContext(), "Episode logged", Toast.LENGTH_SHORT).show();
        EditText detailsText = findViewById(R.id.episodeDetails);
        String details = detailsText.getText().toString();
        Aware.debug(getApplicationContext(), "episode|log|" + details);

        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Aware.debug(getApplicationContext(), "episode|close");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Aware.debug(getApplicationContext(), "episode|resume");
    }
}
