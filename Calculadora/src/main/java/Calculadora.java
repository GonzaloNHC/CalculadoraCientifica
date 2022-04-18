import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
            case 3 -> ResolverFigurasGeometricas();
            case 4 -> ResolverSistemaecuacioneslineales();
            case 5 -> ResolverEcuaciondelarecta();
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
    /*--------------------------------------------------------------------------------------------------------------------------------------*/
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
    /*--------------------------------------------------------------------------------------------------------------------------*/
    public static double ResolverEcuaciondelarecta(){
        double x1,y1,x2,y2;
        double m,b;
        System.out.println("Ingrese el primer punto:");
        System.out.print("x: ");
        x1 = Teclado();
        System.out.print("y: ");
        y1 = Teclado();
        System.out.println("segundo punto");
        System.out.print("x: ");
        x2 = Teclado();
        System.out.print("y: ");
        y2 = Teclado();

        m = (y2-y1)/(x2-x1);
        b = y1-m*x1;

        System.out.println("La ecuacion es y="+m+"x+"+b);
    }
}
