/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mariv
 */
public class NodoPila {
    private NodoPila next;
    private int id;
    
    public NodoPila (int id) {
        this.id = id;
        next = null;
    }

    public NodoPila getNext() {
        return next;
    }

    public void setNext(NodoPila next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
