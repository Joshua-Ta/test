package org.example.test;

public class StringProcessing {
    public static String processString(String input) {
        StringBuilder result = new StringBuilder(input);
        boolean changed;
        do {
            changed = false;
            // 遍历输入字符
            for (int i = 0; i < result.length(); i++) {
                // 统计连续相同字符的数量,前提连续两位小于整体长度
                int count = 1;
                while (i + 1 < result.length() && result.charAt(i) == result.charAt(i + 1)) {
                    count++;
                    i++;
                }
                // 三个以上字符开始替换
                if (count >= 3) {
                    char replacement;
                    // 如果当前字符是 'a'，替换为blank
                    if (result.charAt(i) == 'a') {
                        replacement = ' ';
                    } else {
                        // 否则将当前字符替换为前一个字符
                        replacement = (char) (result.charAt(i) - 1);
                    }
                    StringBuilder newResult = new StringBuilder();
                    System.out.println("result = " +result);
                    System.out.println("count = " + count);
                    System.out.println("i = " + i);
                    for (int j = 0; j < result.length(); j++) {
                        // 不在替换范围内，直接添加到new
                        if (j < i - count + 1 || j >= i + 1) {
                            newResult.append(result.charAt(j));
                            System.out.println("new = " + result.charAt(j));
                        } else if (j == i - count + 1 && replacement!= ' ') {
                            // 在范围且有值，直接添加到中间
                            newResult.append(replacement);
                        }
                    }
                    result = newResult;
                    changed = true;
                    break;
                }
            }
        } while (changed);
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "abcccbad";
        System.out.println(processString(input));
    }
}
