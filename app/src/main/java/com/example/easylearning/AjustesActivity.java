package com.example.easylearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class AjustesActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout general_layout, sensi_layout, control_layout, sonido_layout;
    private SeekBar sensi_general, sensi_x, sensi_y;
    private TextView txtCargarGene, txtCargarX, txtCargarY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        //Sensibilidad EJE Y
        txtCargarY = findViewById(R.id.txtCargarY);
        sensi_y = findViewById(R.id.sensi_y);
        sensi_y.setProgress(0);
        sensi_y.setMax(100);
        sensi_y.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtCargarY.setText(String.valueOf(progress) + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //Sensibilidad EJE X
        txtCargarX = findViewById(R.id.txtCargarX);
        sensi_x = findViewById(R.id.sensi_x);
        sensi_x.setProgress(0);
        sensi_x.setMax(100);
        sensi_x.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtCargarX.setText(String.valueOf(progress) + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        //Sensibilidad GENERAL
        txtCargarGene = findViewById(R.id.txtCargarGene);
        sensi_general = findViewById(R.id.sensi_general);
        sensi_general.setProgress(0);
        sensi_general.setMax(100);
        sensi_general.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        txtCargarGene.setText(String.valueOf(progress) + " %");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });

        sonido_layout = findViewById(R.id.sonido_layout);
        control_layout = findViewById(R.id.control_layout);
        general_layout = findViewById(R.id.general_layout);
        sensi_layout = findViewById(R.id.sensi_layout);

        findViewById(R.id.btn_sonidos).setOnClickListener(this);
        findViewById(R.id.btn_controles).setOnClickListener(this);
        findViewById(R.id.btn_general).setOnClickListener(this);
        findViewById(R.id.btn_sensibilidad).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_general:
                if (general_layout.getVisibility() == view.GONE) {
                    general_layout.setVisibility(View.VISIBLE);
                    sensi_layout.setVisibility(View.GONE);
                    control_layout.setVisibility(View.GONE);
                    sonido_layout.setVisibility(View.GONE);
                } else {
                    general_layout.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_sensibilidad:
                if (sensi_layout.getVisibility() == view.GONE) {
                    sensi_layout.setVisibility(View.VISIBLE);
                    general_layout.setVisibility(View.GONE);
                    control_layout.setVisibility(View.GONE);
                    sonido_layout.setVisibility(View.GONE);
                } else {
                    sensi_layout.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_controles:
                if (control_layout.getVisibility() == view.GONE) {
                    control_layout.setVisibility(View.VISIBLE);
                    general_layout.setVisibility(View.GONE);
                    sensi_layout.setVisibility(View.GONE);
                    sonido_layout.setVisibility(View.GONE);
                } else {
                    control_layout.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_sonidos:
                if (sonido_layout.getVisibility() == view.GONE) {
                    sonido_layout.setVisibility(View.VISIBLE);
                    general_layout.setVisibility(View.GONE);
                    sensi_layout.setVisibility(View.GONE);
                    control_layout.setVisibility(View.GONE);
                } else {
                    sonido_layout.setVisibility(View.GONE);
                }
                break;
        }


    }


    public void onWindowFocusChanged(boolean hasFocus) {
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