package com.aware.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.aware.Aware;
import com.aware.R;

public class DeMMIMood extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demmi_mood);
        Aware.debug(getApplicationContext(), "mood|open");
    }

    public void moodClick(View view){

        int buttons[] = new int[]{R.id.buttonMoodA, R.id.buttonMoodB, R.id.buttonMoodC, R.id.buttonMoodD, R.id.buttonMoodE};
        for(int id : buttons){
            ImageButton button = findViewById(id);
//            button.setEnabled(false);
            if(id == view.getId()){
                button.setImageResource(R.drawable.ic_check_circle_24dp);
                Aware.debug(getApplicationContext(), "mood|log|" + button.getTag());
                Toast.makeText(this.getApplicationContext(), "Mood logged", Toast.LENGTH_SHORT).show();
            }
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 500);


    }

    public void dismissMoodLog(View i){
        Aware.debug(getApplicationContext(), "mood|log|" + "-1");
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Aware.debug(getApplicationContext(), "mood|close");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Aware.debug(getApplicationContext(), "mood|resume");
    }
}
