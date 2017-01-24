package main.java;

import main.java.util.FileReader;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("please give a file path!");
            return;
        }

        String filePath = args[0];

        String content = FileReader.readFile(filePath);
        if (content != null) {
            System.out.println("content in " + filePath + ":\n");
            System.out.println(content);

            MerchantProcessor process = new MerchantProcessor(content);

            System.out.println("Below are answers for question:\n");
            System.out.println(process.getResult());
        }

    }
}

