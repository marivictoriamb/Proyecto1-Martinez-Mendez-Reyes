package main;

import javax.swing.JOptionPane;
import java.io.*;

public class User {
    private Grafo grafo;
    private int size;
    
    public User(){
        grafo = null;
        size = 0;
    }
    
    
    public void Save(String []divide){
        
        int start = 0;
        
        /// Buscar cantidad de usuarios/vertices
        for (int i = 0; i < divide.length; i++){
            if (!divide[i].replaceAll("\\p{C}", "").equals("usuarios") && !divide[i].replaceAll("\\p{C}", "").equals("relaciones")){
                if (!divide[i].replaceAll("\\p{C}", "").contains("@")){
                    JOptionPane.showMessageDialog(null, "ERROR!\nFormato Incorrecto");
                    size = 0;
                    break;
                } else{
                    size ++;
                }
            } else if (divide[i].replaceAll("\\p{C}", "").equals("relaciones")){
                break;
            }
        }
        
        if (size != 0){
            grafo = new Grafo(size);

            // Agregar usuarios/vertices
            for (int i = 0; i < divide.length; i++){
                if (!divide[i].replaceAll("\\p{C}", "").equals("usuarios") & !divide[i].replaceAll("\\p{C}", "").equals("relaciones")){
                    grafo.insertaVertice(divide[i], i-1);
                } else if (divide[i].replaceAll("\\p{C}", "").equals("relaciones")){
                    start  = i+1;
                    break;
                }
            }

            // Agregar conecciones - @pepe, @mazinger
            for (int i = start; i < divide.length; i++){
                String datos[] = divide[i].split(", ");
                int posicion = grafo.buscarUsuario(datos[0].replaceAll("\\p{C}", ""));
                int id = grafo.buscarId(datos[1].replaceAll("\\p{C}", ""));
                grafo.insertarConeccion(posicion, datos[1], id);
            }
        }
        
                
    }
    public void ActualizarFile(File txt, String contenido){
        try{
            PrintWriter salida = new PrintWriter(txt);
            salida.print(contenido);
            salida.close();
        }catch(Exception e){
            System.out.println(e);
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
