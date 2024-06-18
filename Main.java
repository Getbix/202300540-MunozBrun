import java.util.Arrays;

public class Main{
    public static void main(String[] args){
        OrganizadorDeMatryoshka orMatryoshka = new OrganizadorDeMatryoshka();
        ListaCSE<Integer> listaCSE = new ListaCSE<>();
        
        System.out.println("Solucion al problema de Tobby");
        System.out.println("Matris ingresada: a, b, c, a, c, a, b");
        String[] s = {"a", "b", "c", "a", "c", "a", "b"};
        String[][] resultado = orMatryoshka.ordenar(s);
        System.out.println("Resultado:");
        for(String[] subarray : resultado) {
            System.out.println(Arrays.toString(subarray));
        }
        System.out.println("*\n*\n*\n*\n*");
        System.out.println("Solucion al ejercicio 2:");
        System.out.println("Datos en la lista (0, 1, 2, 3, 4, 5, 6)");
        listaCSE.insertar(0);
        listaCSE.insertar(1);
        listaCSE.insertar(2);
        listaCSE.insertar(3);
        listaCSE.insertar(4);
        listaCSE.insertar(5);
        listaCSE.insertar(6);
        System.out.println("Usando el metodo swap(3,6)");
        listaCSE.swap(3, 6);
        for(int i = 0; i < listaCSE.longitud(); i++){
            int dato = listaCSE.acceder(i);
            System.out.print(dato + " ");
        }
    }
}
