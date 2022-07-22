package com.songyang.question;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yang Song
 * @date 2022/7/22 14:19
 */
public class Q71 {
    /**
     * 力扣71.简化路径
     * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；
     * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
     * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     * 请注意，返回的 规范路径 必须遵循下述格式：
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     * @param path 路径
     * @return 简化路径
     */
    public static String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return "/";
        }
        // 声明栈
        Deque<String> stack = new ArrayDeque<>();
        String[] opts = path.split("/");
        for (String opt : opts){
            if(".".equals(opt) || "".equals(opt) || "/".equals(opt)){
                continue;
            }
            if("..".equals(opt) && !stack.isEmpty()){
                stack.pop();
                continue;
            }
            stack.push(opt);
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0,"/".concat(stack.pop()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/../"));
    }

}
