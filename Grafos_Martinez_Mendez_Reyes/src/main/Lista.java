/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author mariv
 */
public class Lista {
    private Nodo head;
    private int size;
    
    public Lista(){
        head = null;
        size = 0;
    }
    
    public boolean IsEmpty(){
        return head == null;
    }
    
    public void Insertar(String dato, int id){
        Nodo nuevo = new Nodo(dato, id);
        
        if (IsEmpty()){
            head = nuevo;
        } else{
            Nodo recorrido = head;
            
            while (recorrido.getNext() != null){
                recorrido = recorrido.getNext();
            }
            recorrido.setNext(nuevo);
        }
        size ++;
    }
    
    public void EliminarComienzo(){
        head = head.getNext();
        size --;
    }
    
    public void EliminarFinal(){
        Nodo recorrido = head;
        
        for(int i = 1; i < size-1; i++){
                recorrido = recorrido.getNext();
            }
        recorrido.setNext(null); 
        size--;
    }
    
    public void EliminarPosicion(int posicion){
        if (posicion == size-1){
            EliminarFinal();
        } else if (posicion == 0){
            EliminarComienzo();
        } else {
            Nodo recorrido = head;
            
            for (int i = 0; i < posicion-1; i++){
                recorrido = recorrido.getNext();
            }
            Nodo aux = recorrido.getNext().getNext();
            recorrido.setNext(aux);
            size --;
        }
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
