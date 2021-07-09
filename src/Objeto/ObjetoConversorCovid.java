package Objeto;
import java.util.Date;

public class ObjetoConversorCovid {
    private String regiao;
    private String estado;
    private int casosAcumulado;
    private String data;

    public ObjetoConversorCovid(String regiao, String estado, int casosAcumulado, String data){
        this.regiao = regiao;
        this.estado = estado;
        this.casosAcumulado = casosAcumulado;
        this.data = data;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCasosAcumulado() {
        return casosAcumulado;
    }

    public void setCasosAcumulado(int casosAcumulado) {
        this.casosAcumulado = casosAcumulado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}