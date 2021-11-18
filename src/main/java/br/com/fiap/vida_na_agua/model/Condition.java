package br.com.fiap.vida_na_agua.model;

public class Condition {
    double lixo;
    double microorganismos;
    boolean esgoto;
    String balneabilidade;

    public Condition() {}

    public Condition(double lixo, double microorganismos, boolean esgoto, String balneabilidade) {
        this.lixo = lixo;
        this.microorganismos = microorganismos;
        this.esgoto = esgoto;
        this.balneabilidade = balneabilidade;
    }

    public double getLixo() {
        return lixo;
    }

    public void setLixo(double lixo) {
        this.lixo = lixo;
    }

    public double getMicroorganismos() {
        return microorganismos;
    }

    public void setMicroorganismos(double microorganismos) {
        this.microorganismos = microorganismos;
    }

    public boolean isEsgoto() {
        return esgoto;
    }

    public void setEsgoto(boolean esgoto) {
        this.esgoto = esgoto;
    }

    public String getBalneabilidade() {
        return balneabilidade;
    }

    public void setBalneabilidade(String balneabilidade) {
        this.balneabilidade = balneabilidade;
    }
}
