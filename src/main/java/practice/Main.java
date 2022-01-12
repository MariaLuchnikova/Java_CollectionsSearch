package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(CoolNumbers.generateCoolNumbers());
        while (true) {
            System.out.println("Введите номер автомобиля для поиска:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("stop")) {
                break;
            }
            CoolNumbers.timeBruteSearchInList(input);
            CoolNumbers.timeBinarySearchInList(input);
            CoolNumbers.timeSearchInHashSet(input);
            CoolNumbers.timeSearchInTreeSet(input);
        }
    }
}
