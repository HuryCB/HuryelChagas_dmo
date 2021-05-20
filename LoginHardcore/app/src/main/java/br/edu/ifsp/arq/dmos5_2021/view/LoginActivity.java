package br.edu.ifsp.arq.dmos5_2021.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import br.edu.ifsp.arq.dmos5_2021.R;
import br.edu.ifsp.arq.dmos5_2021.constantes.Constantes;
import br.edu.ifsp.arq.dmos5_2021.controller.LoginController;

public class LoginActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mTextView = findViewById(R.id.text_mensagem);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Recuperar o Bundle de dados
        Bundle bundle = getIntent().getExtras();

        String username = bundle.getString(Constantes.KEY_USERNAME, "Erro");
        int password = bundle.getInt(Constantes.KEY_PASSWORD, -1);

        int string_resource;
        if(LoginController.checklogin(username, password)){
            string_resource = R.string.msg_login_sucess;
        }else{
            string_resource = R.string.msg_login_error;
        }
        mTextView.setText(getString(string_resource));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}