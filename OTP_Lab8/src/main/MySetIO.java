package main;

import java.io.*;
import java.util.Iterator;

/**
 * Created by Makarenko on 26.04.2017.
 */
public class MySetIO {
    public void writeAsSingleObject(MySet mySet, String filename) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        outputStream.writeObject(mySet);
        outputStream.flush();
        outputStream.close();
    }

    public MySet readAsSingleObject(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        MySet mySet = (MySet) inputStream.readObject();
        inputStream.close();
        return mySet;

    }

    public void writeAsSequenceOfObjects(MySet mySet, String filename) throws IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        Iterator<Vegetable> iterator = mySet.iterator();
        outputStream.writeInt(mySet.size());
        while (iterator.hasNext())
            outputStream.writeObject(iterator.next());
        outputStream.flush();
        outputStream.close();
    }

    public MySet readAsSequenceOfObjects(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
        MySet mySet = new MySet();
        int size = inputStream.readInt();
        for (int i = 0; i < size; i++)
            mySet.add((Vegetable) inputStream.readObject());
        inputStream.close();
        return mySet;
    }

    public void writeAsSequenceOfObjectsText(MySet set, String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
//        fileWriter.append(set.size() + "\n");
        Iterator<Vegetable> iterator = set.iterator();
        while (iterator.hasNext())
            fileWriter.append(iterator.next().getName() + "\n");
        fileWriter.flush();
        fileWriter.close();
    }

    public MySet readAsSequenceOfObjectsText(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);
        int ch;
        StringBuilder str = new StringBuilder();
        MySet set = new MySet();
//        while((ch = (char)fileReader.read())!='\n')
//            str.append(ch);
//        int size = Integer.parseInt(new String(str));
        while ((ch = fileReader.read()) != -1) {
            if ((char) ch == '\n') {
                switch (new String(str)) {
                    case "Tomato":
                        set.add(new Tomato());
                        break;
                    case "Cucumber":
                        set.add(new Cucumber());
                        break;
                    case "Cabbage":
                        set.add(new Cabbage());
                        break;
                    case "Onion":
                        set.add(new Onion());
                        break;
                    default:
                        break;
                }
                str = new StringBuilder();
            } else
                str.append((char) ch);
        }
        return set;
    }
}
