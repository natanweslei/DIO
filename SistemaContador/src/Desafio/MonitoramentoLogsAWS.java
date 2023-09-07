package Desafio;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonitoramentoLogsAWS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalEventos = 0;
        Map<String, Integer> eventosPorServico = new HashMap<>();
        String maiorServico = "";
        String menorServico = "";


        int quantidadeLogs = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner


        //TODO:  realize a análise dos logs e retorne os seus resultados
        // Itera sobre os logs e realiza a análise
        for (int i = 0; i < quantidadeLogs; i++) {
            String log = scanner.nextLine(); // Lê uma linha de log
            String[] logInfo = log.split(","); // Divide a linha em informações usando vírgula como separador

            if (logInfo.length != 3) {
                continue; // Ignora logs com informações incompletas
            }
            String servico = logInfo[1].trim(); // Obtém o nome do serviço a partir das informações
            eventosPorServico.put(servico, eventosPorServico.getOrDefault(servico, 0) + 1); // Atualiza a contagem de eventos para o serviço
            totalEventos++; // Incrementa o total de eventos
        }

        // Encontra o serviço com maior quantidade de registros
        int maxEventos = -1;
        for (Map.Entry<String, Integer> entry : eventosPorServico.entrySet()) {
            if (entry.getValue() >= maxEventos) {
                maxEventos = entry.getValue();
                maiorServico = entry.getKey();
            }
        }

        // Encontra o serviço com menor quantidade de registros
        int minEventos = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : eventosPorServico.entrySet()) {
            if (entry.getValue() < minEventos) {
                minEventos = entry.getValue();
                menorServico = entry.getKey();
            }
        }

        // Exibe os resultados da análise
        System.out.println("Eventos por servico:");
        for (Map.Entry<String, Integer> entry : eventosPorServico.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("Maior:" + maiorServico);
        System.out.println("Menor:" + menorServico);
        scanner.close();
    }
}
