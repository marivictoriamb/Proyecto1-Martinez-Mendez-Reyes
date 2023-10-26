package main;
import java.util.Random;
import javax.swing.JOptionPane;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;


/**
* Descripcion: Clase que se encarga del manejo de los archivos txt y su contenido en el grafo
* @autor: Maria Martinez
* @version: 18/10/23      
*/
public class Grafo {
    private Lista listaAdy [];
    private int cantidadVertices;
    private int nodos;
    private String SCC;
    
    
    /**
     * Descripcion: Constructor de la clase Grafo
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param size: Indica la cantidad de usuarios en el grafo
     */
    public Grafo(int size){
        nodos = size;
        cantidadVertices = 0;
        listaAdy = new Lista[size];
        SCC = "";
        
    }
    
    
    /**
     * Descripcion: Inserta un vertice en el grafo, es decir, inserta un elemento nodo a la lista adyacente
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param usuario: Indica el identificador del usuario
     * @param id: Indica la posicion en la lista del usuario
     */
    public void insertaVertice (String usuario, int id) {
        if (nodos < cantidadVertices+1){
            JOptionPane.showMessageDialog(null, "Error, se supera el número de nodos máximo del grafo");
        } else{
            listaAdy[cantidadVertices]= new Lista();
           listaAdy[cantidadVertices].Insertar(usuario, id);
            
        }
        cantidadVertices ++;
    }
    
    
    /**
     * Descripcion: Inserta un vertice en el grafo transpuesto, es decir, inserta un elemento nodo a la lista adyacente transpuesta
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param usuario: Indica el identificador del usuario
     * @param id: Indica la posicion en la lista del usuario
     */
    public void insertaVerticeT (String usuario, int id) {
        if (nodos < cantidadVertices+1){
            JOptionPane.showMessageDialog(null, "Error, se supera el número de nodos máximo del grafo");
        } else{
            listaAdy[id]= new Lista();
           listaAdy[id].Insertar(usuario, id);
            
        }
        cantidadVertices ++;
    }
    
    
    /**
     * Descripcion: Inserta una coneccion en el grafo, es decir, inserta un nodo usuario a la lista enlazada de un nodo usuario de la lista adyacente
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param usuario: Indica el identificador del usuario
     * @param id: Indica la posicion en la lista del usuario
     * @param i: Indica la posicion en la lista del usuario por el cual es seguido
     */
    public void insertarConeccion (int i, String usuario, int id) {
        listaAdy[i].Insertar(usuario, id);
    }
    
    
    /**
     * Descripcion: Busca la posicion de un usuario en el grafo / lista adyacente
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param usuario: Indica el identificador del usuario
     * @param usuario: Indica el identificador del usuario a buscar
     * @return Entero que representa la posicion del usuario en la lista adyacente
     */
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
    
