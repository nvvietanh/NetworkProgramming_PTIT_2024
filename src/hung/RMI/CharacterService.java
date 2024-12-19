/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

/**
 *
 * @author ADMIN
 */

import java.rmi.*;
public interface CharacterService extends Remote{
    public String requestCharacter(String studentCode, String qCode) throws  RemoteException;
    public void submitCharacter(String studentCode, String qCode, String strSubmit) throws RemoteException;
}
