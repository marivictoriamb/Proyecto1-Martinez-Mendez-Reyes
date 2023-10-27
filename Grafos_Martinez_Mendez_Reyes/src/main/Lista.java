/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 * @author mariv
 * @version 29/09/2023
 */
public class Lista {
    private NodoUsuario head;
    private int size;
    
    
    /**
     * Descripcion: Constructor de la clase Lista
     * @autor: Maria Martinez
     * @version: 29/09/23
     */
    public Lista(){
        head = null;
        size = 0;
    }
    
    
    /**
     * Descripcion: Revisa si la lista esta vacia
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @return Valor booleano
     */
    public boolean IsEmpty(){
        return head == null;
    }
    
    /**
     * Descripcion: Revisa si la lista esta vacia
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param dato: Representa el identificador (nombre) del usuario
     * @param id: Representa el id del usuario / Posicion del usuario en la lista adyacente
     */
    public void Insertar(String dato, int id){
        NodoUsuario nuevo = new NodoUsuario(dato, id);
        
        if (IsEmpty()){
            head = nuevo;
        } else{
            NodoUsuario recorrido = head;
            
            while (recorrido.getNext() != null){
                recorrido = recorrido.getNext();
            }
            recorrido.setNext(nuevo);
        }
        size ++;
    }
    
    /**
     * Descripcion: Elimina el nodo del comienzo de la lista enlazada
     * @autor: Maria Martinez
     * @version: 29/09/23
     */
    public void EliminarComienzo(){
        head = head.getNext();
        size --;
    }
    
    
    /**
     * Descripcion: Elimina el nodo del final de la lista enlazada
     * @autor: Maria Martinez
     * @version: 29/09/23
     */
    public void EliminarFinal(){
        NodoUsuario recorrido = head;
        
        for(int i = 1; i < size-1; i++){
                recorrido = recorrido.getNext();
            }
        recorrido.setNext(null); 
        size--;
    }
    
    
    /**
     * Descripcion: Elimina el nodo segun una posicion de la lista enlazada
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param posicion: Posicion del nodo a eliminar en la lista enlazada
     */
    public void EliminarPosicion(int posicion){
        if (posicion == size-1){
            EliminarFinal();
        } else if (posicion == 0){
            EliminarComienzo();
        } else {
            NodoUsuario recorrido = head;
            
            for (int i = 0; i < posicion-1; i++){
                recorrido = recorrido.getNext();
            }
            NodoUsuario aux = recorrido.getNext().getNext();
            recorrido.setNext(aux);
            size --;
        }
    }

    public NodoUsuario getHead() {
        return head;
    }

    public void setHead(NodoUsuario head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
