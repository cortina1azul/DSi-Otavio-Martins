package exercicios;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Exercicios {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== LISTA DE EXERCÍCIOS DO JOÃO =====");
        System.out.println("Qual exercício deseja executar? (1, 2 ou 3):");
        int Escolha = sc.nextInt();
        sc.nextLine();

        if (Escolha == 1) {
            exercicio01(sc);
        } else if (Escolha == 2) {
            exercicio02(sc);
        } else if (Escolha == 3) {
            exercicio03(sc);
        } else {
            System.out.println("Opção inválida!");
        }

        sc.close();
    }

    static void exercicio01(Scanner sc) {
        System.out.println("\n===== EXERCÍCIO 01 - SALÁRIO =====");

        System.out.println("Digite seu nome:");
        String Nome = sc.nextLine();

        System.out.println("Digite o número de horas trabalhadas por dia:");
        int HorasPorDia = sc.nextInt();

        System.out.println("Digite o valor que recebe por hora:");
        double ValorPorHora = sc.nextDouble();

        System.out.println("Digite o número de filhos com idade inferior a 14 anos:");
        int QuantidadeDeFilhos = sc.nextInt();

        System.out.println("Digite sua idade:");
        int Idade = sc.nextInt();

        sc.nextLine();
        System.out.println("Digite a data que começou a trabalhar (ANO-MES-DIA):");
        String DataString = sc.nextLine();
        LocalDate Data = LocalDate.parse(DataString);
        LocalDate Hoje = LocalDate.now();
        long Dias = ChronoUnit.DAYS.between(Data, Hoje) + 1;
        double AnosTrabalhados = Dias / 365.0;

        System.out.println("Digite o salário família por filho:");
        double SalarioFamiliaPorFilho = sc.nextDouble();
        sc.nextLine();

        double SalarioBruto = ValorPorHora * HorasPorDia * 22;
        double SalarioFamiliaTotal = SalarioFamiliaPorFilho * QuantidadeDeFilhos;

        double DescontoINPS = SalarioBruto * 0.085;

        double IR = 0;
        if (SalarioBruto > 1500) {
            IR = SalarioBruto * 0.15;
        } else if (SalarioBruto > 500) {
            IR = SalarioBruto * 0.08;
        } else {
            System.out.println("Você não precisa declarar imposto de renda!");
        }

        double ADIC = 0;
        if (Idade > 40) {
            ADIC = SalarioBruto * 0.02;
            System.out.println("Bônus de 2% por ter mais de 40 anos: R$ " + String.format("%.2f", ADIC));
        } else if (AnosTrabalhados > 15) {
            ADIC = SalarioBruto * 0.035;
            System.out.println("Bônus de 3,5% por mais de 15 anos de serviço: R$ " + String.format("%.2f", ADIC));
        } else if (AnosTrabalhados > 5 && Idade > 30) {
            ADIC = SalarioBruto * 0.015;
            System.out.println("Bônus de 1,5% por mais de 5 anos e mais de 30 anos: R$ " + String.format("%.2f", ADIC));
        }

        double TotalDescontos = DescontoINPS + IR;
        double SalarioLiquido = SalarioBruto - TotalDescontos + ADIC + SalarioFamiliaTotal;

        System.out.println("\n===== RESUMO - " + Nome + " =====");
        System.out.println("Salário Bruto:        R$ " + String.format("%.2f", SalarioBruto));
        System.out.println("Desconto INPS (8,5%): R$ " + String.format("%.2f", DescontoINPS));
        System.out.println("Imposto de Renda:     R$ " + String.format("%.2f", IR));
        System.out.println("Total de Descontos:   R$ " + String.format("%.2f", TotalDescontos));
        System.out.println("Adicional:            R$ " + String.format("%.2f", ADIC));
        System.out.println("Salário Família:      R$ " + String.format("%.2f", SalarioFamiliaTotal));
        System.out.println("Salário Líquido:      R$ " + String.format("%.2f", SalarioLiquido));
    }

    static void exercicio02(Scanner sc) {
        System.out.println("\n===== EXERCÍCIO 02 - BÔNUS DE NATAL =====");

        System.out.println("Digite o código do funcionário:");
        int CodigoFuncionario = sc.nextInt();

        sc.nextLine();
        System.out.println("Digite o sexo do funcionário (M/F):");
        String Sexo = sc.nextLine().trim().toUpperCase();

        System.out.println("Digite o tempo de trabalho (em anos):");
        int TempoDeTrabalho = sc.nextInt();

        System.out.println("Digite o salário do funcionário:");
        double Salario = sc.nextDouble();
        sc.nextLine();

        double Bonus = 0;
        if (Sexo.equals("M") && TempoDeTrabalho > 15) {
            Bonus = Salario * 0.20;
            System.out.println("Funcionário masculino com mais de 15 anos de casa: bônus de 20%.");
        } else if (Sexo.equals("F") && TempoDeTrabalho > 10) {
            Bonus = Salario * 0.25;
            System.out.println("Funcionária com mais de 10 anos de casa: bônus de 25%.");
        } else {
            Bonus = 100;
            System.out.println("Bônus padrão de Natal.");
        }

        System.out.println("\n===== BÔNUS DE NATAL =====");
        System.out.println("Código do Funcionário: " + CodigoFuncionario);
        System.out.println("Salário:               R$ " + String.format("%.2f", Salario));
        System.out.println("Bônus de Natal:        R$ " + String.format("%.2f", Bonus));
    }

    static void exercicio03(Scanner sc) {
        System.out.println("\n===== EXERCÍCIO 03 - TRIÂNGULO =====");

        System.out.println("Digite o lado A:");
        double LadoA = sc.nextDouble();

        System.out.println("Digite o lado B:");
        double LadoB = sc.nextDouble();

        System.out.println("Digite o lado C:");
        double LadoC = sc.nextDouble();
        sc.nextLine();

        double Temp;
        if (LadoA < LadoB) { Temp = LadoA; LadoA = LadoB; LadoB = Temp; }
        if (LadoA < LadoC) { Temp = LadoA; LadoA = LadoC; LadoC = Temp; }
        if (LadoB < LadoC) { Temp = LadoB; LadoB = LadoC; LadoC = Temp; }

        System.out.println("\nLados em ordem decrescente: " + LadoA + ", " + LadoB + ", " + LadoC);
        System.out.println("O maior lado é: " + LadoA);

        if (LadoA > LadoB + LadoC) {
            System.out.println("Esses lados NÃO formam triângulo algum.");
        } else {
            double A2 = LadoA * LadoA;
            double B2 = LadoB * LadoB;
            double C2 = LadoC * LadoC;

            if (A2 == B2 + C2) {
                System.out.println("Formam um triângulo RETÂNGULO.");
            } else if (A2 > B2 + C2) {
                System.out.println("Formam um triângulo OBTUSÂNGULO.");
            } else {
                System.out.println("Formam um triângulo ACUTÂNGULO.");
            }

            if (LadoA == LadoB && LadoB == LadoC) {
                System.out.println("E também é um triângulo EQUILÁTERO.");
            } else if (LadoA == LadoB || LadoB == LadoC || LadoA == LadoC) {
                System.out.println("E também é um triângulo ISÓSCELES.");
            } else {
                System.out.println("E também é um triângulo ESCALENO.");
            }
        }
    }
}
