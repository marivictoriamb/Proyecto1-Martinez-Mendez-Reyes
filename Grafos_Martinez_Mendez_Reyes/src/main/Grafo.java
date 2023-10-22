package main;
import java.util.Random;
import javax.swing.JOptionPane;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swing_viewer.DefaultView;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.Viewer;


/**
 *
 * @author mariv
 */
public class Grafo {
    private Lista listaAdy [];
    private int cantidadVertices;
    private int nodos;
    private String SCC;
    
    public Grafo(int size){
        nodos = size;
        cantidadVertices = 0;
        listaAdy = new Lista[size];
        SCC = "";
        
    }
    
    public void insertaVertice (String usuario, int id) {
        if (nodos < cantidadVertices+1){
            JOptionPane.showMessageDialog(null, "Error, se supera el número de nodos máximo del grafo");
        } else{
            listaAdy[cantidadVertices]= new Lista();
           listaAdy[cantidadVertices].Insertar(usuario, id);
            
        }
        cantidadVertices ++;
    }
    
    public void insertaVerticeT (String usuario, int id) {
        if (nodos < cantidadVertices+1){
            JOptionPane.showMessageDialog(null, "Error, se supera el número de nodos máximo del grafo");
        } else{
            listaAdy[id]= new Lista();
           listaAdy[id].Insertar(usuario, id);
            
        }
        cantidadVertices ++;
    }
    
