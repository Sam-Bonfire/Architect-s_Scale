package com.houseofivy.architectsscale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText scale, ratio, input, output;
    private static float inputValue, scaleValue, outputValue, ratioValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scale = findViewById(R.id.et_scale);
        ratio = findViewById(R.id.et_ratio);
        input = findViewById(R.id.et_input);
        output = findViewById(R.id.et_output);
        init();
    }

    private void init() {
        inputValue = Float.parseFloat(input.getText().toString());
        ratioValue = Float.parseFloat(ratio.getText().toString());
        outputValue = Float.parseFloat(output.getText().toString());
        scaleValue = Float.parseFloat(scale.getText().toString());
    }

    private float calc(boolean isInput) {
        if (isInput) {
            return (scaleValue * outputValue) / ratioValue;
        } else {
            return (inputValue * ratioValue) / scaleValue;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.et_scale:
                scaleValue = Float.parseFloat(scale.getText().toString());
                outputValue = calc(false);
                output.setText(String.valueOf(outputValue));
                break;

            case R.id.et_ratio:
                ratioValue = Float.parseFloat(ratio.getText().toString());
                outputValue = calc(false);
                output.setText(String.valueOf(outputValue));
                break;

            case R.id.et_input:
                inputValue = Float.parseFloat(input.getText().toString());
                outputValue = calc(false);
                output.setText(String.valueOf(outputValue));
                break;

            case R.id.et_output:
                outputValue = Float.parseFloat(output.getText().toString());
                inputValue = calc(true);
                input.setText(String.valueOf(inputValue));
                break;

        }
    }
}
