import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        ResolverFigurasGeometricas();
    }

    private static void ResolverFigurasGeometricas() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Que quiere calcular?");
        int option = 0;
        while(option < 1 || option >4) {
            System.out.println("1:Perimetro 2:Area 3:Volumen 4:Salir");
            option = (int)Teclado();
        }
        switch(option){
            case 1: Imprimir(Perimetro(),"Perimetro: ");
                    break;
            case 2: Imprimir(Area(),"Area: ");
                    break;
            case 3: Imprimir(Volumen(),"Volumen");
                    break;
            case 4: break;
        }
    }

    public static double Perimetro(){
        ArrayList<Double> datos = new ArrayList<>();
        int figura = 0;
        int aristas = 0;
            while (figura < 1 || figura > 5) {
                System.out.println("1:Cuadrado 2:Rectangulo 3:Circulo 4:Esfera 5:Cubo");
                figura = (int)Teclado();
            }
            switch (figura) {
                case 1:
                    aristas = 4;
                    System.out.print("aristas: ");
                    break;
                case 2:
                    aristas = 2;
                    System.out.print("arista 1: ");
                    datos = datos(datos, aristas);
                    System.out.print("aristas 2: ");
                    break;
                case 3:
                    aristas = 1;
                    System.out.print("radio: ");
                    break;
                case 4:
                    aristas = 1;
                    System.out.print("radio: ");
                    break;
                case 5:
                    aristas = 12;
                    System.out.print("aristas: ");
                    break;
            }
        datos = datos(datos,aristas);
        if (figura == 3 || figura == 4) {
            return (2*Math.PI*SumarArreglo(datos));
        }
        return SumarArreglo(datos);
    }
    public static ArrayList<Double> datos(ArrayList<Double> datos,int aristas){
        double dato = 0;
        int ingresarDato = 1;
        for (int i = 0; i < aristas; i++) {
            if(ingresarDato > 0){
                dato = Teclado();
                ingresarDato--;
            }
        datos.add(dato);
        }
        return datos;
    }
    public static double SumarArreglo(ArrayList<Double> datos){
        double suma = 0;
        for (int i = 0; i < datos.size(); i++) {
            suma = suma + datos.get(i);
        }
        return suma;
    }
    public static double Area(){
        ArrayList<Double> datos = new ArrayList<>();
        double base = 0;
        double altura = 0;
        double radio = 0;
        double area = 0;
        int figura = 0;
            while (figura < 1 || figura > 6) {
                System.out.println("1:Cuadrado 2:Rectangulo 3:Circulo 4:Esfera 5:Cubo 6:Cono");
                figura = (int) Teclado();
            }
            switch (figura) {
                case 1:
                    System.out.print("base: ");
                    base = Teclado();
                    System.out.print("altura: ");
                    altura = Teclado();
                    area = base * altura;
                    break;
                case 2:
                    System.out.print("base: ");
                    base = Teclado();
                    System.out.print("altura: ");
                    altura = Teclado();
                    area = base * altura;
                    break;
                case 3:
                    System.out.print("radio: ");
                    radio = Teclado();
                    area = (Math.PI * (radio * radio));
                    break;
                case 4:
                    System.out.print("radio: ");
                    radio = Teclado();
                    area = (4 * Math.PI * (radio * radio));
                    break;
                case 5:
                    System.out.print("base: ");
                    base = Teclado();
                    System.out.print("altura: ");
                    altura = Teclado();
                    area = base * altura;
                    break;
                case 6:
                    System.out.print("radio: ");
                    radio = Teclado();
                    System.out.print("Altura: ");
                    altura = Teclado();
                    area = (Math.PI*Math.sqrt(altura*altura+radio*radio)*radio)+(Math.PI*radio*radio);
            }
        return area;
    }
    public static double Volumen(){
        ArrayList<Double> datos = new ArrayList<>();
        int figura = 0;
        double area = 0;
        double Volumen = 0;
        double arista = 0;
        double radio = 0;
        double altura = 0;
        while (figura < 1 || figura > 3) {
            System.out.println("1:Esfera 2:Cubo 3:Cono");
            figura = (int)Teclado();
        }
        switch (figura) {
            case 1:
                System.out.print("radio: ");
                radio = Teclado();
                Volumen = (4*Math.PI*radio*radio*radio)/3;
                break;
            case 2:
                System.out.print("Arista: ");
                arista =Teclado();
                Volumen = arista*arista*arista;
                break;
            case 3:
                System.out.print("radio: ");
                radio = Teclado();
                System.out.print("Altura: ");
                altura = Teclado();
                Volumen = (Math.PI*radio*radio*altura)/3;
        }
        return Volumen;
    }
    public static void Imprimir(double datos,String opcion){
        System.out.println(opcion + datos);
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
}
