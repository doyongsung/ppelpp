package com.company.ioc;

public class Main {

    public static void main(String[] args) {
        String url ="www.naver.com/books/it?page=10&size=20&name=spring-boot";

        // Base 64 encoding

        // url encoding

        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
