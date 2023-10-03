package main;

/**
 *
 * @author mariv
 */
public class Nodo {
    private String dato;
    private Nodo next;
    
    public Nodo (String dato) {
        this.dato = dato;
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
    
    
    
}
