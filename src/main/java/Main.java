/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


import java.util.Scanner;

/**
 *
 * @author Laboratório
 */
class ContaBancaria {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public ContaBancaria(String nome, String sobrenome, String cpf, double saldoInicial) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.saldo = saldoInicial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor){
        if (valor > 0){
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");            
        }
        else{
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar (double valor){
        if (valor > 0 && valor <= saldo){
            saldo -= valor;
            System.out.println("Sque realizado com sucesso!");
        }
        else{
            System.out.println("Saldo insuficiente!");
        }
    }

    public void consultaSaldo(){
        System.out.println("Titular: "+ getNome()+" "+getSobrenome());
        System.out.println("\nSaldo: "+ getSaldo());
    }   

}

public class GerenciaBanco {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Insira o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Insira o sobrenome do cliente: ");
        String sobrenome = scanner.nextLine();

        System.out.println("Insira o CPF do usuário: ");
        String cpf = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(nome, sobrenome, cpf, 0.0);
        exibirMenu(scanner, conta);
    }
    public static void exibirMenu (Scanner scanner, ContaBancaria conta){
        int opcao;
        do{
            System.out.println("\n#### Menu Banco ####");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Digite o valor do depósito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 2:
                    System.out.println("Insira o valor do saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 3:
                    System.out.println("Consultando saldo...");
                    conta.consultaSaldo();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Saindo...");
                    break;
            }

        }while (opcao !=4);
    }
}
