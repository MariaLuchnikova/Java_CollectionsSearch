package practice;

import java.util.*;

public class CoolNumbers {
    public static List<String> arrayList = new ArrayList<>();

    public static List<String> generateCoolNumbers() {
        String letters = "АВЕКМНОРСТУХ";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < 2000000) {
            int firstIndexLetter = random.nextInt(letters.length());
            String digits = String.valueOf((int) (Math.random() * 9) + 1).repeat(3);
            int secondIndexLetter = random.nextInt(letters.length());
            int thirdIndexLetter = random.nextInt(letters.length());
            String digitRegionCode = String.valueOf((int) (Math.random() * 199) + 1);
            String regionCode = (digitRegionCode.length() == 1 ? "0" + digitRegionCode : digitRegionCode);

            String numberCar = stringBuilder
                    .append(letters.charAt(firstIndexLetter))
                    .append(digits)
                    .append(letters.charAt(secondIndexLetter))
                    .append(letters.charAt(thirdIndexLetter))
                    .append(regionCode).toString();
            arrayList.add(numberCar);
            stringBuilder.delete(0, numberCar.length());
            i++;
        }
        return arrayList;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return list.contains(number);
    }

    public static void timeBruteSearchInList(String number) {
        long start = System.nanoTime();
        String searching = (bruteForceSearchInList(arrayList, number) ? "найден" : "не найден");
        long finish = System.nanoTime() - start;
        System.out.println("Поиск перебором: номер " + searching + ", поиск занял " + finish + "нс");
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        if (Collections.binarySearch(sortedList, number) >= 0)
            return true;
        else return false;
    }

    public static void timeBinarySearchInList(String number) {
        Collections.sort(arrayList);
        long start = System.nanoTime();
        String searching = binarySearchInList(arrayList, number) ? "найден" : "не найден";
        long finish = System.nanoTime() - start;
        System.out.println("Бинарный поиск: номер " + searching + ", поиск занял " + finish + "нс");
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        return hashSet.contains(number);
    }

    public static void timeSearchInHashSet(String number) {
        HashSet hashSet = new HashSet<>(arrayList);
        long start = System.nanoTime();
        String searching = searchInHashSet(hashSet, number) ? "найден" : "не найден";
        long finish = System.nanoTime() - start;
        System.out.println("Поиск в HashSet: номер " + searching + ", поиск занял " + finish + "нс");
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }

    public static void timeSearchInTreeSet(String number) {
        TreeSet treeSet = new TreeSet(arrayList);
        long start = System.nanoTime();
        String searching = searchInTreeSet(treeSet, number) ? "найден" : "не найден";
        long finish = System.nanoTime() - start;
        System.out.println("Поиск в TreeSet: номер " + searching + ", поиск занял " + finish + "нс");
    }
}
