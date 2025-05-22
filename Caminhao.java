public class Caminhao {
    private int cargaAtual = 0;

    public Caminhao() {
    }

    public void adicionarCarga(int carga) {
        cargaAtual += carga;
    }

    public int getCargaAtual() {
        return cargaAtual;
    }

    @Override
    public String toString() {
        return "Carga total: " + cargaAtual;
    }
}
