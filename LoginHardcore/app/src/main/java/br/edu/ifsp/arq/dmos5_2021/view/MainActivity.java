package br.edu.ifsp.arq.dmos5_2021.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.edu.ifsp.arq.dmos5_2021.R;
import br.edu.ifsp.arq.dmos5_2021.constantes.Constantes;
import br.edu.ifsp.arq.dmos5_2021.controller.LoginController;
import br.edu.ifsp.arq.dmos5_2021.view.LoginActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText mUserEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando referencias do layout
        mUserEditText = findViewById(R.id.edit_user);
        mPasswordEditText = findViewById(R.id.edit_password);
        mLoginButton = findViewById(R.id.button_login);

        //Configurando listener
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mLoginButton){
            login();
        }
    }

    private void login(){
        String username = mUserEditText.getText().toString();
        int password;
        try{
            password = Integer.valueOf(mPasswordEditText.getText().toString()).intValue();
        }catch (NumberFormatException ex){
            password = 0;
        }

        //Criar um pacote/embrulho de dados (Bundle) para enviar para nova Acvity
        Bundle embrulho = new Bundle();
        embrulho.putString(Constantes.KEY_USERNAME,username);
        embrulho.putInt(Constantes.KEY_PASSWORD,password);

        //Abrir a LoginActivity
        Intent intencao = new Intent (this, LoginActivity.class);
        //Incluir o embrulho na intenção
        intencao.putExtras(embrulho);
        startActivity(intencao);
        /*
        if(LoginController.checklogin(username, password)){
            Toast.makeText(this, getString(R.string.msg_login_sucess), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, getString(R.string.msg_login_error), Toast.LENGTH_SHORT).show();
        }
         */

    }

    //private boolean checkLogin(String username, int password){
      //  return username.equalsIgnoreCase(USER) && password == PASSWORD;
    //}
}