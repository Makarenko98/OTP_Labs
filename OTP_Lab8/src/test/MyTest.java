package test;

import main.*;
import org.junit.Test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Makarenko on 25.04.2017.
 */
public class MyTest {
    @Test
    public void testConstructorWithoutParameters() {
        MySet set = new MySet();
    }

    @Test(expected = MyException.class)
    public void testConstructorWithVegetable() throws MyException {
        Vegetable veg = null;
        MySet set = new MySet(veg);
    }

    @Test(expected = MyException.class)
    public void testConstructorWithVegetables() throws MyException {
        ArrayList<Vegetable> veg = null;
        MySet set = new MySet(veg);
    }

    @Test(expected = MyException.class)
    public void testConstructorWithVegetables1() throws MyException {
        ArrayList<Vegetable> veg = new ArrayList<Vegetable>();
        MySet set = new MySet(veg);
    }

    @Test(expected = MyException.class)
    public void testConstructorWithVegetablesArray() throws MyException {
        Vegetable[] veg = null;
        MySet set = new MySet(veg);
    }

    @Test(expected = MyException.class)
    public void testConstructorWithVegetablesArray1() throws MyException {
        Vegetable[] veg = new Vegetable[0];
        MySet set = new MySet(veg);
    }

    @Test
    public void testSize() throws MyException {
        ArrayList<Vegetable> list = new ArrayList<Vegetable>();
        MySet set = new MySet();
        assertEquals("size() error", 0, set.size());
        list.add(new Tomato());
        list.add(new Tomato());
        set.addAll(list);
        assertEquals("size() error", 2, set.size());
    }

    @Test
    public void testAdd() {
        MySet set = new MySet();
        assertEquals("set.add(null)!=false", false, set.add(null));
        assertEquals("set.add(new main.Tomato())!=true", true, set.add(new Tomato()));
    }

    @Test
    public void testAddAll() {
        MySet set = new MySet();
        ArrayList<Vegetable> list = new ArrayList<Vegetable>();
        assertEquals("addAll(empty list)!=false", false, set.addAll(list));
        list.add(new Tomato());
        list.add(new Cucumber());
        assertEquals("addAll(list(size = 2))!=true", true, set.addAll(list));
        assertEquals("addAll(list(size = 2)) => size()!= 2 ", 2, set.size());
    }

    @Test
    public void testContains() {
        MySet set = new MySet();
        assertEquals("emptySet.contains(new main.Tomato)!=false", false, set.contains(new Tomato()));
        Tomato tomato = new Tomato();
        set.add(tomato);
        assertEquals("set.contains(new main.Tomato)!=true", true, set.contains(tomato));
    }

    @Test
    public void testContainsAll() {
        MySet set = new MySet();
        ArrayList<Vegetable> list = new ArrayList<Vegetable>();
        list.add(new Tomato());
        list.add(new Tomato());
        list.add(new Cucumber());
        list.add(new Cabbage());
        set.add(new Tomato());
        assertEquals("contains all error", false, set.containsAll(list));
        set.addAll(list);
        assertEquals("contains all error", true, set.containsAll(list));
    }

    @Test
    public void testRemove() {
        ArrayList<Vegetable> list = new ArrayList<Vegetable>();
        list.add(new Tomato());
        list.add(new Cucumber());
        list.add(new Onion());
        list.add(new Cabbage());
        MySet set = new MySet();
        set.addAll(list);
        assertEquals("remove error", true, set.containsAll(list));
        set.remove(list.get(0));
        assertEquals("remove contains error", 3, set.size());
        assertEquals("remove size error", false, set.containsAll(list));
        assertEquals("remove size error", false, set.contains(list.get(0)));
    }

    @Test
    public void testRemoveAll() {
        ArrayList<Vegetable> list = new ArrayList<Vegetable>();
        list.add(new Tomato());
        list.add(new Cucumber());
        list.add(new Onion());
        list.add(new Cabbage());
        ArrayList<Vegetable> list1 = new ArrayList<Vegetable>();
        list1.add(list.get(0));
        list1.add(list.get(1));
        MySet set = new MySet();
        set.addAll(list);
        set.removeAll(list1);
        assertEquals("removeAll contains error", false, set.containsAll(list1));
        assertEquals("removeAll contains error", false, set.containsAll(list));
        assertEquals("removeAll size error", 2, set.size());
    }

    @Test
    public void testRetainAll() {
        ArrayList<Vegetable> list = new ArrayList<Vegetable>();
        list.add(new Tomato());
        list.add(new Cucumber());
        list.add(new Onion());
        list.add(new Cabbage());
        ArrayList<Vegetable> list1 = new ArrayList<Vegetable>();
        list1.add(list.get(0));
        list1.add(list.get(1));
        MySet set = new MySet();
        set.addAll(list);
        list.removeAll(list1);
        set.retainAll(list1);
        assertEquals("removeAll contains error", true, set.containsAll(list1));
        assertEquals("removeAll contains error", false, set.containsAll(list));
        assertEquals("removeAll size error", 2, set.size());
    }

    @Test
    public void testClear() {
        ArrayList<Vegetable> list = new ArrayList<Vegetable>();
        list.add(new Tomato());
        list.add(new Cucumber());
        list.add(new Onion());
        list.add(new Cabbage());
        MySet set = new MySet();
        set.addAll(list);
        set.clear();
        assertEquals("clear size error", 0, set.size());
    }

    @Test
    public void testMySetIOasSingleObject() throws IOException, ClassNotFoundException {
        MySetIO mySetIO = new MySetIO();
        MySet set = new MySet();
        set.add(new Tomato());
        set.add(new Cucumber());
        set.add(new Onion());
        set.add(new Cabbage());
        mySetIO.writeAsSingleObject(set, "file.bin");
        MySet set1 = mySetIO.readAsSingleObject("file.bin");
        assertEquals("read/write error",true, set.containsAll(set1));
        assertEquals("read/write error",set.size(), set1.size());
    }

    @Test
    public void testMySetIOsequenseOfObject() throws IOException, ClassNotFoundException {
        MySetIO mySetIO = new MySetIO();
        MySet set = new MySet();
        set.add(new Tomato());
        set.add(new Cucumber());
        set.add(new Onion());
        set.add(new Cabbage());
        mySetIO.writeAsSequenceOfObjects(set, "file.bin");
        MySet set1 = mySetIO.readAsSequenceOfObjects("file.bin");
        assertEquals("read/write error",true, set.containsAll(set1));
        assertEquals("read/write error",set.size(), set1.size());
    }

    @Test
    public void testMySetIOsequenseOfObjectText() throws IOException, ClassNotFoundException {
        MySetIO mySetIO = new MySetIO();
        MySet set = new MySet();
        set.add(new Tomato());
        set.add(new Cucumber());
        set.add(new Onion());
        set.add(new Cabbage());
        mySetIO.writeAsSequenceOfObjectsText(set, "file.txt");
        MySet set1 = mySetIO.readAsSequenceOfObjectsText("file.txt");
        assertEquals("read/write error",true, set.containsAll(set1));
        assertEquals("read/write error",set.size(), set1.size());
    }
}
