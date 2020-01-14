package com.xproject.server;

public class Tonight {
    public static void main(String[] args) {
        String[] rs={"沙县A","沙县B","沙县C","烧腊","木桶饭","山门大酒店","大绿岛","又见面","潮味","兰州拉面"};
        System.out.println(rs[(int)(Math.random()*rs.length)]);
        System.out.println(Math.random()*rs.length);
    }
}
