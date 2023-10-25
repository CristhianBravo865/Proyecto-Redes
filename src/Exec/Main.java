package Exec;
import Bases.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese la base del número inicial: Base 10(10) Base 2(2) Base 8(8) Base Hexadecimal(1F)");
        String cb1 = sc.nextLine();
        Base base1 = null; 

        try {
            if (cb1.equals("10")) {
                System.out.println("Ingrese el número en base 10: ");
                String b = sc.nextLine();
                base1 = new Decimal(b);
            } 
            else if (cb1.equals("2")) {
                System.out.println("Ingrese el número en base 2: ");
                String b = sc.nextLine();
                base1 = new Binario(b);
            } 
            else if (cb1.equals("8")) {
                System.out.println("Ingrese el número en base 8: ");
                String b = sc.nextLine();
                base1 = new Octal(b);
            } 
            else if (cb1.equals("1F")) {
                System.out.println("Ingrese el número en base hexadecimal: ");
                String b = sc.nextLine();
                base1 = new Hexadecimal(b);
            } 
            else {
                System.out.println("Base no válida. Debe ser 10, 2, 8 o 1F.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        if (base1 != null) {
            System.out.println("A qué base-Base 10(10) Base 2(2) Base 8(8) Base Hexadecimal(1F)- desea transformar " + base1);
            String cb2 = sc.nextLine();

            try {
                if (cb2.equals("10")) {
                    System.out.println(base1.convertirDecimal());
                } else if (cb2.equals("2")) {
                    System.out.println(base1.convertirBinario());
                } else if (cb2.equals("8")) {
                    System.out.println(base1.convertirOctal());
                } else if (cb2.equals("1F")) {
                    System.out.println(base1.convertirHexadecimal());
                } else {
                    System.out.println("Base de salida no válida. Debe ser 10, 2, 8 o 1F.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
