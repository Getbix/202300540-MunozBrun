public class NodoSE<T>{
    private T         dato;
    private NodoSE<T> suc;
    
    public NodoSE(){
        dato = null;
        suc  = null;
    }
    
    public NodoSE(T dato){
        this.dato = dato;
        suc  = null;
    }
    
    public T getDato(){
        return dato;
    }
    
    public NodoSE<T> getSuc(){
        return suc;
    }
    
    public void setDato(T datoT){
        dato = datoT;
    }
    
    public void setSuc(NodoSE<T> nodoSuc){
        suc = nodoSuc;
    }
}
