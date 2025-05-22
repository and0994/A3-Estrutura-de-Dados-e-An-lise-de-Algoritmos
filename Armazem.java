import java.util.ArrayList;
import java.util.List;

public class Armazem {
    private List<Integer> containers = new ArrayList<>();
    private int cargaAtual = 0;
    private final int limite;

    public Armazem(int limite) {
        this.limite = limite;
    }

    public boolean adicionarContainer(int volume) {
        if (cargaAtual + volume <= limite) {
            containers.add(volume);
            cargaAtual += volume;
            return true;
        }
        return false;
    }

    public int getCargaAtual() {
        return cargaAtual;
    }

    public List<Integer> getContainers() {
        return containers;
    }

    @Override
    public String toString() {
        return "Containers: " + containers + " | Carga total: " + cargaAtual;
    }
}
