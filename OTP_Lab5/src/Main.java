import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        int cucumberCount, tomatoCount, onionCount, cabbageCount;
        int key;
        int c1, c2;
        //Введення кількості овочів
        System.out.println("Enter number of vegetables:");
        System.out.println("Cucumbers:");
        cucumberCount = in.nextInt();
        System.out.println("Tomatoes:");
        tomatoCount = in.nextInt();
        System.out.println("Onions:");
        onionCount = in.nextInt();
        System.out.println("Cabbage:");
        cabbageCount = in.nextInt();
        Salad salad = new Salad(createVegetables(cucumberCount,tomatoCount,cabbageCount,onionCount));
        while (flag) {
            ShowMenu();
            //вибір пункту меню
            key = in.nextInt();
            switch (key) {
                case 1:
                    salad.sortByCalories(); //сортування за калорійністю
                    break;
                case 2:
                    salad.sortByName(); //сортування за назвою
                    break;
                case 3:
                    System.out.println("Enter the borders");
                    //Введення меж калорійності для пошуку
                    c1 = in.nextInt();
                    c2 = in.nextInt();
                    Vegetable veg = salad.searchVegetable(c1, c2);
                    System.out.println(veg!=null?veg:"not found"); //виведення результатів пошуку
                    break;
                case 4:
                    System.out.println(salad); //виведення салату
                    System.in.read();
                    break;
                case 5:
                    flag = false; //припинення циклу
                    break;
            }
//            System.in.read();
        }

    }

    public static void ShowMenu() {
        //Меню
        System.out.println("1. Sort by calorific");
        System.out.println("2. Sort by name vegetables");
        System.out.println("3. Search by Calorific");
        System.out.println("4. Show salad");
        System.out.println("5. Exit");
    }

    public static Vegetable[] createVegetables(int cucumberCount, int tomatoCount, int cabbageCount, int onionCount) {
        int num = cucumberCount + tomatoCount + cabbageCount + onionCount;
        Vegetable[] vegetables = new Vegetable[num];
        int n0 = 0, i = 0;
        for (i = 0; i < cucumberCount; i++)
            vegetables[i] = new Cucumber();
        n0 += cucumberCount;

        for (i = n0; i < tomatoCount + n0; i++)
            vegetables[i] = new Tomato();
        n0 += tomatoCount;

        for (i = n0; i < cabbageCount + n0; i++)
            vegetables[i] = new Cabbage();
        n0 += cabbageCount;

        for (i = n0; i < onionCount + n0; i++)
            vegetables[i] = new Onion();
        n0 += onionCount;
        return vegetables;
    }
}
