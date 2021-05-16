package br.edu.ifsp.arq.dmos5_2021s1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mResetarButton, mMButton, mKButton, mPontoButton;
    private Button mMenosButton, mMaisButton, mCButton;

    private EditText mSaidaView, mJogador1View, mJogador2View;
    private TextView mFeedbackView;
    private Object player1, player2, player3, player4, player5, player6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mResetarButton = findViewById(R.id.button_resetar);
        mResetarButton.setOnClickListener(this);
        mMButton = findViewById(R.id.button_m);
        mMButton.setOnClickListener(this);
        mKButton = findViewById(R.id.button_k);
        mKButton.setOnClickListener(this);
        mPontoButton = findViewById(R.id.button_ponto);
        mPontoButton.setOnClickListener(this);
        mCButton = findViewById(R.id.button_c);
        mCButton.setOnClickListener(this);

        mSaidaView = findViewById(R.id.text_saida);
        mJogador1View = findViewById(R.id.text_jogador1);
        mJogador2View = findViewById(R.id.text_jogador2);
        mFeedbackView = findViewById(R.id.view_feedback);

        player1 = 15000;
        player2 = 15000;
        player3 = 15000;
        player4 = 15000;
        player5 = 15000;
        player6 = 15000;
        //mSaidaView.setText("k");

    }

    @Override
    public void onClick(View view) {
        int jogador1 = 0;
        int jogador2 = 0;
        int valor = 0;
        boolean funcional = false;

        try {
            jogador1 = Integer.valueOf(mJogador1View.getText().toString());
            if(jogador1>6) jogador1 = 0;
        }catch (NumberFormatException ex){
            jogador1 = 0;
        }
        try {
            jogador2 = Integer.valueOf(mJogador2View.getText().toString());
            if(jogador2>6) jogador2 = 0;
        }catch (NumberFormatException ex){
            jogador2 = 0;
        }
        try{
            valor = Integer.valueOf((mSaidaView.getText().toString()));
        }catch (NumberFormatException ex){
            valor = 0;
        }


        if(jogador1 != 0 && jogador2 != 0 && valor != 0){
            funcional = true;
        }
        switch (view.getId()) {
            case R.id.button_c:
                if(funcional){
                    mFeedbackView.setText("funcional");
                }
                else{
                    mFeedbackView.setText("erro");
                }
                //mSaidaView.setText(String.valueOf(jogador1));
                break;
            case R.id.button_k:
                if(valor<1000)
                mSaidaView.setText(String.valueOf(valor));

                break;
            case R.id.button_m:
                mSaidaView.setText(String.valueOf(valor*1000));
                break;
            case R.id.button_ponto:
                mFeedbackView.setText("Erro");
                break;
            case R.id.button_resetar:
                mFeedbackView.setText("Erro");
                break;
        }
    }

    public void transferirPreco(int jogador1, int jogador2){
        switch (jogador1){
            case 1: player1 += player2;
        }
    }
}
/*
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

 */
