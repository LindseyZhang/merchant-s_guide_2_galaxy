package main;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ConvetorMain {

    public ConvetorMain(String input) {

    }

    public String getResult() {
        return "pish tegj glob glob is 42\n" +
                "glob prok Silver is 68 Credits\n" +
                "glob prok Gold is 57800 Credits\n" +
                "glob prok Iron is 782 Credits\n" +
                "I have no idea what you are talking about\n";
    }
 /*   public static void ConvetorMain() {
    // 要验证的字符串
    String str = "baike.xsoftlab.net";
    // 正则表达式规则
    String regEx = "baike.*";
    // 编译正则表达式
    Pattern pattern = Pattern.compile(regEx);
    // 忽略大小写的写法
    // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(str);
    // 查找字符串中是否有匹配正则表达式的字符/字符串
    boolean rs = matcher.find();
    System.out.println(rs);
    } */

    public static void main(String[] args) {
        getStrings(); //用正则表达式获取指定字符串内容中的指定内容
        System.out.println("********************");
        replace(); //用正则表达式替换字符串内容
    }


    private static void getStrings() {
        String str = "glob glob Silver is 34 Credits";
        Pattern p = Pattern.compile("(.*?) is (.*?) Credits");
        //Pattern p = Pattern.compile("qq(.*?)qq");
        Matcher m = p.matcher(str);
        ArrayList<String> strs = new ArrayList<String>();

        while (m.find()) {
            strs.add(m.group(1));
            strs.add(m.group(2));
        }
        for (String s : strs){
            System.out.println(s);
        }
    }

    private static void replace() {
        String str = "asfas5fsaf5s4fs6af.sdaf.asf.wqre.qwr.fdsf.asf.asf.asf";
        //将字符串中的.替换成_，因为.是特殊字符，所以要用\.表达，又因为\是特殊字符，所以要用\\.来表达.
        str = str.replaceAll("\\.", "_");
        System.out.println(str);
    }
}
