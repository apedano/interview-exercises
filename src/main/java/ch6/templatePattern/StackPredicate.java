package ch6.templatePattern;

/**
 *La classe permette di disaccoppiare la metodologia di filtro
 */
public interface StackPredicate<E> {
    public boolean isValid(E element);
}
