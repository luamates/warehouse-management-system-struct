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


        mainMenu(scanner);


    }

    public static void mainMenu(Scanner scanner) {

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



        }

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
