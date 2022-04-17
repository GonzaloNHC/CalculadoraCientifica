import java.util.InputMismatchException;
import java.util.Scanner;
public class CalculadoraCIentificaCompleta {

    public static void main(String[] args){
        Inicio();
    }
    public static void Inicio(){
        int MenuOption;
        int MinOption=1;
        int MaxOption=6;

        do{
            MenuPrincipal();
            MenuOption = getMenuOption(MinOption, MaxOption);
            LlamarMetodos(MenuOption);
        }while (MenuOption!=6);
    }

    public static int getMenuOption(int MinOption, int MaxOption) {
        int MenuOption;
        int counter = 0;

        do {
            if(counter != 0) {
                System.out.println("Por favor ingrese un número dentro de las opciones.");
            }

            MenuOption = chooseMenuOption();
            counter++;
        }while(MenuOption < MinOption || MinOption > MaxOption);

        return MenuOption;
    }


    public static void MenuPrincipal() {
        System.out.println("""
                Por favor ingrese su opción.
                1. Operaciones aritméticas
                2. Ecuación cuadrática
                3. Figuras geométricas
                4. Sistema ecuaciones lineales
                5. Ecuación de la recta
                6. Salir""");
    }

    public static int chooseMenuOption() {
        Scanner scanner = new Scanner(System.in);

        try {
            return scanner.nextInt();
        }catch(InputMismatchException e) {
            return 0;
        }
    }

    public static void LlamarMetodos(int menuOption) {
        switch (menuOption) {
           case 1 -> ResolverOperacionAritmetica();
           case 2 -> ResolverEcuacionesCuadraticas();
           // case 3 -> ResolverFigurasGeometricas();
           // case 4 -> ResolverSistemaecuacioneslineales();
           // case 5 -> ResolverEcuaciondelarecta();
            case 6 -> System.out.println("Programa finalizado");
        }
    }

    ///--------------------------------------------------------------------------------------------------------------------

    public static void ResolverOperacionAritmetica(){
        int minOption=1;
        int maxOption=8;

        MenuOperacionAritmetica();

        int menuOption= getMenuOption(minOption,maxOption);

        System.out.println("Ingrese el primer valor");
        double numero1=getVariable();
        System.out.println("Ingrese el segundo valor");
        double numero2=getVariable();

        arithmeticOptions(menuOption, numero1, numero2);

    }

    public static void arithmeticOptions(int menuOption, double numero1, double numero2) {
        switch (menuOption) {
            case 1 -> OpcionSumar(numero1, numero2);
            case 2 -> OpcionRestar(numero1, numero2);
            case 3 -> OpcionMultiplicar(numero1, numero2);
            case 4 -> OpcionDividir(numero1, numero2);
            case 5 -> CalcularMayor(numero1, numero2);
            case 6 -> CalcularMenor(numero1, numero2);
            case 7 -> CalcularElevado(numero1, numero2);
            case 8 -> CalcularPorcentage(numero1, numero2);
        }
    }

    public static void MenuOperacionAritmetica() {
        System.out.println("""
                Por favor ingrese una opción.
                1.Suma
                2.Resta
                3.Multiplicación
                4.División
                5.Mayor entre 2 números
                6.Menor entre 2 números
                7.Potencia
                8.Porcentaje de un número""");
    }

    public static double getVariable() {

        while(true) {
            Scanner scanner = new Scanner(System.in);

            try {
                return scanner.nextDouble();
            }catch(InputMismatchException e) {
                System.out.println("Por favor ingrese un número");
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    public static void OpcionSumar(double numero1, double numero2){
        double resultado = numero1+numero2;
        System.out.println(numero1 +"+"+numero2+"="+resultado);
    }

    public static void OpcionRestar(double numero1, double numero2){
        double resultado = numero1-numero2;
        System.out.println(numero1+"-"+numero2+"="+resultado);
    }

    public static void OpcionMultiplicar(double numero1, double numero2){
        double resultado = numero1*numero2;
        System.out.println(numero1+"*"+numero2+"="+resultado);
    }

    public static void OpcionDividir(double numero1, double numero2){
        try {
            System.out.println(numero1+"/"+numero2+"="+DividirReal(numero1,numero2));
        }catch (ArithmeticException e){
            System.err.println("No se puede divir por cero");
        }
    }

    public static double DividirReal(double numero1, double numero2){
        if (numero2==0){
            throw new ArithmeticException();
        }
        return numero1/numero2;
    }

    public static void CalcularMayor(double numero1, double numero2){
        double mayor = Math.max(numero1, numero2);
        System.out.println("El mayor es"+mayor);
    }

    public static void CalcularMenor(double numero1, double numero2){
        double menor = Math.min(numero1, numero2);
        System.out.println("El menor es " + menor);

    }

    public static void CalcularElevado(double numero1, double numero2){

            try {
                System.out.println(numero1+"^"+numero2+"="+CalcularElevadoReal(numero1,numero2));
            } catch (ArithmeticException e) {
                System.err.println("No se puede elevar 0 entre 0");
            }
    }

    public static double CalcularElevadoReal(double numero1, double numero2){
        if(numero1==0&&numero2==0){
            throw new ArithmeticException();
        }
        return Math.pow(numero1,numero2);
    }

    public static void CalcularPorcentage(double numero1, double numero2){

        if(numero1 == 0){
            System.out.println("El " + numero1 + " % de " + numero2 + " es: 0.");
        }
        double resultado = ((numero2 / numero1) * 100);

        System.out.println("El " + numero1 + " % de " + numero2+ " es: " + resultado);

    }

    //------------------------------------------------------------------------------------------------------------------

    public static void ResolverEcuacionesCuadraticas() {
        System.out.println("Ax^2+Bx+C");
        System.out.println("Ingrese valor para A");
        double A = getVariable();
        System.out.println("Ingrese valor para B");
        double B = getVariable();
        System.out.println("Ingrese valor para C");
        double C = getVariable();
        CalularDeterminante(A, B, C);
        Solucion1(A,B,C);
        Solucion2(A,B,C);
    }

    public static double CalularDeterminante(double A, double B, double C){
        if(AesCero(A)){
            System.out.println("No es una ecuacion cuadratica");
        }
        if(determinanteNegativo(A,B,C)){
            System.out.println("La respuesta esta en los imaginario");
        }
        return Math.pow(B,2)-4*A+C;
    }

    private static boolean determinanteNegativo(double A, double B, double C){
        return Math.pow(B,2)-4*A*C<0;
    }

    private static boolean AesCero(double A){return A==0;}

    public static void Solucion1(double A, double B, double C){
        double solucion= (-B+Math.sqrt(CalularDeterminante(A,B,C))/2*A);
        System.out.println("La primera solucion es: "+solucion);
    }
    public static void Solucion2(double A, double B, double C){
        double solucion= (-B-Math.sqrt(CalularDeterminante(A,B,C))/2*A);
        System.out.println("La primera solucion es: "+solucion);
    }
}
