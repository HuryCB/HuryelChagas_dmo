package br.edu.ifsp.arq.dmo5_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPesoText;
    private EditText mAlturaText;
    private TextView mImcView;
    private Button mCalcularButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Esconder a barra superior do aplicativo
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        //Recuperando as referencias dos objetos de interface
        mPesoText = findViewById(R.id.text_peso);
        mAlturaText = findViewById(R.id.text_altura);
        mImcView = findViewById(R.id.view_saida_imc);
        mCalcularButton = findViewById(R.id.button_calcular);

        mCalcularButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == mCalcularButton){
            calcularIMC();
        }
    }

    private void calcularIMC(){
        float peso, altura, imc;
        try{
            peso = Float.valueOf(mPesoText.getText().toString());
            altura = Float.valueOf(mAlturaText.getText().toString());
        } catch (Exception ex) {
            peso = 0;
            altura = 0;
        }

        if(peso != 0 && altura != 0){
            imc = peso / (altura * altura);
            mImcView.setText(String.format("%s %.2f", "IMC: ", imc));
        } else {
            mImcView.setText("Dados informados são inválidos.");
        }
    }
}
/*
Muito bom!
Nota: 10.
 */