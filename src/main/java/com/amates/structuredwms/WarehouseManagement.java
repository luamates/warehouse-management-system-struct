package com.amates.structuredwms;

import java.util.ArrayList;
import java.util.Scanner;

public class WarehouseManagement {

    static String[] names = new String[100];
    static int[] codes = new int[100];
    static int[] quantities = new int[100];
    static double[] prices = new double[100];
    static boolean[] isActive = new boolean[100];
    static int productsRegistered = 0;

    static ArrayList<String> changesLog = new ArrayList<>();

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
        System.out.printf("6 - Ver registro de movimentações%n");
        System.out.printf("7 - Sair%n");
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
                viewLog();
                break;
            case 7:
                return false;
            default:
                System.out.printf("%n%nOPÇÃO INVÁLIDA.%n%n");
        }
        return true;
    }

    public static void addProduct(Scanner scanner) {
        System.out.printf("%n%nCADASTRO DE PRODUTO");

        System.out.printf("%nDigite o nome do produto: ");
        names[productsRegistered] = scanner.next();

        System.out.printf("%nDigite a quantidade em estoque: ");
        quantities[productsRegistered] = scanner.nextInt();

        System.out.printf("%nDigite o preço unitário: ");
        prices[productsRegistered] = scanner.nextDouble();

        codes[productsRegistered] = productsRegistered;
        isActive[productsRegistered] = true;
        addToLog("Cadastrar produto", productsRegistered);

        System.out.printf("%n-> O produto %s, com estoque %d e preço R$%.2f foi cadastrado com o código %d%n", names[productsRegistered], quantities[productsRegistered], prices[productsRegistered], codes[productsRegistered]);
        productsRegistered++;
    }

    public static void updateQuantity(Scanner scanner) {



    }


    public static void removeProduct(Scanner scanner) {

    }

    public static void getQuantity(Scanner scanner) {

    }

    public static void getWarehouseValuation(Scanner scanner) {

    }

    public static void addToLog(String action, double value){
        changesLog.add("Ação: " + action + "| Parâmetro: " + value);
    }

    public static void viewLog() {
        System.out.printf("%n%n| MOVIMENTAÇÕES%n");

        for (int change = 0; change < changesLog.size(); change++) {
            System.out.println("| " + changesLog.get(change));
        }
    }







}
