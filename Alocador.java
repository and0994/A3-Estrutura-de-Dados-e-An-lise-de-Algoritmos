import java.util.ArrayList;
import java.util.List;

public class Alocador {

    public static List<Armazem> alocarNosArmazens(List<Integer> containers, int limiteArmazem) {
        List<Armazem> armazens = new ArrayList<>();

        for (int volume : containers) {
            boolean alocado = false;

            for (Armazem armazem : armazens) {
                if (armazem.adicionarContainer(volume)) {
                    alocado = true;
                    break;
                }
            }

            if (!alocado) {
                Armazem novoArmazem = new Armazem(limiteArmazem);
                novoArmazem.adicionarContainer(volume);
                armazens.add(novoArmazem);
            }
        }

        return armazens;
    }

    public static List<Caminhao> alocarNosCaminhoes(List<Integer> cargas, int limiteCaminhao) {
        List<Caminhao> caminhoes = new ArrayList<>();
        List<Integer> cargasRestantes = new ArrayList<>(cargas);

        while (!cargasRestantes.isEmpty()) {
            int restante = limiteCaminhao;
            Caminhao caminhao = new Caminhao();

            for (int i = 0; i < cargasRestantes.size();) {
                int carga = cargasRestantes.get(i);

                if (carga <= restante) {
                    restante -= carga;
                    caminhao.adicionarCarga(carga);
                    cargasRestantes.remove(i);
                } else {
                    cargasRestantes.set(i, carga - restante);
                    caminhao.adicionarCarga(restante);
                    restante = 0;
                    break;
                }
            }

            caminhoes.add(caminhao);
        }

        return caminhoes;
    }
}
