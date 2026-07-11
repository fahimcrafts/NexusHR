package utils;

import java.util.UUID;

public class DataGenerator {
    public static String getFirstName(){
        return "AutoFN_" + UUID.randomUUID().toString().substring(0, 5);
    }

    public static String getLastName(){
        return "AutoLN_" + UUID.randomUUID().toString().substring(0, 5);
    }

    public static String getEmployeeId(){
        return String.valueOf((int)(Math.random() * 9000) + 1000);
    }
}
