package Q2;
import java.util.*;
import  java.util.regex.*;

public class Q2_Java {
    /*@param string senha 
    @return numero de caracteres que falta pra senha ser segura */
    public static int verifica(String senha)
    {
        int[] cont = {0,0,0,0};
        //variavel auxilar para ajudar a contar a quantidade de caracteres necessarios
        int aux = 0; 
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+]).{6,}$";

        Pattern n = Pattern.compile(regex); 
        
        Matcher m1 = n.matcher(senha); 

        //Verifica se a string corresponde ao pattern dado pela expressão regular
        //teste inicial, se a senha for forte, já retorna 0
        if(m1.matches())
        {
            System.out.println(m1.matches());
            return 0; 
        }
        for (int i = 0; i<senha.length(); i++)
        {
            //contando digitos
            if((int)senha.charAt(i) >=48 && (int)senha.charAt(i) <=57)
            {
                cont[0] += 1; 
            }
            //letra minuscula
            else if((int)senha.charAt(i) >=97 && (int)senha.charAt(i) <=127)
            {
                cont[1] +=1;
            }
            //letra maiuscula
            else if((int)senha.charAt(i) >=65 && (int)senha.charAt(i) <=90)
            {
                cont[2] += 1; 
            }
            //caracteres especiais *! = 33 #,$,&,% = 35 a 38 ()*+ = 40-43 - = 45
            /*@ 64
            ^ 94
            */
            else if((int)senha.charAt(i) == 33 || (int)senha.charAt(i) == 45 || (int)senha.charAt(i) == 94 || (int)senha.charAt(i) == 64 || ((int)senha.charAt(i) >= 35 && (int)senha.charAt(i) <= 38) || ((int)senha.charAt(i) >= 40 && (int)senha.charAt(i) <= 43) )
            {
                cont[3] += 1; 
            }
        }
        for(int j=0; j<4;j++)
        {
            if(cont[j] == 0)//se cont[j] for igual a zero, significa que uma das condicoes nao é aceita
            {
                aux+=1; //conta quais dessas condiçoes, aux é a quantidade de caracteres p atender as condicoes
            }
        }
        if(aux >= 0 && senha.length() < 6)//o caso aux == 0 && senha.length>=6 é feito pela expressao regular
        {
            return (6-senha.length());//se length < 6, temos que falta 6 - length para tornar a string forte
        }
        else
        {
            return aux; 
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Senha: "); 

        String password = sc.nextLine(); //Lê a senha

        System.out.println(verifica(password));
        
        sc.close();
    }
}