
package main;

/**
 *
 * @author mariv
 */
public class Pila {  
    private Nodo head; 
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
    public void InsertarNodo(String dato){
        Nodo nuevo = new Nodo(dato);
        
        if (IsEmpty()){
            head = nuevo;
        } else{
            nuevo.setNext(head);
            head = nuevo;
        }
        size ++;
    }
    
    // Metodo para eliminar un nodo de la pila
    public void EliminarNodo(){
        Nodo recorrido = head.getNext();
        head = recorrido;
        size --;
    }
}
