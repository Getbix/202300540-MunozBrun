import java.util.*;

public class OrganizadorDeMatryoshka{
    public static String[][] ordenar(String[] s){
        List<String> listaMuñecasUnicas = new ArrayList<>();
        for(String muñeca : s){
            if(!listaMuñecasUnicas.contains(muñeca)){
                listaMuñecasUnicas.add(muñeca);
            }
        }
        Collections.sort(listaMuñecasUnicas);
        int[] conteos = new int[listaMuñecasUnicas.size()];
        for(String muñeca : s){
            int indice = listaMuñecasUnicas.indexOf(muñeca);
            conteos[indice]++;
        }
        int numConjuntos = 0;
        for(int conteo : conteos){
            if(conteo > numConjuntos){
                numConjuntos = conteo;
            }
        }
        List<String>[] conjuntos = new List[numConjuntos];
        for(int i = 0; i < numConjuntos; i++){
            conjuntos[i] = new ArrayList<>();
        }
        int[] mapaIndices = new int[listaMuñecasUnicas.size()];
        for(String muñeca : s){
            int indiceUnico = listaMuñecasUnicas.indexOf(muñeca);
            int indiceConjunto = mapaIndices[indiceUnico];
            conjuntos[indiceConjunto].add(muñeca);
            mapaIndices[indiceUnico]++;
        }
        String[][] resultado = new String[numConjuntos][];
        for(int i = 0; i < numConjuntos; i++){
            List<String> conjunto = conjuntos[i];
            Collections.sort(conjunto);
            resultado[i] = conjunto.toArray(new String[0]);
        }
        return resultado;
    }
}
