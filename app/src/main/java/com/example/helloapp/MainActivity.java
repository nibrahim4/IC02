package com.example.helloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private TextView shapeText;
    private TextView resultText;
    private Button calculate_button_lbl;
    private Button clear_button;
    private ImageView triangle_img;
    private ImageView circle_img;
    private ImageView square_img;
    private EditText length1_input;
    private EditText length2_input;
    private String selectedShape;
    private double length1 = 0.0;
    private double length2 = 0.0;
    private double pi = 3.1416;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Area Calculator");

        shapeText = findViewById(R.id.shape_Text);
        resultText = findViewById(R.id.result_Text);
        calculate_button_lbl = findViewById(R.id.calculate_Btn);
        clear_button = findViewById(R.id.clear_btn);
        triangle_img = findViewById(R.id.triangle_Img);
        circle_img = findViewById(R.id.circle_img);
        square_img = findViewById(R.id.square_img);
        length1_input = (EditText) findViewById(R.id.length1_Input);
        length2_input = (EditText) findViewById(R.id.length2_Input);

        shapeText.setText("Select a shape");
        resultText.setText("");

        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearButton();

            }
        });

        triangle_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "triange";
                shapeText.setText("Triangle");
                length1_input.setVisibility(View.VISIBLE);
                length2_input.setVisibility(View.VISIBLE);
            }
        });

        circle_img.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "circle";
                shapeText.setText("Circle");
                length1_input.setVisibility(View.VISIBLE);
                length2_input.setVisibility(View.INVISIBLE);
            }
        }));

        square_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedShape = "square";
                shapeText.setText("Square");
                length1_input.setVisibility(View.VISIBLE);
                length2_input.setVisibility(View.INVISIBLE);
            }
        });

        calculate_button_lbl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempLength1 = length1_input.getText().toString();
                String tempLength2 = length2_input.getText().toString();

                if(tempLength1 != null && !tempLength1.equals("")){
                    length1 = Double.parseDouble(tempLength1);
                }

                if(tempLength2 != null && !tempLength2.equals("")){
                    length2 = Double.parseDouble(tempLength2);
                }

                if(length1_input.getText().toString().equals("")){
                    length1_input.setError("Please input a valid number");
                }
                if(length2_input.getText().toString().equals("")){
                    length2_input.setError("Please input a valid number");
                }
                switch(selectedShape){
                    case "triange":
                        double triangeResult = (length1*length2)/2;
                        resultText.setText(triangeResult+"");
                        break;
                    case "circle":
                        double circleResult = pi * length1 * length1;
                        resultText.setText(circleResult+ "");
                        break;
                    case "square":
                        double squareResult = length1 * length1;
                        resultText.setText(squareResult +"");
                        break;
                }
            }
        });
    }



    public void clearButton(){
        length1_input.setText("");
        length2_input.setText("");
        shapeText.setText("");
        selectedShape = "none";
        resultText.setText("Select a shape");

        length1_input.setVisibility(View.VISIBLE);
        length2_input.setVisibility(View.VISIBLE);
    }
}
