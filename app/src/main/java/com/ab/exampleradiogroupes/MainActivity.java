package com.ab.exampleradiogroupes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ab.radiogroupes.RadioGroupErrorSupport;

public class MainActivity extends AppCompatActivity {

    String errorText = "This is a very very very very very very very very very very very very long Error Text";
    RadioGroupErrorSupport radioGroupErrorSupport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroupErrorSupport = findViewById(R.id.radioGroup);
        // customize error
        radioGroupErrorSupport.setErrorTextColor(Color.RED);
        radioGroupErrorSupport.setErrorTextSize(12);
        radioGroupErrorSupport.setError(errorText);
    }

    public void toggle(View v){
        // radioGroupErrorSupport.setError(null) will remove the error
        radioGroupErrorSupport.setError( radioGroupErrorSupport.getErrorText() == null ? errorText : null);
    }
}
