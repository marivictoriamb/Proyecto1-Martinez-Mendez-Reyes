package main;

/**
 * @author mariv
 * @version 29/09/2023
 */
public class NodoUsuario {
    private String dato;
    private NodoUsuario next;
    private int id;
    
    
    /**
     * Descripcion: Constructor de la clase NodoUsuario
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param dato: Identificador (nombre) del usuario
     * @param  id: Id del usuario / Posicion del usuario en la lista adyacente
     */
    public NodoUsuario (String dato, int id) {
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

    public NodoUsuario getNext() {
        return next;
    }

    public void setNext(NodoUsuario next) {
        this.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
}
