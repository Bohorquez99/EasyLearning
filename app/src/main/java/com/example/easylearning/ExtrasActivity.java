package com.example.easylearning;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;

public class ExtrasActivity extends AppCompatActivity {

    private ArFragment arFragment;
    private ModelRenderable modelRenderable;
    private String MODEL_URL="";

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extras);
    }
}
