package br.edu.ifsp.arq.domos5_2021.medias_dmo.view;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.arq.domos5_2021.medias_dmo.R;

public class MediaPonderadaActivity extends AppCompatActivity {
    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstancesState){
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_ponderada);
    }
}
