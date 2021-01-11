package tsturm18.pos.postfixcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tsturm18.pos.postfixcalculator.arithmeticutils.PostFixConverter;
import tsturm18.pos.postfixcalculator.arithmeticutils.PostfixCalculator;

public class MainActivity extends AppCompatActivity {

    TextView calc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calc = findViewById(R.id.calculation);
    }

    public void clearCalc(View view) {
        calc.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void addChar (View view){
        Button button = (Button) view;
        calc.setText(calc.getText().toString() + button.getText().toString());
    }

    @SuppressLint("SetTextI18n")
    public void calc (View view){
        PostFixConverter converter = new PostFixConverter(calc.getText().toString());
        PostfixCalculator calculator = new PostfixCalculator(converter.getPostfixAsList());
        String result = calculator.getResult().toString();
        calc.setText(result);
    }

}