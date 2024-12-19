/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Laptop implements Serializable{
    private static final long serialVersionUID = 20150711L;
    private int id; 
    private String code;
    private String name;
    private int quantity;

    public Laptop() {
    }

    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
    @Override
    public String toString() {
        return "Laptop{" + "id=" + id + ", code=" + code + ", name=" + name + ", quantity=" + quantity + '}';
    }
    
    
    
}