package br.edu.ifsp.arq.dmos5_2021s1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mResetarButton, mMButton, mKButton, mPontoButton;
    private Button mCButton;

    private EditText mSaidaView, mJogador1View, mJogador2View;
    private TextView mFeedbackView;

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

    }


}

