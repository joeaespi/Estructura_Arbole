/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espol.edu.ec.SortedListSet;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author joel
 */
public class SLSet<E> {
    private LinkedList<E> list;
    private Comparator<E> f;
    
    public SLSet(Comparator<E> f){
        list = new LinkedList<>();
        this.f = f;
    }
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public boolean add (E element){
        if(element ==null)
            return false;
        else if ( list.isEmpty())
            return list.add(element); // esta es addLast
        else if (f.compare(element, list.getLast())>0)
            return list.add(element);
        ListIterator<E> it= list.listIterator();
        while(it.hasNext()){
            E data = it.next();
            if(f.compare(data, element)==0){
                return false;
            }
            if(f.compare(data, element)>0){
                it.previous();
                it.add(element);
                return true;
            }
        }
        return true;
    }
    
    public String toString(){
        StringBuilder s =new StringBuilder("{");
        ListIterator<E> it = this.list.listIterator();
        while(it.hasNext()){
            E data = it.next();
            s.append(data);
            if(it.hasNext()){
                s.append(",");
            }else if(!it.hasNext()){
                s.append("}");
            }
        }
        return s.toString();
    }

    public boolean remove(E element){
        if(element ==null)
            return false;
        else if ( this.isEmpty())
            return false;
        else
            return list.remove(element);
    }
    
    public SLSet<E> union(SLSet<E> conjunto){
        SLSet<E> s = new SLSet(f);
        if(this.isEmpty()||conjunto.isEmpty()){
            return s;
        }else {
            ListIterator<E> it = list.listIterator();
            ListIterator<E> it2 = conjunto.getList().listIterator();
            while(it.hasNext() && it2.hasNext()){
                E data = it.next();
                E data2 = it2.next();
                s.add(data2);
                s.add(data);  
            }
        }
        return s;
    }


    public SLSet<E> intersection(SLSet<E> conjunto){
        SLSet<E> s = new SLSet(f);
        if(this.isEmpty()||conjunto.isEmpty()){
            return s;
        }else {
            ListIterator<E> it = this.list.listIterator();
            ListIterator<E> it2 = conjunto.getList().listIterator();
            while(it.hasNext()&& it2.hasNext()){
                E data = it.next();
                E data2 = it2.next();
                if(data.equals(data2)){
                    s.add(data);
                }
                if(f.compare(data, data2)>0){
                    it.previous();
                }else if(f.compare(data2, data)>0)
                    it2.previous();
            }
        }
        return s;
    }
    
    public SLSet<E> difference(SLSet<E> conjunto){
        SLSet<E> s = new SLSet(f);
        if(this.isEmpty()||conjunto.isEmpty()){
            return s;
        }else {
            ListIterator<E> it = this.list.listIterator();
            ListIterator<E> it2 = conjunto.getList().listIterator();
            while(it.hasNext()&& it2.hasNext()){
                E data = it.next();
                E data2 = it2.next();
                if(!data.equals(data2)){
                    s.add(data);
                }
                if(f.compare(data, data2)>0){
                    it.previous();
                }else if(f.compare(data2, data)>0)
                    it2.previous();
            }
        }
        return s;
    }
    
    //leccion
    public boolean equals(Object o){
        if(o == null || !(o instanceof SLSet)){
            return false;
        }
        SLSet sls = (SLSet)o;
        if(this.list.size()!=sls.list.size()){
            return false;
        }else {
            ListIterator it = this.list.listIterator();
            ListIterator it2 = sls.list.listIterator();
            while(it.hasNext()){
                if(!it.next().equals(it2.next())){
                    return false;
                }
            }
        }
        return true;
    }

    public LinkedList<E> getList() {
        return list;
    }

    public void setList(LinkedList<E> list) {
        this.list = list;
    }

    public Comparator<E> getF() {
        return f;
    }

    public void setF(Comparator<E> f) {
        this.f = f;
    }

}
