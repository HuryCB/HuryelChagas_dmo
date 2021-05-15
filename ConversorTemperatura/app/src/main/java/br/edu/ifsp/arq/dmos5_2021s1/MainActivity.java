package br.edu.ifsp.arq.dmos5_2021s1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText mEntradaText;
    private Button mParaCelsiusButton;
    private TextView mSaidaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar;
        actionbar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#FF3700B3"));
        actionbar.setBackgroundDrawable(colorDrawable);
        mEntradaText = findViewById(R.id.text_entrada);
        mParaCelsiusButton = findViewById(R.id.button_paraCelsius);
        mSaidaView = findViewById(R.id.text_saida);
        mParaCelsiusButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int entrada;
        float calculo;
        try {
            entrada = entrada = Integer.valueOf(mEntradaText.getText().toString());
            if(view.getId()==R.id.button_paraCelsius){
                calculo = (float) ((entrada-32)/1.8);
               // mSaidaView.setText(String.format("%.2f ºC",Float.toString(calculo)));
                mSaidaView.setText(String.format("%.2fºC",calculo));
            }
        }catch (NumberFormatException ex){
            mSaidaView.setText("Erro, digite um valor válido");
        }

    }
}