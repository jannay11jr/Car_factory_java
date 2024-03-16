import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auxiliary {
    private Scanner keyboard = new Scanner(System.in);
    private int option;
    private Factory f = new Factory();

    public void homeMenu() {
        boolean exit = false;
        do {
            System.out.println("Fabrica de coches de Jannay. Selecciona una de las siguientes opciones: \n" +
                    "1. Fabricar coche (conociendo la matricula) \n" +
                    "2. Fabricar coche (a partir del nº de puertas y de plazas) \n" +
                    "3. Fabricar coche (a partir de la marca, el modelo y el color)\n" +
                    "4. Fabricar coche (cuando no tenemos ningun dato)\n" +
                    "5. Personalizar coche (pintandolo de color)\n" +
                    "6. Personalizar coche (sin pintarlo)\n" +
                    "7. Avanzar kilometros\n" +
                    "8. Mostrar caracteristicas de un coche\n" +
                    "9. Salir del programa");
            try {

            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    if (freeCapacity() == true) {
                        try {
                            addCarUsingLicensePlate();
                            System.out.println(f.showLastCar());
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("No se pueden fabricar más coches, espacio lleno. \n");
                    }
                    break;
                case 2:
                    if (freeCapacity() == true) {
                        addCarUsingDoorsSeats();
                        System.out.println(f.showLastCar());
                    } else {
                        System.out.println("No se pueden fabricar más coches, espacio lleno. \n");
                    }
                    break;
                case 3:
                    if (freeCapacity() == true) {
                        addCarUsingBrandModelColor();
                        System.out.println(f.showLastCar());
                    } else {
                        System.out.println("No se pueden fabricar más coches, espacio lleno. \n");
                    }
                    break;
                case 4:
                    if (freeCapacity() == true) {
                        f.createCar();
                        System.out.println(f.showLastCar());
                    } else {
                        System.out.println("No se pueden fabricar más coches, espacio lleno. \n");
                    }
                    break;
                case 5:
                    personalizeColor();
                    break;
                case 6:
                    personalizeNotColor();
                    break;
                case 7:
                    moveKm();
                    break;
                case 8:
                    showFeatures();
                    break;
                case 9:
                    break;

                default:
                    System.out.println();
                    System.out.println("Error. Tienes que seleccionar un numero entre 1 y 9 \n");
                    System.out.println();
                }

            }
            catch (InputMismatchException e) {
                System.out.println("[ERROR]: No has introducido un carácter válido. \n");
                keyboard.next();
            }
        }
        while (option != 9); // Si esto es distinto de nueve volvera al do y se ejecutará de nuevo

    }
    public boolean freeCapacity() {
        return Car.cars_capacity();
    }
    public void addCarUsingLicensePlate()throws Exception {
        String licensePlate;
        try {
            System.out.println("Dime la matricula (debe contener cuatro números seguido de tres letras)");
            licensePlate = keyboard.next();

            //Para validar la matricula
            Pattern p = Pattern.compile("\\d{4}[a-zA-Z]{3}");
            Matcher m = p.matcher(licensePlate);

            if (m.matches()){
                f.createCar(licensePlate);
            }
            else {
                System.out.println("Has introducido un formato de matricula inválido, debe contener cuatro números seguido de tres letras, sin caracteres especiales");
                System.out.println("Hasta la próxima! :(");
                System.exit(0);
            }

        }
        catch (InputMismatchException e) {
            System.out.print("Hemos terminado :(");
        }
    }

    public void addCarUsingDoorsSeats() {
        int n_doors;
        int n_seats;

        System.out.println("Dime num puertas: ");
        if(keyboard.hasNextInt()) {
            n_doors = keyboard.nextInt();
        }
        else {
            System.out.println("Entrada no válida, debes ingresar un número.");
            return;
        }
        System.out.println("Dime num plazas: ");
        if(keyboard.hasNextInt()) {
            n_seats = keyboard.nextInt();
        }
        else {
            System.out.println("Entrada no válida, debes ingresar un número.");
            return;
        }

        if (2 <= n_doors && n_doors < 8 && 2 <= n_seats && n_seats < 10) {
            f.createCar(n_seats, n_doors);
        }
        else {
            System.out.println("El nº de puertas o plazas introducido es incorrecto. No se creará el vehiculo");
            System.out.println("El nº de puertas debe de ser mayor que uno y menor que ocho");
            System.out.println("El nº de plazas debe de ser mayor que uno y menor que diez");
            System.exit(0);
        }
    }

    public void addCarUsingBrandModelColor () {
        String brand, model, color;

        System.out.println("Dime marca");
        brand = keyboard.next();
        System.out.println("Dime modelo");
        model = keyboard.next();
        System.out.println("Dime color");
        color = keyboard.next();

        if (!color.matches("[a-zA-Z]+")){
        System.out.println("Has introducido un caracter no válido para el color");
        return;
        }

        f.createCar(brand, model, color);
    }

    public void personalizeColor () {
            Scanner keyboard = new Scanner (System.in);
            String licensePlate="";
            String brand;
            String model;
            String color;
            boolean roof;
            int km;
            int n_doors;
            int n_seats;

            System.out.println("Introduce matricula del coche que quieres personalizar: ");
            licensePlate = keyboard.next();
            System.out.println("Introduce marca: ");
            brand = keyboard.next();
            System.out.println("Introduce modelo: ");
            model = keyboard.next();
            System.out.println("Introduce color: ");
            color = keyboard.next();

            System.out.println("Introduce si tiene techo: (Escribe true o false) ");
            roof = keyboard.nextBoolean();
            System.out.println("Introduce km: ");
            km = keyboard.nextInt();
            System.out.println("Introduce numero de puertas: ");
            n_doors = keyboard.nextInt();
            System.out.println("Introduce numero de plazas: ");
            n_seats = keyboard.nextInt();
        try {
            f.personalizeCar(licensePlate, brand, model, color, roof, km, n_doors, n_seats);
            System.out.println(f.obtainInfo(licensePlate));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void personalizeNotColor () {
        Scanner keyboard = new Scanner (System.in);
        String licensePlate="";
        String brand;
        String model;
        boolean roof;
        int km;
        int n_doors;
        int n_seats;

        System.out.println("Introduce matricula del coche que quieres personalizar: ");
        licensePlate = Auxiliary.this.keyboard.next();
        System.out.println("Introduce marca: ");
        brand = Auxiliary.this.keyboard.next();
        System.out.println("Introduce modelo: ");
        model = Auxiliary.this.keyboard.next();
        System.out.println("Introduce si tiene techo: (Escribe true o false) ");
        roof = Auxiliary.this.keyboard.nextBoolean();
        System.out.println("Introduce km: ");
        km = Auxiliary.this.keyboard.nextInt();
        System.out.println("Introduce numero de puertas: ");
        n_doors = Auxiliary.this.keyboard.nextInt();
        System.out.println("Introduce numero de plazas: ");
        n_seats = Auxiliary.this.keyboard.nextInt();
        try {
            f.personalizeCar(licensePlate, brand, model, null, roof, km, n_doors, n_seats);
            System.out.println(f.obtainInfo(licensePlate));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void moveKm() {
        String licensePlate;
        int km;

        System.out.println("Dame la matricula");
        licensePlate = keyboard.next();
        System.out.println("Dime numeros de km nuevo");
        km = keyboard.nextInt();
        try{
            f.moveKm(licensePlate, km);
            System.out.println(f.obtainInfo(licensePlate));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showFeatures() {
        String licensePlate;
        System.out.println("Dame la matricula");
        licensePlate = keyboard.next();
        System.out.println(f.obtainInfo(licensePlate));
    }
}
