/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.HashTable;

/**
 *
 * @author EVOTEC
 */
public class HashTable {
    private int[] table;
    private int capacity=13;
    private int[] states;
    private int efectivo = 0;
    
    public HashTable(){
        table=new int[capacity];
        states=new int[capacity];
        //o vacio, 1 ocupado, 2 eliminado
    }
    
    private int hash(int element){
        return element%capacity;
    }
     private int rehash(int element, int i){
         return (hash(element)+i)%capacity;
    }
     
    public boolean add(int element){
        if(contains(element))
            return false;
        int x =hash(element);
        if(states[x]!= 1){
            table[x]=element;
            efectivo++;
            states[x]=1;
            return true;
        }
        return add(element,1);
    }
    
    private boolean add(int element,int i){
        int x =rehash(element,i);
        if(states[x]!= 1){
            table[x]=element;
            efectivo++;
            states[x]=1;
            return true;
        }
        return add(element,++i);
    }
    
    public boolean contains(int elements){
        int x = hash(elements);
        if(states[x]== 1){
            return false;
        }else{
            return constains(elements, 1);
        } 
    }
    
    private boolean constains(int elements, int i){
        int x = rehash(elements,i);
        if(states[x]==2)
            return false;
        return constains(elements,++i);
        
    }
}


