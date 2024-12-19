/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import static RMI.B21DCCN444.uhl1loTC.romanToInt;

/**
 *
 * @author admin
 */
public class Test3 {
    
    public static void main(String[] args) {
        String d = "MCMXCIV"; // 1994
        int sum = 0;
        for (int i = d.length() - 1; i >= 1; --i) {
            int cur = romanToInt(d.charAt(i));
            int prev = romanToInt(d.charAt(i - 1));
            sum += cur;
            if (cur > prev) {
                sum -= prev;
                i--;
            }
        }
        sum += romanToInt(d.charAt(0));
        System.out.println(sum);
    }
    
}
