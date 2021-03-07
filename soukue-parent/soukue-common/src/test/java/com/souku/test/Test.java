package com.souku.test;

import cn.hutool.http.HttpRequest;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author soukue
 * 2020/11/21
 */
public class Test {
    public static void main(String[] args) throws UnknownHostException {
        System.out.println(InetAddress.getLocalHost());
        System.out.println("Httpreque1".hashCode());
        System.out.println(HttpRequest.get("").execute().body());
    }
}
