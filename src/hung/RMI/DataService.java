/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

//import java.rmi.Remote;
//import java.rmi.RemoteException;
//
///**
// *
// * @author ADMIN
// */
//public interface DataService extends Remote {
//public Object requestData(String studentCode, String qCode) throws RemoteException;
//public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
//}


import java.rmi.*;

public interface DataService extends  Remote {
    public Object requestData(String studentCode, String qCode) throws RemoteException;
    public void submitData(String studentCode, String qCode, Object data) throws RemoteException;
    
}