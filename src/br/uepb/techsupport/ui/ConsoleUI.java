package br.uepb.techsupport.ui;

import br.uepb.techsupport.model.*;
import br.uepb.techsupport.model.enums.*;
import br.uepb.techsupport.repository.*;
import br.uepb.techsupport.service.*;
import br.uepb.techsupport.strategy.*;

import java.util.*;

public class ConsoleUI {

    private Scanner scanner = new Scanner(System.in);
    private TecnicoRepository tecnicoRepo = new TecnicoRepository();
    private OrdemServicoRepository osRepo = new OrdemServicoRepository();
    private FilaService filaService = new FilaService(new PrioridadeStrategy());

    public void iniciar() {
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("1 - Cadastrar Tecnico");
            System.out.println("2 - Cadastrar OS");
            System.out.println("3 - Executar Escalonamento");
            System.out.println("4 - Listar OS");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> cadastrarTecnico();
                case 2 -> cadastrarOS();
                case 3 -> executar();
                case 4 -> listar();
            }
        }
    }

    private void cadastrarTecnico() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nivel (JUNIOR, PLENO, SENIOR): ");
        NivelTecnico nivel = NivelTecnico.valueOf(scanner.nextLine());
        tecnicoRepo.adicionar(new Tecnico(id, nome, nivel));
    }

    private void cadastrarOS() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Descricao: ");
        String desc = scanner.nextLine();
        System.out.print("Prioridade (BAIXA, MEDIA, ALTA): ");
        Prioridade p = Prioridade.valueOf(scanner.nextLine());
        System.out.print("Tempo estimado: ");
        int tempo = scanner.nextInt();
        osRepo.adicionar(new OrdemServico(id, desc, p, tempo));
    }

    private void executar() {
        try {
            filaService.executarEscalonamento(
                osRepo.listarPendentes(),
                tecnicoRepo.listarTodos()
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listar() {
        osRepo.listarTodas()
              .forEach(os -> System.out.println(
                  os.getId() + " - " +
                  os.getDescricao() + " - " +
                  os.getStatus()
              ));
    }
}