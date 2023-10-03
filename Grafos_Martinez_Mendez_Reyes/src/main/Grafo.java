package main;
import javax.swing.JOptionPane;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swing_viewer.DefaultView;
import org.graphstream.ui.swing_viewer.SwingViewer;


/**
 *
 * @author mariv
 */
public class Grafo {
    Lista listaAdy [];
    int cantidadVertices;
    int nodos;
    
    public Grafo(int size){
        nodos = size;
        cantidadVertices = 0;
        listaAdy = new Lista[size];
        
    }
    
    public void insertaVertice (String usuario) {
        if (nodos < cantidadVertices+1){
            JOptionPane.showMessageDialog(null, "Error, se supera el número de nodos máximo del grafo");
        } else{
            listaAdy[cantidadVertices]= new Lista();
           listaAdy[cantidadVertices].Insertar(usuario);
            
        }
        cantidadVertices ++;
    }
    
    public void insertarConeccion (int i, String usuario) {
        listaAdy[i].Insertar(usuario);
    }
    
    public int buscarUsuario(String usuario){
        int posicion = 0; 
        
        for (int i = 0; i < cantidadVertices; i++){
            if (listaAdy[i].getHead().getDato().replaceAll("\\p{C}", "").equals(usuario)){
                posicion = i;
                break;
            }
        }
        
        return posicion;
    }
    
    public void Mostrar(){
        Graph graph = new MultiGraph("Grafo");
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", "node{\n" +
                "    size: 30px, 30px;\n" +
                "    fill-color: #f7f7f0;\n" +
                "    text-mode: normal; \n" +
                "}");
        
        for (int i = 0; i < cantidadVertices; i++){
            String etiqueta = listaAdy[i].getHead().getDato();
            graph.addNode(etiqueta).setAttribute("ui.label", etiqueta);
        }
        
        for (int i = 0; i < cantidadVertices; i++){
            Nodo recorrido = listaAdy[i].getHead().getNext();
            String etiquetaA = listaAdy[i].getHead().getDato();
            
            while (recorrido != null){
                String etiquetaB = recorrido.getDato();
                String etiquetaConeccion = etiquetaA + " - " + etiquetaB;
                graph.addEdge(etiquetaConeccion, etiquetaA, etiquetaB, true);
                recorrido = recorrido.getNext();
            }
        }
        
        
        graph.display();
    }
    
}
