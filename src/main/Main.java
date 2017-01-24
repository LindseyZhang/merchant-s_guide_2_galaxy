package main;

import java.io.*;

public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.err.println("please give a input file as parameter");
      return;
    }

    String filePath = args[0];

      String content = FileReader.ReadFile(filePath);
      if ( content != null) {
          System.out.println("content in " + filePath + ":\n");
          System.out.println(content);
          MerchantProcess process = new MerchantProcess(content);
          System.out.println("Below are answers for question:\n");
          System.out.println(process.getResult());
      }

  }

}

