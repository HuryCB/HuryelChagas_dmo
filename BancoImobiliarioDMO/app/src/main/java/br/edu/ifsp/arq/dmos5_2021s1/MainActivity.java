package br.edu.ifsp.arq.dmos5_2021s1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mMButton, mKButton, mPontoButton;
    private Button mCButton;

    private EditText mSaidaView, mJogador1View, mJogador2View;
    private TextView mJogador1TextView, mJogador2TextView, mFeedbackTextView;
    Map<Integer, Integer> mapa = new HashMap<>();
    private int mOldValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        mJogador1TextView = findViewById(R.id.view_jogador1);
        mJogador2TextView = findViewById(R.id.view_jogador2);
        mFeedbackTextView = findViewById(R.id.view_feedback);

        for (int i = 1; i < 7; i++) {
            mapa.put(i, 15000);
        }
    }

    @Override
    public void onClick(View view) {
        int jogador1 = 0;
        int jogador2 = 0;
        int valor = 0;

        try {
            jogador1 = Integer.valueOf(mJogador1View.getText().toString());
            if (jogador1 > 6) jogador1 = 0;
        } catch (NumberFormatException ex) {
            jogador1 = 0;
        }
        try {
            jogador2 = Integer.valueOf(mJogador2View.getText().toString());
            if (jogador2 > 6) jogador2 = 0;
        } catch (NumberFormatException ex) {
            jogador2 = 0;
        }
        try {
            valor = Integer.valueOf((mSaidaView.getText().toString()));
        } catch (NumberFormatException ex) {
            valor = 0;
        }

        switch (view.getId()) {
            case R.id.button_c:
                transacao(jogador1, jogador2, -mOldValor);
                mSaidaView.setText("");
                mSaidaView.setHint("Transação revertida!");
                mOldValor = 0;
                break;
            case R.id.button_k:
                if (valor < 1000)
                    transacao(jogador1, jogador2, valor);
                break;
            case R.id.button_m:
                valor = valor * 1000;
                mSaidaView.setText(String.valueOf(valor));
                transacao(jogador1, jogador2, valor);
                break;
            case R.id.button_ponto:
                valor = valor * 100;
                mSaidaView.setText(String.valueOf(valor));
                transacao(jogador1, jogador2, valor);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }

    public void transacao(int jogador1, int jogador2, int valor) {

        if (jogador1 == jogador2) {
            mSaidaView.setText("");
            mSaidaView.setHint("Jogadores iguais!");
            mFeedbackTextView.setText("Jogadores iguais!");
            return;
        } else if ((jogador1 == 0 || jogador1 > 6) && (jogador2 == 0 || jogador2 > 6)) {
            mFeedbackTextView.setText("Banco <--> Banco");
            //?
            return;
        } else if (jogador1 == 0 || jogador1 > 6) {
            int teste2 = mapa.get(jogador2);
            mapa.replace(jogador2, teste2 - valor);
            mSaidaView.setText("");
            mSaidaView.setHint("Transação bem sucedida!");
            mFeedbackTextView.setText("Jogador -> Banco");
            mJogador2TextView.setText(String.valueOf(mapa.get(jogador2)));
            mJogador1TextView.setText("Banco");
            mOldValor = valor;
            return;
        } else if (jogador2 == 0 || jogador2 > 6 ) {
            int teste1 = mapa.get(jogador1);
            mapa.replace(jogador1, teste1 + valor);
            mSaidaView.setText("");
            mSaidaView.setHint("Transação bem sucedida!");
            mFeedbackTextView.setText("Banco -> Jogador");
            mJogador1TextView.setText(String.valueOf(mapa.get(jogador1)));
            mJogador2TextView.setText("Banco");
            mOldValor = valor;

            return;
        } else {
            if ((mapa.get(jogador2) - valor) < -1) return;

            int teste1 = mapa.get(jogador1);
            int teste2 = mapa.get(jogador2);
            mapa.replace(jogador1, teste1 + valor);
            mapa.replace(jogador2, teste2 - valor);
            mJogador1TextView.setText(String.valueOf(mapa.get(jogador1)));
            mJogador2TextView.setText(String.valueOf(mapa.get(jogador2)));
            mSaidaView.setText("");
            mSaidaView.setHint("Transação bem sucedida!");
            mFeedbackTextView.setText("Jogador -> Jogador");
            mOldValor = valor;
        }
    }

}

/*
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="12dp"
        android:gravity="center"
        android:orientation="horizontal">

        <Button
            android:id="@+id/button_c"
            android:layout_width="64dp"
            android:layout_height="64dp"
            android:layout_margin="12dp"
            android:layout_marginLeft="60dp"
            android:backgroundTint="#FF2222"
            android:text="C" />

        <Button
            android:id="@+id/button_ponto"
            android:layout_width="64dp"
            android:layout_height="64dp"
            android:layout_margin="12dp"
            android:layout_marginRight="60dp"
            android:backgroundTint="@color/gray"
            android:text="." />
    </LinearLayout>
 */