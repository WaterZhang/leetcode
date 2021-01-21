package com.zhangzemiao.leetcode.top.strings;

/**
 * @Desc: Count and Say
 * @author: wzhang
 * @date: 2021/1/20
 */
public class CountAndSay {

    public static void main(String[] args){
        for(int i=1; i < 6; i++){
            System.out.println(i+ " -> " + countAndSay(i));
        }
    }

    // 换成StringBuild,性能提升
    private static String countAndSayV2(int n){
        if(n == 1){
            return "1";
        }
        String lastRs = countAndSay(n-1);
        StringBuilder currentRs = new StringBuilder();
        for(int i=0, count=1; i < lastRs.length(); i++ ){
            if(i+1 < lastRs.length()){
                if(lastRs.charAt(i) == lastRs.charAt(i+1)){
                    count++;
                    continue;
                } else {
                    currentRs.append(count).append(lastRs.charAt(i));
                    //reset as default
                    count = 1;
                }
            } else {
                currentRs.append(count).append(lastRs.charAt(i));
                //reset as default
                count = 1;
            }
        }
        return currentRs.toString();
    }

    //leetcode性能不够好
    private static String countAndSay(int n){
        if(n < 1 || n > 30){
            return "0";
        }
        if(n == 1) {
            return "1";
        }
        // 上一个结果,一直递归到n=1
        String num = countAndSay(n-1);
        // 把这个结果解析成有几个相同的数,从左到右.
        // n = 2,  那么 n=1的结果是固定的 "1"，描述的话，就是 1个1， 用字符串表示就是 11
        // n = 3,  那么 n=2的结果是 "11"，描述的话， 2个1, 字符串表示 21
        // n = 4,  那么 n=3的结果就是 "21", 描述的话, 1个2 1个1, 字符串表示1211
        // 比如n=5, 那么num是n=4的结果,为1211, 解析成 1个1,1个2,2个1, 用字符串表示就是111221
        //这里只要解析num就可以了
        String result = "";
        for(int i=0, count=1; i<num.length(); i++){
            if(i+1 < num.length()){
                if(num.charAt(i) == num.charAt(i+1)){
                    count++;
                } else {
                    result+= String.valueOf(count)+num.charAt(i);
                    //reset
                    count = 1;
                }
            } else{
                result+= String.valueOf(count)+num.charAt(i);
                //reset
                count = 1;
            }
        }
        return result;
    }

    // method 1
    private static String recurse(int n){
        if(n == 1){
            return String.valueOf(1);
        }

        String str = recurse(n-1);
        String result = "";
        int t = 1;
        int i;
        for(i=0; i < str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                t++;
            } else {
                result = result + t;
                result = result+str.charAt(i);
                t = 1;
            }
        }
        result = result + t;
        result = result+str.charAt(i);
        return result;
    }
}
