package main;

/**
 *
 * @author mariv
 * @version 29/09/2023
 */
public class NodoPila {
    private NodoPila next;
    private int id;
    
    
    /**
     * Descripcion: Constructor de la clase NodoPila
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param id: ID del usuario
     */
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
