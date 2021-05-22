package br.edu.ifsp.arq.domos5_2021.medias_dmo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifsp.arq.domos5_2021.medias_dmo.R;
import br.edu.ifsp.arq.domos5_2021.medias_dmo.controller.MediaController;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mText1, mText2, mText3, mText4, mText5;
    private Button mMediaAritmeticaButton, mMediaHarmonicaButton;
    private List<Double> values;
    private TextView mTextView;
    private MediaController mediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        values = new ArrayList<Double>();
        mediaController = new MediaController();

        mText1 = findViewById(R.id.editText);
        mText2 = findViewById(R.id.editText2);
        mText3 = findViewById(R.id.editText3);
        mText4 = findViewById(R.id.editText4);
        mText5 = findViewById(R.id.editText5);
        mMediaAritmeticaButton = findViewById(R.id.mediaAritmeticaButton);
        mMediaHarmonicaButton = findViewById(R.id.mediaHarmonicaButton);

        mTextView = findViewById(R.id.textView);

        mMediaAritmeticaButton.setOnClickListener(this);
        mMediaHarmonicaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == mMediaAritmeticaButton){
            String resultado;
            if(TextUtils.isEmpty(mText1.getText().toString())|| TextUtils.isEmpty(mText2.getText().toString()) || TextUtils.isEmpty(mText3.getText().toString()) ||
                    TextUtils.isEmpty(mText4.getText().toString()) || TextUtils.isEmpty(mText5.getText().toString())){
                Toast.makeText(this, getString(R.string.msg_error), Toast.LENGTH_SHORT).show();
                return;
            }
            values.add( Double.valueOf( mText1.getText().toString() ) );
            values.add( Double.valueOf( mText2.getText().toString() ) );
            values.add( Double.valueOf( mText3.getText().toString() ) );
            values.add( Double.valueOf( mText4.getText().toString() ) );
            values.add( Double.valueOf( mText5.getText().toString() ) );
            resultado = String.valueOf(mediaController.mediaArimetica( values ));
            Toast.makeText(this, "Media Aritmetica = " +resultado, Toast.LENGTH_SHORT).show(); //verme
            values.clear();
        }
    if(view == mMediaHarmonicaButton)   {
        String resultado;
        if(TextUtils.isEmpty(mText1.getText().toString())|| TextUtils.isEmpty(mText2.getText().toString()) || TextUtils.isEmpty(mText3.getText().toString()) ||
                TextUtils.isEmpty(mText4.getText().toString()) || TextUtils.isEmpty(mText5.getText().toString())){
            Toast.makeText(this, getString(R.string.msg_error), Toast.LENGTH_SHORT).show();
            return;
        }
        values.add( Double.valueOf( mText1.getText().toString() ) );
        values.add( Double.valueOf( mText2.getText().toString() ) );
        values.add( Double.valueOf( mText3.getText().toString() ) );
        values.add( Double.valueOf( mText4.getText().toString() ) );
        values.add( Double.valueOf( mText5.getText().toString() ) );
        resultado = String.valueOf(mediaController.mediaHarmonica(values));
        Toast.makeText(this, "Media Harmonica = " +resultado, Toast.LENGTH_SHORT).show(); //verme
        values.clear();
    }

    }
}