import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        boolean flag = true;
        MySet set = null;
        int size = 0;
        while (set == null) {
            switch (showStartMenu()) {
                case 1:     // 1. Create empty set
                    set = new MySet();
                    break;
                case 2:     // 2. Create a set with one vegetable
                    set = new MySet(inputVegetable());
                    break;
                case 3:     // 3. Create a set with a few vegetables
                    set = new MySet(createFewVegetables());
                    break;
                default:
                    System.out.println("Incorrect choose, try again");
            }
        }
        while (flag) {

            switch (showMenu()) {
                case 1:     // 1. Show set
                    System.out.println(set);
                    System.in.read();
                    break;
                case 2:     // 2. Set size
                    System.out.println(set.size());
                    System.in.read();
                    break;
                case 3:     // 3. Add vegetable
                    set.add(inputVegetable());
                    break;
                case 4:     // 4. Add a few vegetables
                    set.addAll(createFewVegetables());
                    break;
                case 5:     // 5. Remove vegetable
                    set.remove(inputVegetable());
                    break;
                case 6:     // 6. Remove a few vegetables
                    set.removeAll(createFewVegetables());
                    break;
                case 7:     // 7. Retain all
                    set.retainAll(createFewVegetables());
                    break;
                case 8:     // 8. Contains
                    System.out.println(set.contains(inputVegetable()));
                    System.in.read();
                    break;
                case 9:     // 9. ContainsAll
                    System.out.println(set.containsAll(createFewVegetables()));
                    System.in.read();
                    break;
                case 0:     // 0. Exit
                    System.exit(0);
                    break;
            }
        }

    }

    private static int showStartMenu() {
        System.out.println("1. Create empty set");
        System.out.println("2. Create a set with one vegetable");
        System.out.println("3. Create a set with a few vegetables");
        return in.nextInt();
    }

    private static int showMenu() {
        //Меню
        System.out.println("1. Show set");
        System.out.println("2. Set size");
        System.out.println("3. Add vegetable");
        System.out.println("4. Add a few vegetables");
        System.out.println("5. Remove vegetable");
        System.out.println("6. Remove a few vegetables");
        System.out.println("7. Retain all");
        System.out.println("8. Contains");
        System.out.println("9. Contains all");
        System.out.println("0. Exit");
        return in.nextInt();
    }

    private static Vegetable inputVegetable() {
        System.out.println("Choose vegetable");
        System.out.println("1. Tomato");
        System.out.println("2. Cucumber");
        System.out.println("3. Onion");
        System.out.println("4. Cabbage");
        System.out.println("0. Cancel");
        while (true) {
            switch (in.nextInt()) {
                case 1:
                    return new Tomato();
                case 2:
                    return new Cucumber();
                case 3:
                    return new Onion();
                case 4:
                    return new Cabbage();
                case 0:
                    return null;
                default:
                    System.out.println("Incorrect choose, try again");
            }
        }
    }

    private static ArrayList<Vegetable> createFewVegetables() {
        System.out.print("Enter size: ");
        int size = in.nextInt();
        if (size <= 0) {
            System.out.println("Incorrect size");
        }
        System.out.println("Random?(y/n)");
        if (in.next().equals("y"))
            return randomVegetablesArr(size);
        else
            return inputFewVegetables(size);
    }

    private static ArrayList<Vegetable> inputFewVegetables(int size) {
        ArrayList<Vegetable> veg = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            veg.add(inputVegetable());
        return veg;
    }

    private static ArrayList<Vegetable> randomVegetablesArr(int size) {
        ArrayList<Vegetable> vegetables = new ArrayList<Vegetable>(size);
        Random rand = new Random();
        for (int i = 0; i < size; i++)
            switch (rand.nextInt(4)) {
                case 0:
                    vegetables.add(new Tomato());
                    break;
                case 1:
                    vegetables.add(new Cucumber());
                    break;
                case 2:
                    vegetables.add(new Onion());
                    break;
                case 3:
                    vegetables.add(new Cabbage());
                    break;
            }
        return vegetables;
    }
}
