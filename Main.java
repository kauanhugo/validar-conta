import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean contaValida = false;

        while (!contaValida) {
            System.out.print("Digite o número da sua conta: ");
            String numeroConta = scanner.nextLine();

            if (validarConta(numeroConta)) {

                System.out.println("Conta válida: " + numeroConta);

                System.out.print("Digite a sua senha: ");
                String senha = scanner.nextLine();

                if (validarSenha(senha)) {
                    System.out.println("Senha válida. Bem-vindo!");
                    contaValida = true;
                } else {

                    System.out.println("Senha inválida. Tente novamente.");
                }
            } else {
                System.out.println("Conta inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    public static boolean validarConta(String numeroConta) {
        if (numeroConta.length() < 6) {
            return false;
        }
        boolean temNumero = false;

        for (char caractere : numeroConta.toCharArray()) {
            if (Character.isDigit(caractere)) {
                temNumero = true;
                break;
            }
        }
        return temNumero;
    }

    public static boolean validarSenha(String senha) {
        if (senha.length() < 8) {
            return false;
        }
        boolean temMaiuscula = false;
        boolean temMinuscula = false;
        boolean temNumero = false;

        for (char caractere : senha.toCharArray()) {
            if (Character.isUpperCase(caractere)) {
                temMaiuscula = true;
            } else if (Character.isLowerCase(caractere)) {
                temMinuscula = true;
            } else if (Character.isDigit(caractere)) {
                temNumero = true;
            }
        }
        return temMaiuscula && temMinuscula && temNumero;
    }
}
