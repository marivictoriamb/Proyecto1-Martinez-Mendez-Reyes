package main;

/**
 *
 * @author mariv
 */
public class Nodo {
    private String dato;
    private Nodo next;
    private int id;
    
    public Nodo (String dato, int id) {
        this.dato = dato;
        this.id = id;
        next = null;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
