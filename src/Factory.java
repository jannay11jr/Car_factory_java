public class Factory {
        private static Car[] cars;

        public Factory() {
            cars = new Car[Car.getMaxCars()];
        }

        public void saveCar(Car car) {
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] == null) {
                    cars[i] = car;
                    break;
                }
            }
        }

        public void createCar(String licensePlate)throws Exception {
            if (checklicensePlateRepeat(licensePlate) == false) {
                Car c = new Car(licensePlate);
                saveCar(c);
            }
            else {
                throw new Exception("Matricula repetida");
            }
        }

        public void createCar(int n_seats, int n_doors) {
            String licensePlate = licensePlate_rand();
            Car c = new Car(licensePlate);
            c.setn_seats(n_seats);
            c.setn_doors(n_doors);
            saveCar(c);
        }

        public void createCar(String brand, String model, String color) {
            String licensePlate = licensePlate_rand();
            Car c = new Car(licensePlate, model, color);
            saveCar(c);
        }

        public void createCar() {
            String licensePlate = licensePlate_rand();
            Car c = new Car (licensePlate);
            saveCar(c);
        }

        public void personalizeCar(String licensePlate, String brand, String model, String color, boolean roof, int km,
                                     int n_doors, int n_seats) throws Exception {
            Car car = findCar(cars, licensePlate);
            if (car == null) {
                throw new Exception ("No hay coches creados para personalizar");
            }
            car.setlicensePlate(licensePlate);
            car.setbrand(brand);
            car.setmodel(model);
            car.setroof(roof);
            car.setKm(km);
            car.setn_doors(n_doors);
            car.setn_seats(n_seats);
            if (color != null) {
                car.setColor(color);
            }
        }

        public static Car findCar(Car [] cars, String licensePlate) {
            for (int i= 0; i < cars.length; i++) {
                if (cars[i] != null && cars[i].getlicensePlate().equals(licensePlate)){
                    return cars[i];
                }
            }
            return null;
        }



        public static boolean checklicensePlateRepeat(String licensePlate) {
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] != null && cars[i].getlicensePlate().equals(licensePlate)) { // con equals comprobamos caracter a caracter
                    return true;
                }
            }
            return false;
        }

        public String showLastCar() {
            String information = "";
            for (int i = 0; i < cars.length; i++) {
                if (cars[i] != null) {
                    information = cars[i].toString();
                }
            }
            return information;
        }

        public static String licensePlate_rand() {
            String licensePlate_total = "";
            do {
                int n_licensePlate;
                licensePlate_total = "";
                for (int i = 0; i < 5; i++) {
                    n_licensePlate = (int) (Math.random() * 10);
                    licensePlate_total += n_licensePlate;
                }
            }
            while(checklicensePlateRepeat(licensePlate_total) == true);
            return licensePlate_total;
        }

        public String obtainInfo(String licensePlate) {
            for (int i= 0; i < cars.length; i++) {
                if (cars[i] != null && cars[i].getlicensePlate().equals(licensePlate)){
                    return cars[i].toString();
                }
            }
            return null;
        }


        public void moveKm(String licensePlate, int km)throws Exception {
            Car car = findCar(cars, licensePlate);
            if (car == null) {
                throw new Exception("Coche no encontrado");
            }
            car.setKm(km);
        }
    }
