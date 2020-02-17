package com.hyw.offer.leet.code;

import java.util.Stack;

/**
 * Project：study_996     @author 源伟
 * DateTime：2020/2/15 17:08
 * Description：TODO
 */
public class Main71 {

    public String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "..":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case ".":
                    break;
                case "":
                    break;
                default:
                    stack.push(token);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + "/");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Main71 main71 = new Main71();
        System.out.println(main71.simplifyPath("/home//foo/"));
    }

}
