package Q1;
import java.util.*;
//Permite que o usuário forneça uma entrada, nesse caso n;
public class Q1_Java {
    //Funcao que realiza a escada para uma escada de altura n
    /*@param altura da escada
    @return escada */
    public static void escada(int altura)
    {
        int m = altura; 
        //Para uma altura de n, teremos um for para printar os "degraus" da escada
        for(int j =0; j<altura; j++)
        {
            //Variaveis auxiliares k e l
            int k =0, l =0;
            /*A logica começa do degrau superior, então começa por espaços até a posição
            garantida pelo while*/
            while(l<m-1)
            {
                System.out.print(" "); 
                l+=1;
            }
            //Garante a diminuicao de um espaço no degrau inferior
            m-=1;  //Printa os '*' de 1 até n
            while(k!=j+1)
            {
                System.out.print("*");
                k+=1;
            }
            //Passa para a próxima linha
            //System.out.println(m);
            if(m!=0)
            {
                System.out.print("\n");
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();

        escada(n);
        sc.close();
    }
}