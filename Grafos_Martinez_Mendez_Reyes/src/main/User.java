package main;

import javax.swing.JOptionPane;

public class User {
    private Grafo grafo;
    private int size;
    
    public User(){
        grafo = null;
        size = 0;
    }
    
    
    public void Save(String contenido){
        String [] divide = contenido.split("\n");
        int start = 0;
        
        // Buscar cantidad de usuarios/vertices
        for (int i = 0; i < divide.length; i++){
            if (!divide[i].replaceAll("\\p{C}", "").equals("usuarios") & !divide[i].replaceAll("\\p{C}", "").equals("relaciones")){
                size ++;
            } else if (divide[i].replaceAll("\\p{C}", "").equals("relaciones")){
                break;
            }
        }
        
        grafo = new Grafo(size);
        
        // Agregar usuarios/vertices
        for (int i = 0; i < divide.length; i++){
            if (!divide[i].replaceAll("\\p{C}", "").equals("usuarios") & !divide[i].replaceAll("\\p{C}", "").equals("relaciones")){
                grafo.insertaVertice(divide[i]);
            } else if (divide[i].replaceAll("\\p{C}", "").equals("relaciones")){
                start  = i+1;
                break;
            }
        }
        
        // Agregar conecciones - @pepe, @mazinger
        for (int i = start; i < divide.length; i++){
            String datos[] = divide[i].split(", ");
            int posicion = grafo.buscarUsuario(datos[0].replaceAll("\\p{C}", ""));
            grafo.insertarConeccion(posicion, datos[1]);
        }
        
                
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}
