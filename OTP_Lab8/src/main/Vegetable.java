package main;

import java.io.Serializable;

/**
 * Created by Makarenko on 23.04.2017.
 */
public abstract class Vegetable implements Serializable {
    private String name;
    private int calories;

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    protected void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return name + " " + calories + "Kcal";
    }

    @Override
    public boolean equals(Object obj) {
        return this.calories == ((Vegetable)obj).calories && this.name.equals(((Vegetable)obj).name);
    }
}
