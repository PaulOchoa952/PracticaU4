/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p_a_u
 */
public class NodoVertice {
  char dato;
NodoVertice sig;
NodoVertice ant;
NodoArista ari;

    public NodoVertice(char d) {
        dato=d;
        sig=ant=null;
        ari=null;
        
    }

public boolean insertarArista(NodoVertice direccion){
        NodoArista nuevo= new NodoArista(direccion);
        if(ari==null){
        ari=nuevo;
        return true;
        }
        irUltimo();
        ari.abajo=nuevo;
        nuevo.arriba=ari;
        return true;
        
    }

    private void irUltimo() {
      while(ari.abajo!=null){
        ari=ari.abajo;
      
        }

    }
   private void irPrimero(){
        while(ari.arriba!=null){
        ari=ari.arriba;}
        } 
    public NodoArista buscarArista(NodoVertice direccion){
   if(ari==null)return null;
        irPrimero();
    for(NodoArista buscar=ari;buscar!=null;buscar=buscar.abajo){
        
    if(buscar.Direccion==direccion)return buscar;
        }
    return null;
    }
    
    private boolean unaSolaArista(){
    return ari.abajo==null && ari.arriba==null;
    }

    public boolean eliminarArista(NodoVertice direccion) {
        if(ari==null)return false;
        NodoArista temp= buscarArista(direccion);
        
        if(temp==null)return false;
        if(temp==ari){
             if(unaSolaArista())ari=null;
             else{
             ari=ari.abajo;
             temp.abajo.arriba=temp.abajo=null;
             }
             return true;
        }
        
        if(temp.abajo==null){
            temp.arriba.abajo=temp.arriba=null;
            return true;
        }
        
        temp.arriba.abajo=temp.abajo;
        temp.abajo.arriba=temp.arriba;
        temp.abajo=temp.arriba=null;
        return true;
    }
    public String toString() {
        String res = "[" + dato + "]";
        NodoArista aux = ari;
        while (aux != null) {
            res += "->" + aux.Direccion.dato;
            aux = aux.abajo;
        }
        return res;
    }
}
