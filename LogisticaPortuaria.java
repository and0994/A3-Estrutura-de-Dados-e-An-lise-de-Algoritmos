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

        System.out.print("Insira os volumes dos containers, digite os valores separados por espaço (Ex: 10 20 30): ");
        scanner.nextLine();

        String[] entradaVolumes = scanner.nextLine().split(" ");

        List<Integer> containers = new ArrayList<>();

        //Convertendo valores de entrada de containers inseridos
        for (String volume : entradaVolumes) {
            containers.add(Integer.parseInt(volume));
        }

        containers.sort(Collections.reverseOrder());

        List<Armazem> armazens = Alocador.alocarNosArmazens(containers, limiteArmazem);

        System.out.println("\nNúmero de armazéns utilizados: " + armazens.size());
        for (int i = 0; i < armazens.size(); i++) {
            System.out.println("Armazém " + (i + 1) + ": " + armazens.get(i));
        }

        List<Integer> cargasArmazens = new ArrayList<>();
        for (Armazem armazem : armazens) {
            cargasArmazens.add(armazem.getCargaAtual());
        }

        List<Caminhao> caminhoes = Alocador.alocarNosCaminhoes(cargasArmazens, limiteCaminhao);

        System.out.println("\nNúmero de caminhões utilizados: " + caminhoes.size());
        for (int i = 0; i < caminhoes.size(); i++) {
            System.out.println("Caminhão " + (i + 1) + ": " + caminhoes.get(i));
        }

        scanner.close();
    }
}
