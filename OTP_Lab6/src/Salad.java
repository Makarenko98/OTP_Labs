/**
 * Created by Makarenko on 23.04.2017.
 */
public class Salad {
    private int count;
    private Vegetable[] vegetables;

    public Salad() {
        vegetables = new Vegetable[5];
    }

    public Salad(Vegetable[] vegetables) {
        count = vegetables.length;
        this.vegetables = vegetables;
    }

    public int getCount() {
        return count;
    }

    public boolean addVegetable(Vegetable vegetable) {
        if (vegetable == null)
            return false;
        if (vegetables.length == this.count) {
            Vegetable[] temp = vegetables.clone();
            vegetables = new Vegetable[count * 2];
            for (int i = 0; i < count; i++)
                vegetables[i] = temp[i];
        }
        vegetables[count] = vegetable;
        count++;
        return true;
    }

    public Salad sortByCalories() {
        boolean swapped = true;
        int z = 0;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < count - 1 - z; i++) {
                if (vegetables[i].getCalories() > vegetables[i + 1].getCalories()) {
                    Vegetable a = vegetables[i];
                    vegetables[i] = vegetables[i + 1];
                    vegetables[i + 1] = a;
                    swapped = true;
                }
            }
            z++;
        }
        return this;
    }

    public Salad sortByName() {
        boolean swapped = true;
        int z = 0;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < count - 1 - z; i++) {
                if (vegetables[i].getName().compareTo(vegetables[i + 1].getName()) > 0) {
                    Vegetable a = vegetables[i];
                    vegetables[i] = vegetables[i + 1];
                    vegetables[i + 1] = a;
                    swapped = true;
                }
            }
            z++;
        }
        return this;
    }

    @Override
    public String toString() {
        String str = new String();
        String vegetable;
        int n = 0;
        for (int i = 0; i < count; i++) {
            vegetable = vegetables[i].toString();
            if (!str.contains(vegetables[i].toString())) {
                n = 0;
                str += vegetable;
                for (int j = 0; j < count; j++) {
                    if (vegetable.equals(vegetables[j].toString()))
                        n++;
                }
                str += " x" + n + "\n";
            }
        }
        return str;
    }

    public boolean append(Vegetable[] vegetables) {
        if (vegetables == null)
            return false;
        if (this.vegetables.length <= this.count + vegetables.length) {
            Vegetable[] temp = this.vegetables.clone();
            this.vegetables = new Vegetable[count * 2 + vegetables.length];
            for (int i = 0; i < count; i++)
                this.vegetables[i] = temp[i];
        }
        for (int i = 0; i < vegetables.length; i++)
            this.vegetables[i + count] = vegetables[i];
        count += vegetables.length;
        return true;
    }

    public boolean append(Salad salad) {
        return append(salad.vegetables);
    }

    public Vegetable searchVegetable(int minCalories, int maxCalories) {
        Vegetable vegetable = null;
        Vegetable temp = null;
        for (int i = 0; i < count; i++) {
            temp = vegetables[i];
            if (temp.getCalories() > minCalories && temp.getCalories() < maxCalories) {
                vegetable = temp;
                break;
            }
        }
        return vegetable;
    }
}
