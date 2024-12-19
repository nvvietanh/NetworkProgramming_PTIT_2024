/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;

// import java.net.*;
// import java.*;

/**
 *
 * @author admin
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            // URL gốc cần mã hóa
            String originalURL = "https://example.com/search?query=java URL encoding&lang=en";

            // Mã hóa URL
            String encodedURL = java.net.URLEncoder.encode(originalURL, "UTF-8");

            // Kết quả
            System.out.println("Original URL: " + originalURL);
            System.out.println("Encoded URL: " + encodedURL);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Lỗi mã hóa: " + e.getMessage());
        }
    }
}
