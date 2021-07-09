package Objeto;

public class ObejtoConversorContagem {
    private String estado;
    private int quantidade;

    public ObejtoConversorContagem(String estado, int quantidade) {
        this.estado = estado;
        this.quantidade = quantidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