    public void insertarConeccion (int i, String usuario, int id) {
        listaAdy[i].Insertar(usuario, id);
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
    
    public int buscarId(String usuario){
        int id = 0;
        
        for (int i =0; i < cantidadVertices; i++){
            if (listaAdy[i].getHead().getDato().replaceAll("\\p{C}", "").equals(usuario)){
                id = listaAdy[i].getHead().getId();
                break;
            }
        }
        
        return id;
    }
    
    /**
     * Nombre: AñadirUsuario
     * Descripcion: Recibe el nombre de un usuario nuevo, de ser valido se modifica el archivo txt para guardar los cambios y se actualiza el grafo.
     * @autor: Mauricio Mendez
     * @version: 18/10/23
     * @param nombre
     * @param filetxt
     * @return filetxt
     */
    public String [] AñadirUsuario(String nombre, String [] filetxt){
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
    public  String [] RelacionarUsuario(String relacion, String [] filetxt){
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
    
    
    
    public void Mostrar(){
        Graph graph = new MultiGraph("Grafo");
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", "node{\n" +
                "    size: 30px, 30px;\n" +
                "    fill-color: #f7f7f0;\n" +
                "    text-mode: normal; \n" +
                "}");
        
        for (int i = 0; i < cantidadVertices; i++){
            String etiqueta = listaAdy[i].getHead().getDato().replaceAll("\\p{C}", "");
            graph.addNode(etiqueta).setAttribute("ui.label", etiqueta);
        }
        
        for (int i = 0; i < cantidadVertices; i++){
            String etiquetaA = listaAdy[i].getHead().getDato().replaceAll("\\p{C}", "");
            Nodo recorrido = listaAdy[i].getHead().getNext();
            
            while (recorrido != null){
                String etiquetaB = recorrido.getDato().replaceAll("\\p{C}", "");
                String etiquetaConeccion = (etiquetaA + " - " + etiquetaB).replaceAll("\\p{C}", "");
                graph.addEdge(etiquetaConeccion, etiquetaA, etiquetaB, true);
                recorrido = recorrido.getNext();
            }
        }
        
        
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
    
    public String DFSUtil(int id, boolean visited[]) {
        visited[id] = true;
        int n;
        Nodo recorrido = listaAdy[id].getHead().getNext();
        
        if (recorrido!=null){
            while (recorrido != null){
            n = recorrido.getId();
            if (!visited[n]){
                SCC += Integer.toString(n) + ",";
                DFSUtil(n, visited);
            }
            recorrido = recorrido.getNext();
            }
        }
        
        
        if (!SCC.contains("," + Integer.toString(id) + ",") && !SCC.contains("," + Integer.toString(id) + "-") && !SCC.contains("-" + Integer.toString(id) + ",") && !SCC.contains("-" + Integer.toString(id) + "-") && !SCC.contains(Integer.toString(id) + ",") && !SCC.contains(Integer.toString(id) + "-")){
            SCC += Integer.toString(id) + "-";
        }
        return SCC;
    }

    public Grafo getTranspose() {
        Grafo g = new Grafo(cantidadVertices);
        for (int i = 0; i < cantidadVertices; i++) {
            int idUser = listaAdy[i].getHead().getId();
            String user = listaAdy[i].getHead().getDato();
            Nodo recorrido = listaAdy[i].getHead().getNext();

           
            if (g.listaAdy[idUser] == null){
                g.insertaVerticeT(user, idUser);
            } 
            while (recorrido != null){
                int idConeccion = recorrido.getId();
                String coneccion = recorrido.getDato();

                if (g.listaAdy[idConeccion] == null){
                    g.insertaVerticeT(coneccion, idConeccion);
                    g.insertarConeccion(idConeccion, user, idUser);
                } else {
                    g.insertarConeccion(idConeccion, user, idUser);
                }
                recorrido = recorrido.getNext();

            }
                
        }
        return g;
    }

    public void fillOrder(int i, boolean visited[], Pila pila) {
        visited[i] = true;
        Nodo recorrido = listaAdy[i].getHead().getNext();
        
        while (recorrido != null){
            if (!visited[recorrido.getId()])
                fillOrder(recorrido.getId(), visited, pila);
            recorrido = recorrido.getNext();
        }

        pila.InsertarNodo(i);
    }

    public void printSCCs() {
        Pila pila = new Pila();

        boolean visited[] = new boolean[cantidadVertices];
        for(int i = 0; i < cantidadVertices; i++)
            visited[i] = false;

        for (int i = 0; i < cantidadVertices; i++)
            if (!visited[i])
                fillOrder(i, visited, pila);
        
        Grafo gr = getTranspose();

        for(int i = 0; i < cantidadVertices; i++)
            visited[i] = false;
        
        while (!pila.IsEmpty()) {
            int id = pila.EliminarNodo();

            if (!visited[id]) {
                SCC = gr.DFSUtil(id, visited);
            }
        }
        
        if (!SCC.contains("-")){
            SCC += "0";
            String [] divide = SCC.split("-");
            MostrarSCC(divide);
        } else {
            String [] divide = SCC.split("-");
            MostrarSCC(divide);
        }
        
    }
    
    public void MostrarSCC(String S []){
        Graph graph = new MultiGraph("Grafo");
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", "node{\n" +
                "    size: 30px, 30px;\n" +
                "    fill-color: #f7f7f0;\n" +
                "    text-mode: normal; \n" +
                "}");
        
        String rbg[] = RBG(S.length);
        
        for (int j = 0; j < S.length; j++){
            if (S[j].length() == 1){
                int id =  Integer.parseInt(S[j]);
                String etiqueta = listaAdy[id].getHead().getDato().replaceAll("\\p{C}", "");
                graph.addNode(etiqueta).setAttribute("ui.label", etiqueta);
                        
                Node n = graph.getNode(etiqueta);
                n.setAttribute("ui.style", rbg[j]);
                    
            } else {
                String divide[] = S[j].split(",");
                NodosSCC(divide, graph, rbg[j]);
            }
        }
        
        
        
        for (int i = 0; i < cantidadVertices; i++){
            Nodo recorrido = listaAdy[i].getHead().getNext();
            String etiquetaA = listaAdy[i].getHead().getDato().replaceAll("\\p{C}", "");
            
            while (recorrido != null){
                String etiquetaB = recorrido.getDato().replaceAll("\\p{C}", "");
                String etiquetaConeccion = (etiquetaA + " - " + etiquetaB).replaceAll("\\p{C}", "");
                graph.addEdge(etiquetaConeccion, etiquetaA, etiquetaB, true);
                recorrido = recorrido.getNext();
            }
        }
        
        
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY);
    }
    
    public void NodosSCC(String nodes[], Graph graph, String rbg){
        for (int j = 0; j < nodes.length; j++){
            int id =  Integer.parseInt(nodes[j]);
            String etiqueta = listaAdy[id].getHead().getDato().replaceAll("\\p{C}", "");
            graph.addNode(etiqueta).setAttribute("ui.label", etiqueta);

            Node n = graph.getNode(etiqueta);
            n.setAttribute("ui.style", rbg);
        }
    }
    
    public String [] RBG(int size){
        String [] rbg = new String[size];
        
        Random rand = new Random();
        
        for (int i = 0; i < size; i++){
            int r = (int)(rand.nextFloat()*256);
            int g = (int)(rand.nextFloat()*256);
            int b = (int)(rand.nextFloat()*256);
            rbg[i] = "fill-color: rgb(" +String.valueOf(r)+ "," +String.valueOf(g)+ "," +String.valueOf(b)+ ");";
        }
        
        return rbg;

    }
    
}
