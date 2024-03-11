import java.util.Scanner;

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

            option = keyboard.nextInt();
            switch (option) {
                case 1:
                    if(freeCapacity() == true) {
                        try {
                            addCarUsingLicensePlate();
                            System.out.println(f.showLastCar());
                        }
                        catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else {
                        System.out.println("No se pueden fabricar mas coches, espacio lleno.");
                    }
                    break;
                case 2:
                    if (freeCapacity() == true) {
                        addCarUsingDoorsSeats();
                        System.out.println(f.showLastCar());
                    }
                    else {
                        System.out.println("No se pueden fabricar mas coches, espacio lleno");
                    }
                    break;
                case 3:
                    if (freeCapacity() == true) {
                        addCarUsingBrandModelColor();
                        System.out.println(f.showLastCar());
                    }
                    else {
                        System.out.println("No se pueden fabricar mas coches, espacio lleno");
                    }
                    break;
                case 4:
                    if (freeCapacity() == true) {
                        f.createCar();
                        System.out.println(f.showLastCar());
                    }
                    else {
                        System.out.println("No se pueden fabricar mas coches, espacio lleno");
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
                    System.out.println("Error. Tienes que seleccionar un numero entre 1 y 9");
                    System.out.println();

            }
        }
        while (option != 9); // Si esto es distinto de nueve volvera al do y se ejecutara de nuevo

    }
    public boolean freeCapacity() {
        return Car.cars_capacity();
    }
    public void addCarUsingLicensePlate()throws Exception {
        String licensePlate;
        System.out.println("Dime la matricula");
        licensePlate = keyboard.next();
        f.createCar(licensePlate);

    }

    public void addCarUsingDoorsSeats() {
        int n_doors;
        int n_seats;

        System.out.println("Dime num puertas: ");
        n_doors = keyboard.nextInt();

        System.out.println("Dime num plazas: ");
        n_seats = keyboard.nextInt();
        f.createCar(n_seats,n_doors);
    }

    public void addCarUsingBrandModelColor () {
        String brand, model, color;

        System.out.println("Dime marca");
        brand = keyboard.next();
        System.out.println("Dime model");
        model = keyboard.next();
        System.out.println("Dime color");
        color = keyboard.next();
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
        licensePlate = Auxiliary.this.keyboard.next();
        System.out.println("Introduce marca: ");
        brand = Auxiliary.this.keyboard.next();
        System.out.println("Introduce modelo: ");
        model = Auxiliary.this.keyboard.next();
        System.out.println("Introduce color: ");
        color = Auxiliary.this.keyboard.next();
        System.out.println("Introduce si tiene techo: (Escribe true o false) ");
        roof = Auxiliary.this.keyboard.nextBoolean();
        System.out.println("Introduce km: ");
        km = Auxiliary.this.keyboard.nextInt();
        System.out.println("Introduce numero de puertas: ");
        n_doors = Auxiliary.this.keyboard.nextInt();
        System.out.println("Introduce numero de plazas: ");
        n_seats = Auxiliary.this.keyboard.nextInt();
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
