package exbanco;

import java.util.Scanner;

public class ExBanco {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Cont con[] = new Cont[10];
        for (int i = 0; i < con.length; i++) {
            con[i] = new Cont();
        }

        int achou = 0, ind = 0;
        System.out.println(" ########### CADASTRO ##########");
        for (int i = 0; i < 10; i++) {
            System.out.println("Digite o numero da conta");
            int conta = scan.nextInt();
            achou = 0;
            for (int j = 0; j < 10; j++) {
                if (conta == con[j].conta) {
                    achou = 1;
                    break; // Adicionado para sair do loop assim que a conta é encontrada
                }
            }
            if (achou == 1) {
                System.out.println("Conta já Cadastrada");
            } else {
                con[i].conta = conta;
                System.out.println("Digite o Tipo:");
                con[i].tipo = scan.next();
                System.out.println("Digite o Nome do Cliente:");
                con[i].cliente = scan.next();
                System.out.println("Digite o CPF:");
                con[i].CPF = scan.nextLong();
                System.out.println("Digite o Telefone:");
                con[i].telefone = scan.next();
                System.out.println("Digite o Saldo:");
                con[i].saldo = scan.nextDouble();
                ind++;
            }
        }

        System.out.println("Dados Cadastrados");
        System.out.printf("%10s %10s %10s %10s %10s %10s\n", "Conta", "Tipo", "Cliente", "CPF", "Telefone", "Saldo");
        for (int i = 0; i < ind; i++) {
            System.out.printf("%10d %10s %10s %10d %10s %10.2f\n",
                    con[i].conta, con[i].tipo, con[i].cliente, con[i].CPF, con[i].telefone, con[i].saldo);
        }

        int opcao;

        do {
            System.out.println("\nMenu\n"
                    + "\n1 - Visualizar Contas\n"
                    + "\n2 - Realize Saque\n"
                    + "\n3 - Realize Deposito\n"
                    + "\n4 - Sair\n"
                    + "\nEscolha a opção:\n");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < ind; i++) {
                        System.out.printf("%10s %20s %20s %20d %20s %20.2f\n",
                                con[i].conta, con[i].tipo, con[i].cliente, con[i].CPF, con[i].telefone, con[i].saldo);
                    }
                    break;

                case 2:
                    System.out.println("Digite o numero da conta:");
                    int conta = scan.nextInt();
                    System.out.println("Digite o valor do saque:");
                    double valor = scan.nextDouble();

                    for (int i = 0; i < ind; i++) {
                        if (conta == con[i].conta) {
                            if (valor > con[i].saldo) {
                                System.out.println("Saldo insuficiente");
                                break;
                            } else {
                                con[i].saldo -= valor;
                                System.out.println("Saque realizado com sucesso");
                            }
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite o numero da conta:");
                    int contDep = scan.nextInt();
                    System.out.println("Digite o valor do deposito:");
                    double valDep = scan.nextDouble();

                    for (int i = 0; i < ind; i++) {
                        if (contDep == con[i].conta) {
                            con[i].saldo += valDep;
                            System.out.println("Deposito realizado com sucesso");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Obrigado por utilizar o sistema!");
                    System.out.println("Deseja sair ? (S/N)");
                    String resposta = scan.next();

                    if (resposta.equalsIgnoreCase("S")) {
                        System.exit(0);
                    } else {
                        continue;
                    }
            }
        } while (opcao != 4);
    }
}




