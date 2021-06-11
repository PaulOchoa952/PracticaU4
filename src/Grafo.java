/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p_a_u
 */
public class Grafo {
    NodoVertice vertice;
    
    public Grafo(){
        vertice=null;
    }
    public boolean insertarVertice(char dato){
        NodoVertice nuevo= new NodoVertice(dato);
        if(nuevo==null) return false;
        
        if(vertice==null){
            vertice=nuevo;
            return true;
        }
        
        
        irUltimo();
        vertice.sig=nuevo; 
        nuevo.ant=vertice;  
        return true;
    }

    private void irUltimo() {
        while(vertice.sig!=null){ 
            vertice=vertice.sig;
        }
    }
    private void irPrimero(){
        while(vertice.ant!=null){
            vertice=vertice.ant;
        }
    }
    private NodoVertice buscarVertice(char dato){
        if(vertice==null) return null;
        irPrimero();
        for(NodoVertice buscar=vertice; buscar!=null; buscar=buscar.sig){
            if(buscar.dato==dato){
                return buscar;
            }
        }
        return null;
    }
    public boolean insertarArista(char origen, char destino){
        NodoVertice nodoOrigen=buscarVertice(origen);
        NodoVertice nodoDestino=buscarVertice(destino);
        
        if(nodoOrigen==null || nodoDestino==null){
            return false;
        }
        
        return nodoOrigen.insertarArista(nodoDestino);
    }
    public boolean eliminarArista(char origen, char destino){
        NodoVertice nodoOrigen=buscarVertice(origen);
        NodoVertice nodoDestino=buscarVertice(destino);
        if(nodoOrigen==null || nodoDestino==null){
            return false;
        }
        return nodoOrigen.eliminarArista(nodoDestino);
    }
    public boolean unSoloVertice(){
        return vertice.ant==null && vertice.sig==null;
    }
    public boolean eliminarVertice(char dato){
        if(vertice==null) return false;
        NodoVertice temp=buscarVertice(dato);
        if(temp==null) return false;
        
        
        if(temp.ari!=null) return false;
       
        quitaAristasDeOtrosVertice(temp);
        
        if(temp==vertice){
            if(unSoloVertice()) vertice=null;
            else{
                vertice = temp.sig;
                temp.sig.ant=temp.sig=null;
            }
            return true;
        }
         
         if(temp.sig==null){
             temp.ant.sig=temp.ant=null;
             return true;
         }
         
         temp.ant.sig=temp.sig;
         temp.sig.ant=temp.ant;
         temp.sig=temp.ant=null;
         return true;
    }

    private void quitaAristasDeOtrosVertice(NodoVertice NodoEliminar) {
        irPrimero();
        for(NodoVertice buscar=vertice; buscar!=null; buscar=buscar.sig){
            buscar.eliminarArista(NodoEliminar);
        }
    }    
    
    public boolean[][] matrizAdyacencia() {
        if (vertice == null) {
            return null;
        }
        int v = contarVertices();
        int r;
        boolean matriz[][] = new boolean[v][v];
        for (int i = 0; i < v; i++) {
            for (r = 0; r < v; r++) {
                matriz[i][r] = false;
            }
        }
        for (int i = 0; i < v; i++) {
            r = 0;
            while (i != r) {
                r++;
                vertice = vertice.sig;
            }
            NodoArista aux = vertice.ari;
            irPrimero();
            while (aux != null) {
                r = 0;
                while (aux.Direccion != vertice) {
                    vertice = vertice.sig;
                    r++;
                }
                matriz[i][r] = true;
                aux = aux.abajo;
                irPrimero();
            }
        }
        return matriz;
    }
        
    public int contarVertices() {
        if (vertice == null) {
            return 0;
        }
        int i = 0;
        irPrimero();
        NodoVertice aux = vertice;
        while (aux != null) {
            i++;
            aux = aux.sig;
        }

        return i;
    }
    
    public String listaAdyacencia(char dato) {
        
        return buscarVertice(dato) == null? "" : buscarVertice(dato).toString();
        
        
    }
        
        

}