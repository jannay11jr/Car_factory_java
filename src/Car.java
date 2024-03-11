public class Car {
    private String licensePlate;
    private String brand;
    private String model;
    private String color;
    private boolean roof;
    private int km;
    private int n_doors;
    private int n_seats;


    private static int num_cars = 0; //Tendra que incrementarse cada vez que creemos un coche
    private final static int MAX_CARS = 5;

    public Car() //throws Exception
    {
        setlicensePlate("0000-AA");
        increase_num_cars();

    }

    public Car (String licensePlate, String brand, String model, String color, boolean roof, int km,
                  int n_doors, int n_seats) //throws Exception
    {

        setlicensePlate(licensePlate);
        setbrand(brand);
        setmodel(model);
        setColor(color);
        setroof(roof);
        setKm(km);
        setn_doors(n_doors);
        setn_seats(n_seats);
        increase_num_cars();
    }

    public Car (String licensePlate, String brand, String model)// throws Exception
    {
        //superaAforo();
        setlicensePlate(licensePlate);
        setbrand(brand);
        setmodel(model);
        increase_num_cars();
    }

    public Car(String licensePlate)// throws Exception
    {
        //superaAforo();
        setlicensePlate(licensePlate);
        increase_num_cars();
    }



    public void setlicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getlicensePlate() {
        return licensePlate;
    }

    public void setbrand(String brand) {
        this.brand = brand;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setroof(boolean roof) {
        this.roof = Car.this.roof;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setn_doors(int n_doors) {
        this.n_doors = Car.this.n_doors;
    }

    public void setn_seats(int n_seats) {
        this.n_seats = Car.this.n_seats;
    }

    public static boolean cars_capacity () {
        return num_cars <= MAX_CARS;
    }

    public void increase_num_cars() {
        num_cars++;
    }

    public static int getMaxCars() {
        return MAX_CARS;
    }

    public void superCapacity() throws Exception {
        if (cars_capacity() == false) {
            throw new Exception ("Hay demasiados coches en la fabrica, no pueden haber mas de cinco.");
        }
    }
    public String toString() {
        String info ="Este coche tiene los siguientes datos: \n Matricula: " +licensePlate;
        if (brand != null) {
            info+= "\n Marca: " +brand;
        }
        if (model != null) {
            info+= "\n Modelo: " +model;
        }
        if (color != null) {
            info+= " \nColor: " +color;
        }
        info+= "\n Techo: " +roof;
        info+= "\n Km: " +km;
        info+= "\n Nºpuertas: " +n_doors;
        info+= "\n Nºplazas: " +n_seats;
        return info;
    }
}
