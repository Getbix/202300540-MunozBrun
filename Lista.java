public interface Lista<T>{
    boolean vacia();
    void insertar(T dato);
    void insertar(T dato, int pos);
    void eliminar(int pos);
    void eliminar(T dato);
    T acceder(int pos);
    Lista<T> invertir();
    int longitud();
    boolean buscar(T dato);
    void vaciar();
    T antecesor(T dato);
    T sucesor(T dato);
    void reemplazar(int pos, T dato);
    int indiceDe(T dato);
}