package it.unibo.inner;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class ImplementIterableWithPolicy<T> implements IterableWithPolicy<T> {

    T[] array;
    Predicate<T> filter;

    public ImplementIterableWithPolicy (T[] array ){
        this(array, new Predicate<T>() {
            @Override
            public boolean test(T elem) {
                return true;
            }
            
        });
    }

    public ImplementIterableWithPolicy (T[] array, Predicate<T> filter){
        this.array=array;
        this.filter=filter;
    }

    @Override
    public void setIterationPolicy(Predicate<T> filter) {
        this.filter=filter;
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
