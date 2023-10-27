
package main;

/**
 * @author mariv
 * @version 29/09/2023
 */
public class Pila {  
    private NodoPila head; 
    private int size = 0;
    
    
    /**
     * Descripcion: Constructor de la clase Pila
     * @autor: Maria Martinez
     * @version: 29/09/23
     */
    public Pila(){
        head = null;
        size = 0;
    }
    
    /**
     * Descripcion: Verifica si la lista esta vacia
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @return Valor booleano
     */
    public boolean IsEmpty(){
        return (head == null); // If True entonces esta vacia
    }
    
    
    /**
     * Descripcion: Inserta el nodo en la pila
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param id: ID (qque representa un usuario)
     */
    public void InsertarNodo(int id){
        NodoPila nuevo = new NodoPila(id);
        
        if (IsEmpty()){
            head = nuevo;
        } else{
            nuevo.setNext(head);
            head = nuevo;
        }
        size ++;
    }
    
    /**
     * Descripcion: Elimina el nodo de la cabeza de la pila
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @return ID (que representa un usuario) eliminado de la pila
     */
    public int EliminarNodo(){
        int id = head.getId();
        NodoPila recorrido = head.getNext();
        head = recorrido;
        size --;
        
        return id;
    }
    
   
}