    /**
     * Descripcion: Busca el id de un usuario en el grafo / lista adyacente
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param usuario: Indica el identificador del usuario
     * @return Entero que representa el id del usuario en la lista adyacente
     */
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
     * Descripcion: Recibe el nombre de un usuario nuevo, de ser valido se modifica el archivo txt para guardar los cambios y se actualiza el grafo.
     * @autor: Mauricio Mendez
     * @version: 18/10/23
     * @param nombre: Identificador (nombre) del usuario
     * @param filetxt: Archivo de texto con la informacion de los usuarios y sus conecciones
     * @return Array que contiene el archivo de texto modificado
     */
    public String [] AñadirUsuario(String nombre, String [] filetxt){
        if(nombre.isEmpty()==true || nombre.length()<2 || !Character.toString(nombre.charAt(0)).equals("@")|| nombre.contains(" ")|| nombre.length()>15 ){
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
     * Descripcion: Recibe 2 usuarios existentes en el grafo y crea un ralacion entre ellos si esta no existe en el archivo txt.
     * @autor: Mauricio Mendez
     * @version: 18/10/23
     * @param relacion: String que contiene la relacion entre dos usuarios
     * @param filetxt: Archivo de texto con la informacion de los usuarios y sus conecciones
     * @return Array que contiene el archivo de texto modificado
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
    
    
     /**
     * Descripcion: Recibe el nombre del usuario a eliminar, modifica el archivo txt para guardar los cambios y de una crea o actualiza el grafo.
     * @autor: Andrea Reyes
     * @version: 20/10/23
     * @param nombre: Ayuda a identificar el usuario a eliminar
     * @param filetxt: Archivo  que contiene toda la información necesaria para idenficar el usuario
     * @return Array que elimina al usuario deseado, con el txt modificado 
     */
    
    public String [] eliminarUsuario(String usuario, String [] filetxt){
            
        if(filetxt.length<2){
            JOptionPane.showMessageDialog(null, "Lo siento no se pueden eliminar más usuarios. 🙁");
            
        } else {
      
            int contador= 0 ; 
        
            for (int i = 1; i < filetxt.length; i++) {
                if ((filetxt[i].replaceAll("\\p{C}", "").contains(usuario))){
                    contador +=1;}
            }
        
            String [] usuarioeliminar= new String[filetxt.length-contador];
            int idx=0;
            
            for (int j = 0; j < filetxt.length;j++) { 
                if (!((filetxt[j].replaceAll("\\p{C}", "").contains(usuario)))){
                    usuarioeliminar[idx]=filetxt[j];
                        idx++; } 
            }
                    
        filetxt = usuarioeliminar;
        JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado exitosamente ✅"); 
        return filetxt; 

        }
        return filetxt; }
    
    /**
     * Descripcion: Genera los nodos y aristas del grafo para su representacion visual haciendo uso de la libreria GraphStream
     * @autor: Maria Martinez
     * @version: 29/09/23
     */
    public void Mostrar(){
        Graph graph = new MultiGraph("Grafo");
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", "node{\n" +
                "    size: 30px, 30px;\n" +
                "    fill-color: #FFFF66;\n" +
                "    text-mode: normal; \n" +
                "    text-size: 17; \n" +
                "}");
        
        for (int i = 0; i < cantidadVertices; i++){
            String etiqueta = listaAdy[i].getHead().getDato().replaceAll("\\p{C}", "");
            graph.addNode(etiqueta).setAttribute("ui.label", etiqueta);
        }
        
        for (int i = 0; i < cantidadVertices; i++){
            String etiquetaA = listaAdy[i].getHead().getDato().replaceAll("\\p{C}", "");
            NodoUsuario recorrido = listaAdy[i].getHead().getNext();
            
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
    
 
    /**
     * Descripcion: Algoritmo de Kosaraju
     * @autor: Maria Martinez
     * @version: 29/09/23
     */
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
        
        gr.setSCC(",");
        while (!pila.IsEmpty()) {
            int id = pila.EliminarNodo();

            if (!visited[id]) {
                SCC = gr.DFSUtil(id, visited);
            }
        }
        
        SCC = SCC.substring(1, SCC.length());
        if (!SCC.contains("-")){
            SCC += "0";
            String [] divide = SCC.split("-");
            MostrarSCC(divide);
        } else {
            String [] divide = SCC.split("-");
            MostrarSCC(divide);
        }
        
    }
    
    /**
     * Descripcion: Inserta en una pila el nodo de los usuarios segun el recorrido de las conecciones
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param id: Indica el id del usuario a buscar
     * @param visited: Array de elementos booleanos, donde cada posicion corresponde a un usuario
     * @param pila: Pila donde se almacenaran nodos usuario
     */
    public void fillOrder(int i, boolean visited[], Pila pila) {
        visited[i] = true;
        NodoUsuario recorrido = listaAdy[i].getHead().getNext();
        
        while (recorrido != null){
            if (!visited[recorrido.getId()])
                fillOrder(recorrido.getId(), visited, pila);
            recorrido = recorrido.getNext();
        }

        pila.InsertarNodo(i);
    }
    
    
     /**
     * Descripcion: Genera el grafo transpuesto
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @return Grafo transpuesto
     */
    public Grafo getTranspose() {
        Grafo g = new Grafo(cantidadVertices);
        for (int i = 0; i < cantidadVertices; i++) {
            int idUser = listaAdy[i].getHead().getId();
            String user = listaAdy[i].getHead().getDato();
            NodoUsuario recorrido = listaAdy[i].getHead().getNext();

           
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
    
    
    /**
     * Descripcion: Busqueda en profundidad para saber los nodos fuertemente conectados
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param id: Indica el id del usuario a buscar
     * @param visited: Array de elementos booleanos, donde cada posicion corresponde a un usuario
     * @return String que contiene el tipo de coneccion entre los usuarios segun su id
     */
    public String DFSUtil(int id, boolean visited[]) {
        visited[id] = true;
        int n;
        NodoUsuario recorrido = listaAdy[id].getHead().getNext();
        
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
        
        
        if (!SCC.contains("," + Integer.toString(id) + ",") && !SCC.contains("," + Integer.toString(id) + "-") && !SCC.contains("-" + Integer.toString(id) + ",") && !SCC.contains("-" + Integer.toString(id) + "-")){
            SCC += Integer.toString(id) + "-";
        }
        return SCC;
    }
    
    /**
     * Descripcion: Genera los nodos y aristas del grafo para su representacion visual con los componentes fuertemente conectados (SCC) haciendo uso de la libreria GraphStream
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param S: Array que contiene el id de los usuarios y cuales son fuertemente conectados
     */
    public void MostrarSCC(String S []){
        Graph graph = new MultiGraph("Grafo");
        System.setProperty("org.graphstream.ui", "swing");
        graph.setAttribute("ui.stylesheet", "node{\n" +
                "    size: 30px, 30px;\n" +
                "    fill-color: #f7f7f0;\n" +
                "    text-mode: normal; \n" +
                "    text-size: 17; \n" +
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
            NodoUsuario recorrido = listaAdy[i].getHead().getNext();
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
    
    
    /**
     * Descripcion: Inserta los nodos fuertemente conectados en el grafo de GraphStream dado un color
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param nodes: Array que contiene los id de los usuarios
     * @param graph: Grafo de GraphStream
     * @param rbg: Color en rbg para los nodos
     */
    public void NodosSCC(String nodes[], Graph graph, String rbg){
        for (int j = 0; j < nodes.length; j++){
            int id =  Integer.parseInt(nodes[j]);
            String etiqueta = listaAdy[id].getHead().getDato().replaceAll("\\p{C}", "");
            graph.addNode(etiqueta).setAttribute("ui.label", etiqueta);

            Node n = graph.getNode(etiqueta);
            n.setAttribute("ui.style", rbg);
        }
    }
    
    
    /**
     * Descripcion: Genera los colores en rbg para cada conjunto de nodos fuertemente conectados
     * @autor: Maria Martinez
     * @version: 29/09/23
     * @param usuario: Indica la cantidad de SCC
     * @return Array donde cada elemento corresponde al color rbg de cada conjunto de nodos fuertemente conectados
     */
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

    public void setSCC(String SCC) {
        this.SCC = SCC;
    }
    
    
   
} 
