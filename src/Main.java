import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.forLanguageTag("pt-BR"));

        System.out.println("----| CALCULADORA |----");

        System.out.print("Digite o operador\n+ --> ADIÇÃO\n- --> SUBTRAÇÃO\n* --> MULTIPLICAÇÃO\n/ --> DIVISÃO\n");
        System.out.print("> ");
        char op = sc.next().charAt(0);

        if (op != '+' && op != '-' && op != '*' && op != '/') {
            System.out.println("Operador inválido.");
        } else {
            double resultado = (op == '*' || op == '/') ? 1.0 : 0.0;

            System.out.println("Digite os números a cada linha, utilizando VÍRGULA para decimais, e tecle ENTER para digitar o próximo número\nQuando quiser o resultado, tecle CALCULAR.");
            System.out.print("> ");

            while (sc.hasNextDouble()) {
                System.out.print("> ");
                double numero = sc.nextDouble();
                if (op == '+') {
                    resultado += numero;
                } else if (op == '-') {
                    resultado -= numero;
                } else if (op == '*') {
                    resultado *= numero;
                } else if (op == '/') {
                    if (numero == 0) {
                        System.out.println("Erro: divisão por zero não é permitida.");
                        resultado = Double.NaN; // Marca o resultado como inválido
                        break;
                    }
                    resultado /= numero;
                }
            }

            if (!Double.isNaN(resultado)) {
                System.out.println("O resultado é " + String.valueOf(resultado).replace('.', ','));
            }
        }

        sc.close();
    }
}