
package main;

/**
 *
 * @author mariv
 */
public class Pila {  
    private NodoPila head; 
    private int size = 0;
    
    public Pila(){
        head = null;
        size = 0;
    }
    
    // Metodo para saber si la pila esta vacia
    public boolean IsEmpty(){
        return (head == null); // If True entonces esta vacia
    }
    
    
    // Metodo para ingresar un nodo en la pila
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
    
    // Metodo para eliminar un nodo de la pila
    public int EliminarNodo(){
        int id = head.getId();
        NodoPila recorrido = head.getNext();
        head = recorrido;
        size --;
        
        return id;
    }
    
   
}
