import java.util.Scanner;

public class P2ejerc2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        int contador=1, mayor=0;
        int num;
        
        while(contador<11){
            System.out.println("Ingrese numero "+ contador);
            num=scan.nextInt();
            if(num<0){
                num*=-1;
            }
            
            if(num>mayor){
                mayor=num;
            }
            contador++;
        }
        System.out.println("El numero mayor es: "+mayor);
        scan.close();
    }
}