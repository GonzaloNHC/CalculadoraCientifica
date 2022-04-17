import java.util.Scanner;

public class Escuaciones {
    public static void main(String[] args) {
        ResolverSistemaecuacioneslineales();
    }
    public static void ResolverSistemaecuacioneslineales(){
        double A,B,C,D,E,F,x,y;
        System.out.print("A: ");
        A = Teclado();
        System.out.print("B: ");
        B = Teclado();
        System.out.print("C: ");
        C = Teclado();
        System.out.print("D: ");
        D = Teclado();
        System.out.print("E: ");
        E = Teclado();
        System.out.print("F: ");
        F = Teclado();
        x = (C*E-B*F)/(A*E-B*D);
        y = (A*F-C*D)/(A*E-B*D);
        Imprimir(x,"x= ");
        Imprimir(y,"y= ");
    }
    public static double Teclado(){
        Scanner teclado = new Scanner(System.in);
        String numero;
        double num = 0;
        try {
            numero = teclado.next();
            numero = numero.replaceAll(",",".");
            num = Double.parseDouble(numero);
        }catch (Exception e){
            System.out.println("Dato invalido");
        }
        return num;
    }
    public static void Imprimir(double datos,String opcion){
        System.out.println(opcion + datos);
    }
}
