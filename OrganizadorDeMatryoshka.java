import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrganizadorDeMatryoshka{
    public static String[][] ordenar(String[] s){
        Arrays.sort(s);
        List<List<String>> resultadoListas = new ArrayList<>();
        List<String> actualLista = new ArrayList<>();
        
        for(int i = 0; i < s.length; i++){
            if(i == 0 || !s[i].equals(s[i - 1])){
                actualLista.add(s[i]);
            } else{
                actualLista.add(s[i]);
            }
            if(i == s.length - 1 || !s[i].equals(s[i + 1])){
                resultadoListas.add(new ArrayList<>(actualLista));
                actualLista.clear();
            }
        }
        String[][] resultado = new String[resultadoListas.size()][];
        for (int i = 0; i < resultadoListas.size(); i++){
            List<String> lista = resultadoListas.get(i);
            resultado[i] = lista.toArray(new String[0]);
        }
        return resultado;
    }
}
