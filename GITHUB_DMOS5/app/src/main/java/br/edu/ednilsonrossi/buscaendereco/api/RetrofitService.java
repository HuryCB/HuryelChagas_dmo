package br.edu.ednilsonrossi.buscaendereco.api;

import java.util.List;

import br.edu.ednilsonrossi.buscaendereco.model.Repository;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("users/{user}/repos")
    Call<List<Repository>> getDados(@Path("user") String user);
}
