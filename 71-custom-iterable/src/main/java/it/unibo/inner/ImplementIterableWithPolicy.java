package it.unibo.inner;

import java.util.ArrayList;
import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class ImplementIterableWithPolicy<T> implements IterableWithPolicy<T> {

    T[] array;
    
    public ImplementIterableWithPolicy (T[] array ){
        this.array = array;
    }

    @Override
    public void setIterationPolicy(Predicate filter) {
        
    }

    public class InnerIterator implements Iterator<T>{

        private int current;

        public InnerIterator (){
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return array.length > current;
        }

        @Override
        public T next() {
            return array[current++];
        }

    }

    @Override
    public Iterator<T> iterator() {
        return this.new InnerIterator();
    }  
}
