package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Q1(new String[]{"a,a,a,c,a", "a,b,a,c,a", "a,a,a,b,b"});
        Q2(20, 3);
    }

    public static int Q1(String[] input) {
        int result = 0;
        String[][] block = new String[input.length][];
        String searchRoot = "";

        for (int i = 0; i < input.length; i++) {
            block[i] = input[i].split(",");
        }

        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[i].length; j++) {
                //System.out.println("block["+i+"]["+j+"]="+block[i][j]);
                switch (block[i][j]) {
                    case "a":
                        searchRoot = "a";
                        dfsBlock(block, i, j, searchRoot);
                        result++;
                        break;
                    case "b":
                        searchRoot = "b";
                        dfsBlock(block, i, j, searchRoot);
                        result++;
                        break;
                    case "c":
                        searchRoot = "c";
                        dfsBlock(block, i, j, searchRoot);
                        result++;
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.println("Q1: The user Input is:");
        for (String s : input) {
            System.out.println(s);
        }
        System.out.println("The result is " + result);
        System.out.println("");
        return result;
    }

    public static void dfsBlock(String[][] blocks, int i, int j, String root) {
        if (i < 0 || j < 0 || i >= blocks.length || j >= blocks[i].length || blocks[i][j].equals("done"))
            return;
        if (!blocks[i][j].equals(root))
            return;
        blocks[i][j] = "done";
        dfsBlock(blocks, i - 1, j, root);
        dfsBlock(blocks, i + 1, j, root);
        dfsBlock(blocks, i, j - 1, root);
        dfsBlock(blocks, i, j + 1, root);
    }

    public static long Q2(long n, long m) {
        long result = 0;
        String[] factor;
        String temp = "1";
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                temp = temp + "," + i;
            }
        }
        factor = temp.split(",");
        System.out.println("Q2: the number " + n + " can be divided into:");
        for (String f : factor) {
            System.out.print(f + " ");
        }
        if (m < factor.length) {
            result = Long.parseLong(factor[(int) m - 1]);
        }
        System.out.println("");
        System.out.println("The index " + m + " is: " + result);
        return result;
    }
}
