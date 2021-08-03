package br.edu.ednilsonrossi.buscaendereco.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import br.edu.ednilsonrossi.buscaendereco.R;
import br.edu.ednilsonrossi.buscaendereco.model.ItemRepositoryAdapter;
import br.edu.ednilsonrossi.buscaendereco.api.RetrofitService;
import br.edu.ednilsonrossi.buscaendereco.model.Repository;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_PERMISSION = 64;
    private static final String BASE_URL = "https://api.github.com/";

    private EditText editUser;
    private Button buttonSearch;
    private TextView textResultado;
    private RecyclerView recyclerRepositorys;

    private Retrofit mRetrofit;

    private ItemRepositoryAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editUser = findViewById(R.id.editTextUser);
        buttonSearch = findViewById(R.id.buttonSearch);
        textResultado = findViewById(R.id.textResultado);
        recyclerRepositorys = findViewById(R.id.recyclerRepositorys);

        buttonSearch.setOnClickListener(v -> onClick());

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerRepositorys.setLayoutManager(manager);
    }

    private void onClick() {
        if (temPermissao()) {
            searchRepos();
        } else {
            solicitaPermissao();
        }
    }

    private void searchRepos() {
        mRetrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        String user = editUser.getText().toString();
        if (user == null || user.isEmpty()) {
            Toast.makeText(this, "Usuario invalido!", Toast.LENGTH_SHORT).show();
        } else {
            RetrofitService mRetrofitService = mRetrofit.create(RetrofitService.class);

            Call<List<Repository>> call = mRetrofitService.getDados(user);

            call.enqueue(new Callback<List<Repository>>() {
                @Override
                public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
                    if (response.isSuccessful()) {
                        List<Repository> list = response.body();
                        updateUi(list);
                    }
                }

                @Override
                public void onFailure(Call<List<Repository>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Erro ao realizar requisição!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void updateUi(List<Repository> list) {
        if (list != null && list.size() > 0) {
            textResultado.setText(list.size() + " repositórios encontrados");
        } else {
            textResultado.setText("Nenhum repositório encontrado");
        }
        mAdapter = new ItemRepositoryAdapter(list);
        recyclerRepositorys.setAdapter(mAdapter);
    }

    private boolean temPermissao() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED;
    }

    private void solicitaPermissao() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)) {
            final Activity activity = this;
            new AlertDialog.Builder(this)
                    .setMessage("Necessário permissão para acesso a internet.")
                    .setPositiveButton("Fornecer", (dialog, which) -> ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.INTERNET}, REQUEST_PERMISSION))
                    .setNegativeButton("Negar", (dialog, which) -> dialog.dismiss())
                    .show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, REQUEST_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {
            for (int i = 0 ; i < permissions.length ; i++) {
                if (permissions[i].equalsIgnoreCase(Manifest.permission.INTERNET) && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    searchRepos();
                }
            }
        }
    }
}