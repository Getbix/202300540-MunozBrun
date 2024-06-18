public class ListaCSE<T> implements Lista<T>{
    private NodoSE<T> ini;
    private int       longitud;
    
    public ListaCSE(){
        ini = new NodoSE<T>();
        ini.setSuc(ini);
        longitud = 0;
    }
    
    public boolean vacia(){
        return longitud == 0;
    }
    
    public void insertar(T dato){
        NodoSE<T> datoNodo = new NodoSE<T>(dato);
        if(vacia()){
            ini.setDato(dato);
            longitud++;
        }else{
            NodoSE<T> actual = ini;
            while(actual.getSuc() != ini){
                actual = actual.getSuc();               
            }
            actual.setSuc(datoNodo);
            datoNodo.setSuc(ini);
            longitud++;
        }
    }
    
    public void insertar(T dato, int pos){
        NodoSE<T> datoNodo = new NodoSE<T>(dato);
        
        if(pos > 0 && pos <= longitud){
            if(pos == 0){
                NodoSE<T> siguiente = ini;
                ini.setDato(dato);
                ini.setSuc(siguiente);
            }else{
                NodoSE<T> actual = ini;
                for (int i = 0; i < pos; i++){
                    if(i++ == pos){
                        actual.setSuc(datoNodo);
                        datoNodo.setSuc(actual.getSuc());
                    }
                    actual = actual.getSuc();
                }
            }
            longitud++;
        }
    }
    
    public void eliminar(int pos){
        NodoSE<T> nodoSegundoSucesor = new NodoSE<T>();
        if(pos > 0 && pos <= longitud){
            if(pos == 0){
                if(ini.getSuc().equals(ini)){
                    ini = null;
                }else{
                    ini = ini.getSuc();
                }
            }else{
                NodoSE<T> actual = ini;
                nodoSegundoSucesor = actual.getSuc().getSuc();
                for (int i = 0; i < pos; i++) {
                    if(i++ == pos){
                        actual.setSuc(nodoSegundoSucesor);
                    }
                    actual = actual.getSuc();
                }
            }
            longitud--;
        }
    }
    
    public void eliminar(T dato){
        NodoSE<T> datoNodo = new NodoSE<T>();
        if(ini.getDato().equals(dato)){
            if(ini.getSuc().equals(ini)){
                    ini = null;
            }else{
                ini = ini.getSuc();
            }
        }else{
            NodoSE<T> actual = ini.getSuc();
            while(actual.getDato() != dato){
                if(actual.getSuc().equals(dato)){
                    actual.setSuc(datoNodo);
                    datoNodo.setSuc(actual.getSuc());
                }
                if(actual.equals(ini)){
                    return;
                }
                actual = actual.getSuc();
            }
        }
        longitud--;
    }
    
    public T acceder(int pos){
        T datoR= null;
        if(pos >= 0 && pos < longitud){
            NodoSE<T> actual = ini;
            for(int i = 0; i != pos; i++){
                actual = actual.getSuc();
            }
            datoR = actual.getDato();
        }
        return datoR;
    }
    
    public Lista<T> invertir(){
        Lista<T> listaInvertida = new ListaCSE<T>();
        NodoSE<T> actual = ini;
        for(int i = 0; i < longitud ; i++){
            listaInvertida.insertar(actual.getDato(), 0);
            actual = actual.getSuc();
        }        
        return listaInvertida;
    }
    
    public int longitud(){
        return longitud;
    }
    
    public boolean buscar(T dato){
        boolean resultado = false;
        NodoSE<T> actual = ini;
        for(int i = 0; i < longitud ; i++){
            if(actual.getDato().equals(dato)){
                resultado = true;
            }
        } 
        return resultado;
    }
    
    public void vaciar(){
        ini = null;
        longitud = 0;
    }
    
    public T antecesor(T dato){
        T datoR = null;
        NodoSE<T> actual = ini;
        for(int i = 0; i < longitud ; i++){
            T datoSuc = actual.getSuc().getDato();
            if(datoSuc.equals(dato)){
                datoR = actual.getDato();
            }
        }
        return datoR;
    }
    
    public T sucesor(T dato){
        T datoR = null;
        NodoSE<T> actual = ini;
        for(int i = 0; i < longitud ; i++){
            if(actual.getDato().equals(dato)){
                datoR = actual.getSuc().getDato();
            }
        }
        return datoR;
    }
    
    public int indiceDe(T dato){
        int indice = -1;
        NodoSE<T> actual = ini;
        for(int i = 0; i < longitud; i++){
            if(actual.getDato().equals(dato)){
                indice = i;
            }
            actual = actual.getSuc();
        }
        return indice;
    }
    
    public void swap(int indiceElementoA, int indiceElementoB) {
        if (indiceElementoA >= 0 && indiceElementoA < longitud && indiceElementoB >= 0 && indiceElementoB < longitud) {
            // Obtener los datos en los índices especificados
            T datoA = acceder(indiceElementoA);
            T datoB = acceder(indiceElementoB);
            
            // Reemplazar los datos en los índices
            reemplazar(indiceElementoA, datoB);
            reemplazar(indiceElementoB, datoA);
        } else {
            throw new IndexOutOfBoundsException("Índices fuera de rango");
        }
    }

    public void reemplazar(int pos, T dato) {
        if (pos >= 0 && pos < longitud) {
            NodoSE<T> actual = encontrarNodoPorIndice(pos);
            actual.setDato(dato);
        } else {
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
    }
    
    private NodoSE<T> encontrarNodoPorIndice(int indice) {
        NodoSE<T> actual = ini;
        for (int i = 0; i < indice; i++) {
            actual = actual.getSuc();
        }
        return actual;
    }
}
