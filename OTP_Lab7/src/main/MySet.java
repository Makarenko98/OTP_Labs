package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Makarenko on 23.04.2017.
 */
public class MySet implements Set<Vegetable> {
    private Vegetable[] vegetables;
    private int count = 0;
    private int initialSize = 10;
    private float stepSize = 1.5f;

    public MySet() {
        vegetables = new Vegetable[initialSize];
    }

    public MySet(Vegetable vegetable) throws MyException {
        if(vegetable == null)
            throw new MyException("vegetable should not be null");
        vegetables = new Vegetable[initialSize];
        vegetables[0] = vegetable;
        count++;
    }

    public MySet(Collection<Vegetable> collection) throws MyException {
        if (collection == null || collection.size() == 0)
            throw new MyException("Collection should not be empty");
        vegetables = new Vegetable[collection.size()];
        collection.toArray(vegetables);
        count = collection.size();
    }

    public MySet(Vegetable[] vegs) throws MyException {
        if (vegs == null || vegs.length == 0)
            throw new MyException("Collection should not be empty");
        this.vegetables = vegs.clone();
        count = vegs.length;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = false;
        for (int i = 0; i < count; i++)
            if (this.vegetables[i].equals(o)) {
                flag = true;
                break;
            }
        return flag;
    }

    @Override
    public Iterator<Vegetable> iterator() {
        return new Iterator<Vegetable>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < count && vegetables[currentIndex] != null;
            }

            @Override
            public Vegetable next() {
                return vegetables[currentIndex++];
            }
        };
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(vegetables, count);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(vegetables, count, a.getClass());
    }

    @Override
    public boolean add(Vegetable vegetable) {
        if (vegetable == null)
            return false;
        if (vegetables.length == this.count) {
            Vegetable[] temp = vegetables.clone();
            vegetables = new Vegetable[(int) (count * stepSize)];
            for (int i = 0; i < count; i++)
                vegetables[i] = temp[i];
        }
        vegetables[count] = vegetable;
        count++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (!this.contains(o))
            return false;
        for (int i = 0; i < count; i++)
            if (vegetables[i].equals(o)) {
                for (int j = i; j < count - 1; j++)
                    vegetables[j] = vegetables[j + 1];
                vegetables[count - 1] = null;
                break;
            }
        count--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null || c.size() == 0)
            return false;
        Iterator<?> iter = c.iterator();
        while (iter.hasNext())
            if (!this.contains(iter.next()))
                return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Vegetable> c) {
        if (c == null || c.size() == 0)
            return false;
        if (this.vegetables.length <= this.count + c.size()) {
            Vegetable[] temp = this.vegetables.clone();
            this.vegetables = new Vegetable[(int) (count * stepSize) + c.size()];
            for (int i = 0; i < count; i++)
                this.vegetables[i] = temp[i];
        }
        Iterator<Vegetable> iter = (Iterator<Vegetable>) c.iterator();
        while (iter.hasNext())
            vegetables[count++] = iter.next();
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null || c.size() == 0)
            return false;
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (!c.contains(vegetables[i])) {
                this.remove(vegetables[i]);
                i--;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c == null || c.size() == 0)
            return false;
        boolean flag = false;
        for (int i = 0; i < count; i++) {
            if (c.contains(vegetables[i])) {
                this.remove(vegetables[i]);
                i--;
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void clear() {
        vegetables = new Vegetable[initialSize];
        count = 0;
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
}
