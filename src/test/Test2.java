/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author admin
 */
public class Test2 {
    
    public static void main(String[] args) {
        String[] sp = "1 2 3 67 4 69 71 73 9 74 11 75 12 13 14 79 80 17 18 19 20 24 25 26 27 28 30 31 34 37 40 41 42 43 46 47 49 50 52 53 54 56 57 58 61"
                .trim().split("[ ]+");
        
        Set<Integer> intSet = new TreeSet<>();
        
        for (String x : sp) {
            intSet.add(Integer.parseInt(x));
        }
        
        for (int x : intSet) {
            System.out.print(x + " ");
        } System.out.println("");
        int pointer = 1;
        for (int x : intSet) {
//            System.out.println(x + ";");
            
            while (pointer < x) {
                System.out.print(pointer + " ");
                pointer++;
            }
//            System.out.println();
            if (pointer == x) {
                pointer++;
            }
        }
        
    }
    
}

/*
1 2 5
x = 1, p = 1 -> p = 2
x = 2, p = 2 -> p = 3
x = 5, p = 3 -> add(p), x = 4
x = 5, p = 4 -> add(p), x = 5
x = 5, p = 5 -> p = 6
----
x = 4, p = 4 -> p = 5
x = 9, p = 5 -> add(5)
x = 9, p = 6 -> add(6)
x = 9, p = 7 -> add(7)
x = 9, p = 9


*/