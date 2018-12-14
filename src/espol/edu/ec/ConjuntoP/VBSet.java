/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.ConjuntoP;

/**
 *
 * @author joel
 */
public class VBSet {
    private boolean[] vector; 
    private int capacity =100;
    private int efectivo;
    
    public VBSet(){
        vector = new boolean[capacity];
        efectivo = 0;
    }
    
    public boolean isEmpty(){
        return efectivo == 0;
    }
    
    public boolean add(int element){
        if(element < 0 || element>=capacity ||vector[element])
            return false;
        vector[element] = true;
        efectivo++;
        return true;
    }
    
    public boolean remove(int element){
        if(element < 0 || element>=capacity || !vector[element])
            return false;
        vector[element]=false;
        efectivo--;
        return true;
    }
    
    public VBSet intersection(VBSet s){
        VBSet result = new VBSet();
        if(this.isEmpty() || s.isEmpty())
            return result;
        //result.vector[i]= this.vector[i] && s.vector[i];
        //if(result.vector[i])
        // result.efectivo++
        for(int i = 0;i<capacity;i++){
            if(this.vector[i] && s.vector[i])
                result.vector[i]=true;
                result.efectivo++;
        }
        
        return result;
    }
    
    public VBSet union(VBSet s){
        VBSet result = new VBSet();
        if(s.isEmpty() && this.isEmpty())
            return result;
        for(int i =0;i<capacity;i++){
            if(this.vector[i] || s.vector[i])
                result.vector[i] = true;
            result.efectivo++;
        }
        return result;
    }
    
    public VBSet diferenciaSimetrica(VBSet s){
        VBSet result = new VBSet();
        if(s.isEmpty() && this.isEmpty())
            return result;
        for(int i =0;i<capacity;i++){
            if((this.vector[i] || s.vector[i])&& !this.vector[i]==s.vector[i])
                result.vector[i] = true;
            result.efectivo++;
        }
        return result;
    }
    
    public VBSet diference(VBSet s){
        VBSet result = new VBSet();
        if(this.isEmpty())
            return result;
        for(int i =0;i<capacity;i++){
            result.vector[i] = this.vector[i] &&!s.vector[i];
            if(result.vector[i])
                result.efectivo++;
        }
        return result;
    }
  
    public String toString(){
        String s = "{";
        for(int i =0;i<capacity;i++){
            if(vector[i]){
                s+=i;
                if(i<capacity-1){
                    s+=" ,";
                
                    
                }
                
            }
        }
        s+="}";
        return s;
    }
    
     //Leccion
    @Override
        public boolean equals(Object o ){
            if(o == null || !(o instanceof VBSet)){
                return false;
            }
            VBSet s = (VBSet)o;
            if(this.efectivo!=s.efectivo){
                return false;
            }else {
                for(int i = 0;i<capacity;i++){
                    if(this.vector[i]!=s.vector[i]){
                        return false;
                    }
                }
            }
            return true;
        }
    
    public static void main(String[] args){
        VBSet c1 = new VBSet();
        c1.add(0);
        c1.add(2);
        c1.add(4);
        VBSet c2 = new VBSet();
        c2.add(0);
        c2.add(2);
        c2.add(4);
        VBSet c3 = new VBSet();
        c3.add(0);
        c3.add(1);
        c3.add(4);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        VBSet c4 =c3.diferenciaSimetrica(c2);
        System.out.println(c4.toString());
        
    }
}
