import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LogisticaPortuaria {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira o limite de carga do armazém: ");
        int limiteArmazem = scanner.nextInt();

        System.out.print("Insira o limite de carga dos caminhões: ");
        int limiteCaminhao = scanner.nextInt();

        System.out.print("Insira os volumes dos containers, por favor, digite os valores separados por espaço, ex: 10 20 30: ");
        scanner.nextLine();

        String[] entradaVolumes = scanner.nextLine().split(" ");

        List<Integer> containers = new ArrayList<>();
        for (String volume : entradaVolumes) {
            containers.add(Integer.parseInt(volume));
        }

        containers.sort(Collections.reverseOrder());

        List<List<Integer>> armazens = alocarNosArmazens(containers, limiteArmazem);

        System.out.println("Número de armazéns utilizados: " + armazens.size());
        for (int i = 0; i < armazens.size(); i++) {
            System.out.println("Armazém " + (i + 1) + ": " + armazens.get(i));
        }

        List<Integer> cargasArmazens = new ArrayList<>();
        for (List<Integer> armazem : armazens) {
            int soma = 0;
            for (int volume : armazem) {
                soma += volume;
            }
            cargasArmazens.add(soma);
        }

        List<Integer> caminhoes = alocarNosCaminhoes(cargasArmazens, limiteCaminhao);

        System.out.println("Número de caminhões utilizados: " + caminhoes.size());
        for (int i = 0; i < caminhoes.size(); i++) {
            System.out.println("Caminhão " + (i + 1) + ": carga total de " + caminhoes.get(i));
        }

        scanner.close();
    }

    public static List<List<Integer>> alocarNosArmazens(List<Integer> containers, int limiteArmazem) {
        List<List<Integer>> armazens = new ArrayList<>();
        List<Integer> cargasAtuais = new ArrayList<>();

        for (int volume : containers) {
            boolean alocado = false;

            for (int i = 0; i < armazens.size(); i++) {
                if (cargasAtuais.get(i) + volume <= limiteArmazem) {
                    armazens.get(i).add(volume);
                    cargasAtuais.set(i, cargasAtuais.get(i) + volume);
                    alocado = true;
                    break;
                }
            }

            if (!alocado) {
                List<Integer> novoArmazem = new ArrayList<>();
                novoArmazem.add(volume);
                armazens.add(novoArmazem);
                cargasAtuais.add(volume);
            }
        }

        return armazens;
    }

    public static List<Integer> alocarNosCaminhoes(List<Integer> cargas, int limiteCaminhao) {
        List<Integer> caminhoes = new ArrayList<>();
        List<Integer> cargasRestantes = new ArrayList<>(cargas);

        while (!cargasRestantes.isEmpty()) {
            int restante = limiteCaminhao;

            for (int i = 0; i < cargasRestantes.size();) {
                int carga = cargasRestantes.get(i);

                if (carga <= restante) {
                    restante -= carga;
                    cargasRestantes.remove(i);
                } else {
                    cargasRestantes.set(i, carga - restante);
                    restante = 0;
                    break;
                }
            }

            caminhoes.add(limiteCaminhao - restante);
        }

        return caminhoes;
    }
}
