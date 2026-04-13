package aula04; 

import java.util.Scanner;

public class ExemplosVariaveis {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        float cateto1, cateto2;
        double hipotenusa; 

        System.out.print("Digite o valor do primeiro cateto: ");
       
        cateto1 = leitor.nextFloat();

        System.out.print("Digite o valor do segundo cateto: ");
        cateto2 = leitor.nextFloat();

       
        hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));

        System.out.println("A hipotenusa é: " + hipotenusa);

        leitor.close();
    }    
}