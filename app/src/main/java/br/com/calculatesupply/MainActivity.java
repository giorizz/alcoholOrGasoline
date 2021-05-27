package br.com.calculatesupply;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText valueAlc, valueGas;
    private Button btnCalc;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueAlc = findViewById(R.id.value_alc);
        valueGas = findViewById(R.id.value_gas);
        textResult = findViewById(R.id.text_result);
        btnCalc = findViewById(R.id.btn_calc);
    }

    public void calcPrice(View view) {
        String priceAlc = valueAlc.getText().toString();
        String priceGas = valueGas.getText().toString();

        Boolean res = validate(priceAlc, priceGas);

        if (res){
            Double valAlc = Double.parseDouble(priceAlc);
            Double valGas = Double.parseDouble(priceGas);

            Double result = valAlc/valGas;
            if (result  >= 0.7){
                textResult.setText("É melhor utilizar gasolina");
            } else {
                textResult.setText("É melhor utilizar Álcool");
            }
        }else{
            textResult.setText("Preencha os preços primeiro");
        }
    }

    public Boolean validate(String pAlc, String pGas) {

        Boolean isValidate = true;
        if (pAlc == null || pAlc.equals("")) {
            isValidate = false;
        } else if (pGas == null || pGas.equals("")) {
            isValidate = false;
        }
        return isValidate;
    }
}