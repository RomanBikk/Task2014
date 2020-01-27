import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution implements Serializable {
    public static void main(String[] args)  {
        File file = new File("D:\\\\javafile\\\\filea.txt");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Solution savedObject = new Solution(66);
        ObjectOutputStream objectOutputStream;
        ObjectInputStream objectInputStream = null;
        Solution loadedObject = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectInputStream = new ObjectInputStream(fileInputStream);
            objectOutputStream.writeObject(savedObject);
            loadedObject = (Solution)objectInputStream.readObject();
        } catch (IOException  | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(savedObject.string.equals(loadedObject.string));
        System.out.println(new Solution(4));
    }

    private final transient String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
