package main.java.util;


import java.io.*;

public class FileReader {
    public static String readFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("file " + filePath + " doesn't exist.");
            return null;
        }

        try {
            FileInputStream in = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

            StringBuilder filecontent = new StringBuilder();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                filecontent.append(line + "\n");
            }

            in.close();
            return filecontent.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
