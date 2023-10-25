package Exec;
import Bases.*;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese la base del numero inicial: Base 10(10) Base 2(2) Base 8(8) Base Hexadecimal(1F)");
        String b=" ";
        String cb1=sc.nextLine();
        Base base1;
        base1=new Binario("0");             //Temporal
        if (cb1.equals("10")){
            try{
            System.out.println("Ingrese el número en base 10: ");
            b=sc.nextLine();
            base1=new Decimal(b);
            }catch (IllegalArgumentException e){
                e.getMessage();
            }
        }
        else if (cb1.equals("2")){
            System.out.println("Ingrese el número en base 2: ");
            b=sc.nextLine();
            base1=new Binario(b);
        }
        else if (cb1.equals("8")){
            System.out.println("Ingrese el número en base 8: ");
            b=sc.nextLine();
            base1=new Octal(b);
        }
        else if (cb1.equals("1F")){
            System.out.println("Ingrese el número en base hexadecimal: ");
            b=sc.nextLine();
            base1=new Hexadecimal(b);
        }
        System.out.println("A que base-Base 10(10) Base 2(2) Base 8(8) Base Hexadecimal(1F)- desea transformar "+base1);
        String cb2=sc.nextLine();
        if (cb2.equals("10")){
            System.out.println(base1.convertirDecimal());
        }
        else if (cb2.equals("2")){
            System.out.println(base1.convertirBinario()); 
        }
        else if (cb2.equals("8")){
            System.out.println(base1.convertirOctal());
        }
        else if (cb2.equals("1F")){
            System.out.println(base1.convertirHexadecimal());
        }
    }
}
