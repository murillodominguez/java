package Fibonacci;

import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Fibonacci {
    //static: classes não instanciadas, não podem ser derivadas, e é trancada por padrão. É usada para funções utilitárias.
    //métodos static e membros static não são alterados -> NÃO NECESSITAM DE OBJECT STATE
    //final: declara a classe de último nível de detalhamento (lowest level). Ou seja, a classe não pode ser estendida.
    //ponto de entrada -> ENTRY-POINT: é o ponto que todo sistema busca para inicializar o seu programa.
    public static void main(String[] args) {
        //  System.out.println("texto");
        FiboList fibolist = new FiboList(40);
        System.out.println(fibolist.fiboListToString());
    }
}
