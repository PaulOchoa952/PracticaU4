/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p_a_u
 */
public class NodoArista {
     NodoArista abajo;
     NodoArista arriba;
     NodoVertice Direccion;
     
      
     public NodoArista(NodoVertice d){
     Direccion=d;
     abajo=arriba=null;
     }
}
