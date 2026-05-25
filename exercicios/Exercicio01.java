package exercicios;

import java.util.Scanner;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Exercicio01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome:");
        String Nome = sc.nextLine();

        System.out.println("Digite o número de horas trabalhadas por dia:");
        int HorasPorDia = sc.nextInt();

        System.out.println("Digite o valor que recebe por hora:");
        double ValorPorHora = sc.nextDouble();

        System.out.println("Digite o número de filhos que você tem com idade inferior a 14 anos:");
        int QuantidadeDeFilhos = sc.nextInt();

        System.out.println("Digite sua idade:");
        int Idade = sc.nextInt();

        
        sc.nextLine(); // Limpa o Scanner

        System.out.println("Digite a data que começou a trabalhar (ANO-MES-DIA):");
        String DataNaoCoisada = sc.nextLine();
        LocalDate Data = LocalDate.parse(DataNaoCoisada);

        LocalDate Hoje = LocalDate.now();
        long Dias = ChronoUnit.DAYS.between(Data, Hoje);

        Dias = Dias + 1;
        double AnosTrabalhados = Dias / 365.0;
        
        System.out.println("Digite o salario da sua familia (depreze seu salario):");
        double SalarioFamilia = sc.nextDouble();


        //Estou considerando uma escala de trabalho 5x2, e 22 dias trabalhados no mês

        double SalarioBruto = ValorPorHora * HorasPorDia * 22;

        System.out.println("Seu salario bruto é de " + SalarioBruto);
        double salarioLiquido = SalarioBruto - (SalarioBruto * 0.085);

        System.out.println("Com o desconto do INPS (8,5%) seu salário é de " + salarioLiquido);

        if (1500 > SalarioBruto && SalarioBruto > 500 ) {
            double IR = SalarioBruto - (SalarioBruto * 0.008);
            System.out.println("Seu imposto de renda a ser declarado é de" + IR);
            SalarioBruto = SalarioBruto - IR;
        };

        if (1500 < SalarioBruto ) {
            double IR = SalarioBruto - (SalarioBruto * 0.015);
            System.out.println("Seu imposto de renda a ser declarado é de" + IR);
            SalarioBruto = SalarioBruto - IR;
        };

        if (500 > SalarioBruto ) {
            System.out.println("Você não precisa declarar imposto de renda! (mas sonegar é sempre uma opção)");
        };


        if ( Idade > 40 ) {
            double GanhoDeADIC = SalarioBruto + (SalarioBruto * 0.002);
            System.out.println("Você ganhou um bonûs de 2% sobre seu salário bruto por ter mais de 40 anos, totalizando " + GanhoDeADIC );
            SalarioBruto = SalarioBruto + GanhoDeADIC;
        };

        if (AnosTrabalhados > 15 ) {
            double Bonus = SalarioBruto + (SalarioBruto * 0.0035);
            System.out.println("Você ganhou um bonus de 3,5% sobre seu salário bruto por trabalhar por mais de 15 anos, totalizando" + SalarioBruto + Bonus);
            SalarioBruto = SalarioBruto + Bonus;
        };

        if ( AnosTrabalhados <= 15 && AnosTrabalhados > 5 ) {
            double Bonus = SalarioBruto + (SalarioBruto * 0.0015);
            System.out.println("Você ganhou um bonus de 1,5% sobre seu salário bruto por trabalhar por mais de 5 anos, totalizando" + SalarioBruto + Bonus);
            SalarioBruto = SalarioBruto + Bonus;
        };



        
        System.out.println("Parabéns " + Nome + ", seu salário líquido é de " + SalarioBruto);


        


        
    }
}
