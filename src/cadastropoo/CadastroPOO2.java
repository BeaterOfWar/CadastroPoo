package cadastropoo;

import java.util.ArrayList;
import java.util.Scanner;

import cadastropoo.model.*;

import java.io.IOException;

public class CadastroPOO2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoPessoaFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPessoaJuridica = new PessoaJuridicaRepo();

        int opcao;
        do {
            System.out.println("\n==============================");
            System.out.println("Opções:");
            System.out.println("1. Incluir");
            System.out.println("2. Alterar");
            System.out.println("3. Excluir");
            System.out.println("4. Exibir pelo ID");
            System.out.println("5. Exibir todos");
            System.out.println("6. Salvar dados");
            System.out.println("7. Recuperar dados");
            System.out.println("0. Finalizar");
            System.out.println("==============================");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Tipo Fisica (F) ou Juridica (J): ");
                    String tipoCadastro = scanner.nextLine();
                    if (tipoCadastro.equalsIgnoreCase("F")) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();

                        PessoaFisica novaPessoaFisica = new PessoaFisica(id, nome, cpf, idade);
                        repoPessoaFisica.inserir(novaPessoaFisica);
                        System.out.println("Pessoa física adicionada com sucesso!");
                    } else if (tipoCadastro.equalsIgnoreCase("J")) {
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome da empresa: ");
                        String nomeEmpresa = scanner.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = scanner.nextLine();

                        PessoaJuridica novaEmpresa = new PessoaJuridica(id, nomeEmpresa, cnpj);
                        repoPessoaJuridica.inserir(novaEmpresa);
                        System.out.println("Empresa adicionada com sucesso!");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case 2:
                    System.out.print("Tipo Fisica (F) ou Juridica (J): ");
                    String tipoAlteracao = scanner.nextLine();
                    System.out.print("ID da pessoa a ser alterada: ");
                    int idAlteracao = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoAlteracao.equalsIgnoreCase("F")) {
                        PessoaFisica pessoaAlteracao = repoPessoaFisica.obter(idAlteracao);
                        if (pessoaAlteracao != null) {
                            pessoaAlteracao.exibir();

                            System.out.print("Novo nome: ");
                            String novoNome = scanner.nextLine();
                            pessoaAlteracao.setNome(novoNome);


                            System.out.println("Dados alterados com sucesso!");
                        } else {
                            System.out.println("Pessoa física não encontrada.");
                        }
                    } else if (tipoAlteracao.equalsIgnoreCase("J")) {
                        PessoaJuridica empresaAlteracao = repoPessoaJuridica.obter(idAlteracao);
                        if (empresaAlteracao != null) {
                            empresaAlteracao.exibir();

                            System.out.print("Novo nome da empresa: ");
                            String novoNomeEmpresa = scanner.nextLine();
                            empresaAlteracao.setNome(novoNomeEmpresa);



                            System.out.println("Dados da empresa alterados com sucesso!");
                        } else {
                            System.out.println("Empresa não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case 3:
                    System.out.print("Tipo Fisica (F) ou Juridica (J): ");
                    String tipoExclusao = scanner.nextLine();
                    System.out.print("ID da pessoa a ser excluída: ");
                    int idExclusao = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoExclusao.equalsIgnoreCase("F")) {
                        boolean excluiu = repoPessoaFisica.excluir(idExclusao);
                        if (excluiu) {
                            System.out.println("Pessoa física excluída com sucesso!");
                        } else {
                            System.out.println("Pessoa física não encontrada.");
                        }
                    } else if (tipoExclusao.equalsIgnoreCase("J")) {
                        boolean excluiu = repoPessoaJuridica.excluir(idExclusao);
                        if (excluiu) {
                            System.out.println("Empresa excluída com sucesso!");
                        } else {
                            System.out.println("Empresa não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case 4:
                    System.out.print("Tipo Fisica (F) ou Juridica (J): ");
                    String tipoExibicao = scanner.nextLine();
                    System.out.print("ID da pessoa a ser exibida: ");
                    int idExibicao = scanner.nextInt();1
                    scanner.nextLine();

                    if (tipoExibicao.equalsIgnoreCase("F")) {
                        PessoaFisica pessoaExibicao = repoPessoaFisica.obter(idExibicao);
                        if (pessoaExibicao != null) {
                            pessoaExibicao.exibir();
                        } else {
                            System.out.println("Pessoa física não encontrada.");
                        }
                    } else if (tipoExibicao.equalsIgnoreCase("J")) {
                        PessoaJuridica empresaExibicao = repoPessoaJuridica.obter(idExibicao);
                        if (empresaExibicao != null) {
                            empresaExibicao.exibir();
                        } else {
                            System.out.println("Empresa não encontrada.");
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;



                case 5:
                    System.out.print("Tipo Fisica (F) ou Juridica (J): ");
                    String tipoExibicaoTodos = scanner.nextLine();

                    if (tipoExibicaoTodos.equalsIgnoreCase("F")) {
                        ArrayList<PessoaFisica> todasPessoasFisicas = repoPessoaFisica.obterTodos();
                        for (PessoaFisica pessoa : todasPessoasFisicas) {
                            pessoa.exibir();
                        }
                    } else if (tipoExibicaoTodos.equalsIgnoreCase("J")) {
                        ArrayList<PessoaJuridica> todasEmpresas = repoPessoaJuridica.obterTodos();
                        for (PessoaJuridica empresa : todasEmpresas) {
                            empresa.exibir();
                        }
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;
                case 6:
                    System.out.print("Prefixo dos arquivos: ");
                    String prefixo = scanner.nextLine();
                    repoPessoaFisica.persistir(prefixo + ".fisica.bin");
                    repoPessoaJuridica.persistir(prefixo + ".juridica.bin");
                    System.out.println("Dados salvos com sucesso!");
                    break;

                case 7:
                    System.out.print("Prefixo dos arquivos: ");
                    prefixo = scanner.nextLine();
                    try {
                        repoPessoaFisica.recuperar(prefixo + ".fisica.bin");
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        repoPessoaJuridica.recuperar(prefixo + ".juridica.bin");
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Dados recuperados com sucesso!");
                    break;

                case 0:
                    System.out.println("Finalizando o programa.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
