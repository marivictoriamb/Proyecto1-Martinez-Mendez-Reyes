/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.JOptionPane;
import java.io.*;
/**
 *
 * @author MAURICIO MENDEZ
 */
public class Utils {
    /**
     * Nombre: AñadirUsuario
     * Descripcion: Recibe el nombre de un usuario nuevo, de ser valido se modifica el archivo txt para guardar los cambios y se actualiza el grafo.
     * @autor: Mauricio Mendez
     * @version: 18/10/23
     * @param nombre
     * @param filetxt
     * @return filetxt
     */
    public static String [] AñadirUsuario(String nombre, String [] filetxt){
        if(nombre.isEmpty()==true || nombre.length()<2 || !Character.toString(nombre.charAt(0)).equals("@")|| nombre.contains(" ") ){
            JOptionPane.showMessageDialog(null, "Error\nIngrese el formato adecuado.");
            
        }else{
//            Verificamos si el usuario ingresado ya existe
            boolean encontrado = false;           
            for (int i = 0;  i<filetxt.length; i++) {
                if(filetxt[i].replaceAll("\\p{C}", "").equals(nombre)==true){
                    JOptionPane.showMessageDialog(null, "ERROR!\n\nEl usuario ya existe");
                 encontrado = true;
                } 
            }
            if(encontrado== false){
//                Añadimos en nuevo usuario.
                String [] newusuario= new String[filetxt.length+1];
        int aux =0;        
        for (int i = 0; i < filetxt.length+1; i++) {
            
            if(filetxt[aux].replaceAll("\\p{C}", "").equals("relaciones")){
                newusuario[aux]= nombre;
                newusuario[aux+1]= filetxt[aux];
                i++;
            }else{
                newusuario[i]=filetxt[aux];
            } 
            aux++;
        }
        
        filetxt = newusuario;
        
        JOptionPane.showMessageDialog(null, "El usuario ha sido añadido exitosamente");
        return filetxt;
            }
        }
        return filetxt;
    }
    /**
     * Nombre: RelacionrUsuario
     * Descripcion: Recibe 2 usuarios existentes en el grafo y crea un ralacion entre ellos si esta no existe.
     * @autor: Mauricio Mendez
     * @version: 18/10/23
     * @param relacion
     * @param filetxt
     * @return filetxt
     */
    public static String [] RelacionarUsuario(String relacion, String [] filetxt){
//        Verificamos que la relacion no exista previamente.
        boolean valid = false;
        for (int i = 0; i < filetxt.length; i++) {
            if(filetxt[i].contains(relacion)){
                valid= true;
            }
        }
//        Si no existe entonces agregamos la relacion al grafo.
        if(valid == false){
            String [] newrelacion = new String [filetxt.length+1];
            for (int i = 0; i < filetxt.length; i++) {
                newrelacion[i]=filetxt[i];
            }
            newrelacion[filetxt.length]=relacion;
            JOptionPane.showMessageDialog(null, "Relacion creada con exito.");
            filetxt = newrelacion;
            return filetxt;
        }else{
            JOptionPane.showMessageDialog(null, "ERROR! \n La relacion ya existe.");
        }
        return filetxt;
    }
     public static void ActualizarFile(File txt, String contenido){
        try{
            PrintWriter salida = new PrintWriter(txt);
            salida.print(contenido);
            salida.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
