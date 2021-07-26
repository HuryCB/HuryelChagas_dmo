package br.edu.ifsp.arq.meutreino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mPeitoButton, mAbdomenButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mPeitoButton = findViewById(R.id.peitoButton);
        mPeitoButton.setOnClickListener(this);
        mAbdomenButton = findViewById(R.id.abdomenButton);
        mAbdomenButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.peitoButton :
                startActivity(new Intent(MainActivity.this, PeitoActivity.class));
                break;
            case R.id.abdomenButton:
                startActivity(new Intent(MainActivity.this, AbdomenActivity.class));
                break;
        }
    }
}