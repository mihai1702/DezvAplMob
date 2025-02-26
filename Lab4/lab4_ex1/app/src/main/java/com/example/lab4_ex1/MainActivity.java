package com.example.lab4_ex1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public float getFirstNum(EditText firstNum){
        String firstNumString=firstNum.getText().toString();
        return (float) Integer.parseInt(firstNumString);
    }
    public float getSecondNum(EditText SecondNum){
        String SecondNumString=SecondNum.getText().toString();
        return (float) Integer.parseInt(SecondNumString);
    }
    public float Sum(float firstNum, float secondNum){
        return firstNum+secondNum;
    }
    public float Sub(float firstNum, float secondNum){
        return firstNum-secondNum;
    }
    public float Div(float firstNum, float secondNum){
        return firstNum/secondNum;
    }
    public float Mul(float firstNum, float secondNum){
        return firstNum*secondNum;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText firstNumberText=findViewById(R.id.firstNumberText);
        EditText secondNumberText=findViewById(R.id.secondNumberText);
        Button SumButton=findViewById(R.id.sumButton);
        Button SubButton=findViewById(R.id.SubButton);
        Button DivButton=findViewById(R.id.DivButton);
        Button MulButton=findViewById(R.id.MulButton);
        TextView ResultView=findViewById(R.id.ResultView);
        SumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float result=Sum(getFirstNum(firstNumberText), getSecondNum(secondNumberText));
                ResultView.setText(String.valueOf(result));
            }
        });
        SubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float result=Sub(getFirstNum(firstNumberText), getSecondNum(secondNumberText));
                ResultView.setText(String.valueOf(result));
            }
        });
        DivButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float result = Div(getFirstNum(firstNumberText), getSecondNum(secondNumberText));
                ResultView.setText(String.valueOf(result));
            }
        });
        MulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float result = Mul(getFirstNum(firstNumberText), getSecondNum(secondNumberText));
                ResultView.setText(String.valueOf(result));
            }
        });
    }
}