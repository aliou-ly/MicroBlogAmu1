package servers;

public interface QueryProcessingGenerator<T,E> {

    T accept(E element);
}
