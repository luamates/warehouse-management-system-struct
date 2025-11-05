package com.amates.structuredwms;

import java.util.Scanner;

public class WarehouseManagement {

    static String[] names;
    static int[] codes;
    static int[] quantities;
    static double prices;
    static boolean status;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueSystem = true;

        while (continueSystem) {
            continueSystem = mainMenu(scanner);


        }


    }

    public static boolean mainMenu(Scanner scanner) {
        System.out.printf("%n%n===== CONTROLE DE ESTOQUE =====%n");
        System.out.printf("1 - Cadastrar produto%n");
        System.out.printf("2 - Atualizar quantidade%n");
        System.out.printf("3 - Remover produto%n");
        System.out.printf("4 - Consultar estoque%n");
        System.out.printf("5 - Ver valor total do estoque%n");
        System.out.printf("6 - Sair%n");
        System.out.println("Escolha uma opção: ");

        int userInput = scanner.nextInt();
        switch (userInput) {
            case 1:
                addProduct(scanner);
                break;
            case 2:
                updateQuantity(scanner);
                break;
            case 3:
                removeProduct(scanner);
                break;
            case 4:
                getQuantity(scanner);
                break;
            case 5:
                getWarehouseValuation(scanner);
                break;
            case 6:
                return false;
            default:
                System.out.printf("%n%nOPÇÃO INVÁLIDA.%n%n");
        }
        return true;
    }





    public static void addProduct(Scanner scanner) {

    }

    public static void updateQuantity(Scanner scanner) {

    }


    public static void removeProduct(Scanner scanner) {

    }

    public static void getQuantity(Scanner scanner) {

    }

    public static void getWarehouseValuation(Scanner scanner) {

    }


}
