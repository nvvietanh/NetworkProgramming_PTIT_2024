/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.registry.*;
import java.util.*;
import java.net.*;
import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
        

/**
 *
 * @author ADMIN
 */
public class RMI_Character_323_MaHoaChuoi64 {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry rs = LocateRegistry.getRegistry("203.162.10.109");
        CharacterService cs = (CharacterService) rs.lookup("RMICharacterService");
        
        String s = cs.requestCharacter("B21DCCn323", "9coW6k86");
        System.out.println(s);
        
        byte [] encode = Base64.getEncoder().encode(s.getBytes());
        String x = new String(encode);
        
        cs.submitCharacter("B21DCCN323", "9cow6k86", x);
        
    }
}
