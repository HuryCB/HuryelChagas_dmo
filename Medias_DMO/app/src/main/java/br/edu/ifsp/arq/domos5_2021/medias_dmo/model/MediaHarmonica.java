package br.edu.ifsp.arq.domos5_2021.medias_dmo.model;

import java.util.List;

public class MediaHarmonica implements MediaStrategy{

    private List<Double> values;

    public MediaHarmonica(List<Double> values) {
        this.values = values;
    }

    @Override
    public Double calcularMedia() {
        Double sum = 0D;
        for(Double d : values){
            sum += 1/d;
        }
        return values.size()/sum;
    }
}
