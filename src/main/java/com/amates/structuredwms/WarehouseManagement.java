package com.amates.structuredwms;

import java.awt.*;
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
        scanner.close();
    }

    public static boolean mainMenu(Scanner scanner) {
        addToLog("Visualizar menu", 0);
        System.out.printf("%n%n===== CONTROLE DE ESTOQUE =====%n");
        System.out.printf("1 - Cadastrar produto%n");
        System.out.printf("2 - Atualizar quantidade%n");
        System.out.printf("3 - Remover produto%n");
        System.out.printf("4 - Reativar produto%n");
        System.out.printf("5 - Consultar estoque%n");
        System.out.printf("6 - Ver valor total do estoque%n");
        System.out.printf("7 - Ver registro de movimentações%n");
        System.out.printf("8 - Sair%n");
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
                deactivateProduct(scanner);
                break;
            case 4:
                activateProduct(scanner);
                break;
            case 5:
                getQuantity(scanner);
                break;
            case 6:
                getWarehouseValuation();
                break;
            case 7:
                viewLog();
                break;
            case 8:
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

        System.out.printf("%n-> O produto %s, com estoque %d e preço R$%.2f foi cadastrado com o código %d", names[productsRegistered], quantities[productsRegistered], prices[productsRegistered], codes[productsRegistered]);
        productsRegistered++;
    }

    public static void updateQuantity(Scanner scanner) {
        System.out.printf("%n%nATUALIZAR QUANTIDADE %nDigite o código do produto que deseja atualizar a quantidade em estoque: ");
        int codeToUpdateQtt = scanner.nextInt();

        if (codeToUpdateQtt < 0 || codeToUpdateQtt >= productsRegistered) {
            System.out.printf("%nCódigo inválido!%n");
            addToLog("Atualizar estoque [erro]", codeToUpdateQtt);
            return;
        }

        if (isActive[codeToUpdateQtt]) {
            System.out.printf("%nAtualmente, o produto %s tem %d unidades em estoque. %nQual deve ser a nova quantidade? ", names[codeToUpdateQtt], quantities[codeToUpdateQtt]);
            quantities[codeToUpdateQtt] = scanner.nextInt();

            System.out.printf("A quantidade do produto %s foi atualizada para %s unidades.", names[codeToUpdateQtt], quantities[codeToUpdateQtt]);
            addToLog("Atualizar estoque", codeToUpdateQtt);
        } else {
            System.out.printf("%nO produto está desativado!");
            addToLog("Atualizar estoque [erro]", codeToUpdateQtt);
        }
    }

    public static void deactivateProduct(Scanner scanner) {
        System.out.printf("%n%nREMOVER PRODUTO %nDigite o código do produto que deseja mudar o status para inativo: ");
        int codeToDeactivate = scanner.nextInt();

        if (codeToDeactivate < 0 || codeToDeactivate >= productsRegistered) {
            System.out.printf("%nCódigo inválido!%n");
            addToLog("Desativar produto [erro]", codeToDeactivate);
            return;
        }

        if (quantities[codeToDeactivate] > 0) {
            System.out.printf("%nO produto %s tem quantidade em estoque. Zere antes de remover!", names[codeToDeactivate]);
            addToLog("Desativar produto [erro]", codeToDeactivate);
        } else {
            isActive[codeToDeactivate] = false;
            System.out.printf("%nO produto %s foi desativado.", names[codeToDeactivate]);
            addToLog("Desativar produto", codeToDeactivate);
        }
    }

    public static void activateProduct(Scanner scanner) {
        System.out.printf("%n%nREATIVAR PRODUTO %nDigite o código do produto que deseja mudar o status para reativar: ");
        int codeToActivate = scanner.nextInt();

        if (codeToActivate < 0 || codeToActivate >= productsRegistered) {
            System.out.printf("%nCódigo inválido!%n");
            addToLog("Ativar produto [erro]", codeToActivate);
            return;
        }

        if (isActive[codeToActivate]) {
            System.out.printf("%nO produto %s já está ativo!", names[codeToActivate]);
            addToLog("Ativar produto [erro]", codeToActivate);
        } else {
            isActive[codeToActivate] = true;
            addToLog("Ativar produto", codeToActivate);
            System.out.printf("%nO produto %s foi reativado com sucesso!%n%nDeseja atualizar sua quantidade em estoque? %n(1 - Sim / 2 - Não): ", names[codeToActivate]);
            int updateQtt = scanner.nextInt();
            if (updateQtt == 1) {
                System.out.printf("%nInsira a nova quantidade para o produto %s: ", names[codeToActivate]);
                quantities[codeToActivate] = scanner.nextInt();
                System.out.printf("%n%nO produto %s foi definido com quantidade %d.%n", names[codeToActivate], quantities[codeToActivate]);
                addToLog("Atualizar estoque", codeToActivate);
            }
        }
    }

    public static void getQuantity(Scanner scanner) {
        System.out.printf("%n%nACESSAR QUANTIDADE EM ESTOQUE %nDigite o código do produto que deseja consultar a quantidade: ");
        int codeToGetQtt = scanner.nextInt();

        if (codeToGetQtt < 0 || codeToGetQtt >= productsRegistered) {
            System.out.printf("%nCódigo inválido!%n");
            addToLog("Ver quantidade [erro]", codeToGetQtt);
            return;
        }

        if (isActive[codeToGetQtt]) {
            System.out.printf("%nO produto %s tem quantidade %d.", names[codeToGetQtt], quantities[codeToGetQtt]);
            addToLog("Ver quantidade", codeToGetQtt);
        } else {
            System.out.printf("%nO produto está desativado!");
            addToLog("Ver quantidade [erro]", codeToGetQtt);
        }
    }

    public static void getWarehouseValuation() {
        double valuation = 0;

        for (int product = 0; product < productsRegistered; product++) {
            valuation += prices[product] * quantities[product];
        }

        System.out.printf("%n%nVALOR TOTAL DO ESTOQUE %nO armazém vale R$%.2f.", valuation);
        addToLog("Gerar valuation", valuation);
    }

    public static void addToLog(String action, double value) {
        changesLog.add("Ação: " + action + "| Parâmetro: " + value);
    }

    public static void viewLog() {
        System.out.printf("%n%n| MOVIMENTAÇÕES%n");

        for (String s : changesLog) {
            System.out.println("| " + s);
        }
    }
}
