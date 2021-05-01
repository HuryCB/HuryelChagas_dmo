package br.edu.ifsp.arq.dmo5_2021.conversormoeda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final float VALOR_DOLAR = 5.4f;

    private EditText mEntradaText;
    private Button mParaDolarButton, mParaRealButton;
    private TextView mSaidaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEntradaText = findViewById(R.id.text_entrada);
        mParaDolarButton = findViewById(R.id.button_paraDolar);
        mParaRealButton = findViewById(R.id.button_paraReal);
        mSaidaView = findViewById(R.id.text_saida);

        mParaDolarButton.setOnClickListener(this);
        mParaRealButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        float entrada, calculo;
        try {
            entrada = Float.valueOf(mEntradaText.getText().toString());
        }catch (NumberFormatException ex){
            entrada = 0;
        }
        switch(view.getId()){
            case R.id.button_paraDolar:
                calculo = entrada / VALOR_DOLAR;
                mSaidaView.setText("U$ = "+calculo);
                break;
            case R.id.button_paraReal:
                calculo = entrada * VALOR_DOLAR;
                mSaidaView.setText("R$ = "+calculo);
                break;
        }

    }
}