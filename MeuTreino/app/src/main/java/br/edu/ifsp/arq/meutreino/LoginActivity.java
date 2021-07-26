package br.edu.ifsp.arq.meutreino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mTreinadorButton, mEsportistaTreinador, mButtonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTreinadorButton = findViewById(R.id.buttonTreinador);
        mTreinadorButton.setOnClickListener(this);
        mEsportistaTreinador = findViewById(R.id.buttonEsportista);
        mEsportistaTreinador.setOnClickListener(this);
        mButtonLogin = findViewById(R.id.buttonLogin);
        mButtonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonLogin :
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                break;
        }
    }
}
