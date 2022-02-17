package Q3;
import java.util.*;
import java.util.ArrayList;

public class Q3_Java {
    static final int max = 256;
    /*@param numero a ser realizado fatorial
    @return resultado da operacao
    */
    public static int fatorial(int b)
    {
        int c = 1;
        for(int i=1; i<b;i++ )
        {
            c*=i;
        }
        if(b==0 || b==1)
        {
            return 1;
        }
        else
        {
            return c;
        }
    }
    /*@param char 1, 2
    @return comparacao true ou falsa*/ 
    public static boolean comparar(char str1[], char str2[])
    {
        for(int i=0; i<max; i++)
        {
            if(str1[i]!=str2[i])//se retornar vdd, os conteudos dos dois vetores sao iguais
                return false; 
        }
        return true;
    }
    /*@param string, substring
    @return pares de substring na string */
    public static int calculaAnag(String primeira, String segunda){
        int m = primeira.length(); 
        int n = segunda.length();
        int num = 0;
        char[] contagem1 = new char[max];
        char[] contagem2 = new char[max];//vetores do tamanho maximo de um character 256

        for(int i=0; i<n;i++)
        {
            (contagem1[primeira.charAt(i)])++;
            (contagem2[segunda.charAt(i)])++;
        }
        for(int i=n; i<m;i++){
            if(comparar(contagem1, contagem2))//realiza a contagem ao longo das strings primeira (fornecida) e segunda (substring)
            {
                num+=1;
            }
            (contagem1[primeira.charAt(i)])++;
            (contagem1[primeira.charAt(i-n)])--;
        }
        if(comparar(contagem1, contagem2))
            num+=1;
        if(num==1 || num==0)//se num=1 ou num = 0, nao existem pares, logo, retorna 0
        {
            return 0;
        }
        else//do contrario retorna as permutacoes
        {
            return (fatorial(num)/(fatorial(2)*fatorial(num-2)));//calcular a quantidade de pares para a contagem de cada palavra igual, combinacao de n para 2
        } 
    }
    /*
    @param string
    @return string sem repeticoes
    */
    public static String Sort(String palavra)
    {
        char[] p = palavra.toCharArray();//conversao de string pra array de char

        ArrayList<Character> x = new ArrayList<Character>(); //conversao do array pra lista
        for(int i=0; i<palavra.length();i++)
        {
            x.add(p[i]); //adicao de cada elemento do array na lista
        }
       //remocao dos elementos repetidos para nao ser realizada a contagem dupla deles na funcao do anagrama
        for(int i=0; i<x.size(); i++)
        {
            for(int j=i+1; j<x.size(); j++)
            {
                if(x.get(i) == x.get(j))//bubble sort para remover os elementos repetidos
                {
                    x.remove(j);
                }
            }
        }

        char[] ab = new char[x.size()];//criacao de um outro vetor char para retornar

        for(int i=0; i<x.size();i++)
        {
            ab[i] = x.get(i); //preenchimento desse vetor com os elementos da lista após remoção ou não de elementos
        }

        String retorno = String.valueOf(ab); //conversao do array char para string
        //System.out.println(retorno); //debug no terminal para saber se retorna a string correta
        return retorno; 
    }
    /*@param palavra
    @retorno true or false se é palíndromo ou não
     */
    public static boolean verificaPalindromo(String palavra)//necessario pois como a funcao que retira as repeticoes faz com que a contagem n funcione para palindromos
    {
        char[] p = palavra.toCharArray();
        char[] comp = new char[palavra.length()]; 
        int j=0;
        int k=0; 
        for(int i=palavra.length()-1; i>=0; i--)
        {
            comp[i] = p[j];
            j++; 
        }

        for(int i=0; i<palavra.length();i++)
        {
            if(Character.compare(p[i],comp[i])==0)//sigfica que é igual
            {
                k++; 
            }
        }
        if(k==palavra.length())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static int retornaAnag(String palavra, int n)
    {
        int x = 0; 
         //calcula os anagramas baseado em subs.length()^2 substrings
        if(n!=palavra.length())
        {
            for(int i = 0; i<n/2; i++)
            {
                for(int j=0; j<n+1; j++)
                {
                    //evita repetições de calculo
                    if(i<j){ // i<j pois é desnecessario uma string de 7 a 1
                        // a = x; 
                        //x=calculaAnag(palavra, subs.substring(i,j));//calcula a quantidade de anagramas baseado na combinação de palavras da string fornecida
                        x+=calculaAnag(palavra, palavra.substring(i,j));;
                        System.out.println(palavra.substring(i,j));
                        //System.out.println(x);
                    }
                }
            }
        }
        else
        {
            for(int i = 0; i<n; i++)
            {
                for(int j=0; j<n+1; j++)
                {
                    //evita repetições de calculo
                    if(i<j){ // i<j pois é desnecessario uma string de 7 a 1
                        // a = x; 
                        //x=calculaAnag(palavra, subs.substring(i,j));//calcula a quantidade de anagramas baseado na combinação de palavras da string fornecida
                        x+=calculaAnag(palavra, palavra.substring(i,j));;                        
                        //System.out.println(x);
                    }
                }
            }
        }
        return x;
    }
    public static int verificaAnag(String palavra)
    {
        int x = 0, n=0;
        String subs = Sort(palavra);
        //int a =0;
        if(verificaPalindromo(palavra))//para palíndromo a lógica é diferente
        {
            n = palavra.length() - 1;
            x = retornaAnag(palavra, n);
        }
        else
        {
            n = subs.length();
            x = retornaAnag(subs, n);
        }
        return x;
    }
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in); 
        System.out.println("String: "); 

        String anagrama = sc.nextLine(); //Lê a senha
        //transforma anagrama pra lowercase, melhor de realizar a comparacao ja que java é case-sensitive
        System.out.println(verificaAnag(anagrama.toLowerCase()));
        
        sc.close();
    }
}
