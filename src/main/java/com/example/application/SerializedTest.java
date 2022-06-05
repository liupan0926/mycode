package com.example.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 序列化test 类SerializedTest.java的实现描述：TODO 类实现描述
 * 
 * @author liupan Jun 5, 2022 11:08:54 AM
 */
public class SerializedTest {

    public static void main(String[] args) {
        TestClass tc = new TestClass();

        tc.setId(1L);
        tc.setName("ceshi class");

        serializedClass(tc);

        TestClass dd = deserialzedClass();

        System.out.println("反序列化类:" + dd);
    }

    private static void serializedClass(TestClass tc) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(
                    new File("/Users/liupan/myCodeApp/demo/src/main/resources/filefolder/serialized.txt")));
            out.writeObject(tc);
            if (out != null) {
                out.close();
            }
            System.out.println("序列化成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static TestClass deserialzedClass() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(
                    new File("/Users/liupan/myCodeApp/demo/src/main/resources/filefolder/serialized.txt")));
            TestClass tc = (TestClass) input.readObject();
            System.out.println("反序列化成功");
            return tc;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
