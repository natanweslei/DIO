package Desafio;

import java.util.Scanner;

public class CalculandoCustosAWS {
    public static void main(String[] args) {
        // Definindo as taxas
        double custoPorHoraServidor = 0.15;
        double custoPorHoraBancoDados = 0.05;
        double custoTotal = 0.0;

        // Criando um objeto Scanner para receber as entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Recebendo as informações do usuário
        int quantidadeServidores = scanner.nextInt();

        int quantidadeBancosDados = scanner.nextInt();

        //TODO: Calcule os custos
        custoTotal = (quantidadeServidores * custoPorHoraServidor) + (custoPorHoraBancoDados * quantidadeBancosDados);


        System.out.printf("Custo total de uso da AWS por hora: R$ %.2f%n", custoTotal);

        // Fechando o Scanner
        scanner.close();
    }
}
