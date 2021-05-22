package br.edu.ifsp.arq.domos5_2021.medias_dmo.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import java.util.ArrayList;

import br.edu.ifsp.arq.domos5_2021.medias_dmo.R;
import br.edu.ifsp.arq.domos5_2021.medias_dmo.controller.MediaController;

public class MediaHarmonicaActivity extends AppCompatActivity {
    private TextView mTextView, mTextView1, mTextView2, mTextView3, mTextView4, mTextView5;
    String resultado;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_aritmetica);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mTextView = findViewById(R.id.textView);
        mTextView1 = findViewById(R.id.textView);
        mTextView2 = findViewById(R.id.textView);
        mTextView3 = findViewById(R.id.textView);
        mTextView4 = findViewById(R.id.textView);
        mTextView5 = findViewById(R.id.textView);
        //double teste[] = new double[0];
        //Bundle bundle = getIntent().getExtras();
        ArrayList<Double> values = (ArrayList<Double>) getIntent().getSerializableExtra("list");
        //resultado = String.valueOf(mediaController.mediaArimetica( values ));
        //resultado = resultado
        //ArrayList<Double> values = bundle.get
        // Double d : values;
        // sum += d;
        mTextView1.setText("teste");
        mTextView2.setText(String.valueOf(values.get(1)));
        mTextView3.setText(String.valueOf(values.get(2)));
        mTextView4.setText(String.valueOf(values.get(3)));
        mTextView5.setText(String.valueOf(values.get(4)));

        resultado = String.valueOf(mediaController.mediaArimetica(values ));
        mTextView.setText(resultado);
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
