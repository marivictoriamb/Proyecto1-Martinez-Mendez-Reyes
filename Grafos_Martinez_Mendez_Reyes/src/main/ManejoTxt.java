package main;

import javax.swing.JOptionPane;
import java.io.*;

/**
* Descripcion: Clase que se encarga del manejo de los archivos txt y su contenido en el grafo
* @autor: Maria Martinez
* @version: 18/10/23      
*/

public class ManejoTxt {
    private Grafo grafo;
    private int size;
    
    
    /**
     * Descripcion: Constructor de la clase User
     * @autor: Maria Martinez
     * @version: 29/09/23
     */
    public ManejoTxt(){
        grafo = null;
        size = 0;
    }
    
    /**
     * Descripcion: Agrega en el grafo los usuarios y sus relaciones 
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param divide: Array que contiene el nombre de los usuarios y sus correspondientes relaciones
     *          
     */
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
    
    
    /**
     * Descripcion: Guarda en el txt cargado su contenido modificado por el programa
     * @autor: Mauricio Mendez
     * @version: 18/10/23
     * @param txt: Archivo del txt cargado
     * @param contenido: Contenido del txt modificado / Informacion del grafo
     */
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
