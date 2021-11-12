package com.example.easylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class AjustesActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout general_layout, sensi_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        general_layout = findViewById(R.id.general_layout);
        sensi_layout = findViewById(R.id.sensi_layout);

        findViewById(R.id.btn_general).setOnClickListener(this);
        findViewById(R.id.btn_sensibilidad).setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_general:
                if(general_layout.getVisibility() == view.GONE){
                    general_layout.setVisibility(View.VISIBLE);
                    sensi_layout.setVisibility(View.GONE);
                }else{
                    general_layout.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_sensibilidad:
                if(sensi_layout.getVisibility()== view.GONE){
                    sensi_layout.setVisibility(View.VISIBLE);
                    general_layout.setVisibility(View.GONE);
                }else{
                    sensi_layout.setVisibility(View.GONE);
                }
                break;
        }


    }


    public void onWindowFocusChanged (boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }



    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}