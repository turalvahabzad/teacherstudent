package file;

import comman.Person;
import javafx.scene.shape.Path;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public class FileUtility {

    public static void writeTextFile(String message) throws IOException {

        Files.write(Paths.get("myfile.get"),message.getBytes(), StandardOpenOption.WRITE);
    }

    public static void writeImageToFile() throws IOException {
        byte[]bytes= Files.readAllBytes(Paths.get("Java.png"));
        Files.write(Paths.get("copy.png"),bytes, StandardOpenOption.CREATE);
    }
    public static void readTextFile(String filePath) throws IOException {
        byte[]bytes= Files.readAllBytes(Paths.get(filePath));
        String text=new String(bytes, StandardCharsets.UTF_8);
        System.out.println(text);

    }
    public static void writeObjToFile(Object obj, String objectFile) throws Exception{
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(objectFile))){

            oos.defaultWriteObject();
            oos.flush();

        }
    }
    public static Object readObject(String objectFile) throws Exception{

        try(ObjectInputStream iis=new ObjectInputStream(new FileInputStream(objectFile))){

            Object o=iis.readObject();
            return o;
        }
    }
}
