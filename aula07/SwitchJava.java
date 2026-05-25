package aula07;

public class SwitchJava {
    public static void main(String[] args) {

        // Break - interrompe o loop quando i == 4
        for (int i = 0; i < 10; i++) {
            if (i == 4) break;
            System.out.println(i);
        }

        // Continue - pula o 4 e continua
        for (int i = 0; i < 10; i++) {
            if (i == 4) continue;
            System.out.println(i);
        }

        // For loop até 5
        for (int i = 0; i <= 5; i++) {
            System.out.println(i);
        }

        // Números pares entre 0 e 10
        for (int i = 0; i <= 10; i = i + 2) {
            System.out.println(i);
        }

        // Soma de 1 a 5
        int num = 0;
        for (int i = 1; i <= 5; i++) {
            num = num + i;
        }
        System.out.println("Soma é igual a: " + num);

        // Switch - pedido
        int pedido = 3;
        switch (pedido) {
            case 1:  System.out.println("Seu pedido é: Hamburguer."); break;
            case 2:  System.out.println("Seu pedido é: Pizza.");      break;
            case 3:  System.out.println("Seu pedido é: Macarrão.");   break;
            case 4:  System.out.println("Seu pedido é: Torta.");      break;
            default: System.out.println("Você não fez um pedido.");
        }

        // While - contagem regressiva
        int contagem = 3;
        while (contagem > 0) {
            System.out.println(contagem);
            contagem--;
        }
        System.out.println("Feliz Ano Novo!");

        // Arrays
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        cars[0] = "Ferrari";
        System.out.println(cars[0]);
    }
}
