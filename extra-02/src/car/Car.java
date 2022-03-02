package car;


public class Car {

    private String carType;
    private int numberOfKilometers;
    private int yearOfManufacture;
    private String carBrand;
    private int maxPassengers;
    private int speed;
    private Color color;
    private FuelType fuelType;

    public Car(String carType,String carBrand,Color color, FuelType fuelType,int numberOfKilometers,int maxPassengers,int yearOfManufacture){

        this.carType = carType;
        this.carBrand = carBrand;
        this.fuelType = fuelType;
        this.numberOfKilometers = numberOfKilometers;
        this.maxPassengers = maxPassengers;
        this.yearOfManufacture = yearOfManufacture;
    }
    public Car(String carBrand,String carType,int fuelType,boolean familyFriendly ,int yearOfManufacture){
        this.carBrand = carBrand;
        this.carType = carType;

        switch (fuelType){
            case 0:
                this.fuelType = FuelType.DIESEL;
                break;
            case 1:
                this.fuelType = FuelType.PETROL;
                break;
            case 2:
                this.fuelType = FuelType.GAS;
                break;
            case 3:
                this.fuelType = FuelType.ELECTRIC;
                break;

            default:
                this.fuelType = FuelType.HYBRID;
                break;
        }

        if(familyFriendly)
            maxPassengers = 5;
        else maxPassengers = 2;

        this.yearOfManufacture = yearOfManufacture;

        switch (carBrand.charAt(0)){

            case 'R':
                this.color = Color.RED;
                break;
            case 'G':
                this.color = Color.GREEN;
                break;
            case 'B':
                this.color = Color.BLUE;
                break;
            case 'W':
                this.color = Color.WHITE;
                break;
            default:
                this.color = Color.BLACK;
                break;
        }

    }

    public String getCarType() {
        return carType;
    }

    public int getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public Color getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void moveCar(int distance){
        if(distance>0){
            this.numberOfKilometers += distance;
        }
    }
    public void changeSpeed(int speedIndicator){
        if(speedIndicator < 0){
            if(this.speed>speedIndicator){
                this.speed -= speedIndicator;
            }
            else this.speed = 0;
        }
        else{
            this.speed += speedIndicator;
        }
    }
    public void resetMileage(){

        if(this.numberOfKilometers > 200){
            this.numberOfKilometers = 0;
        }
    }
    @Override
    public String toString(){

        if(this.maxPassengers > 2){
            System.out.println(carBrand + " " + carType + " Familiy car, manufactured in " + yearOfManufacture );
        }
        else{
            System.out.println(carBrand + " "  +carType + " two-seater car, manufactured in " + yearOfManufacture );
        }
        System.out.println("Properties:");
        System.out.println("  -COLOR:" + color);
        System.out.println("  -FUEL:" + fuelType);
        System.out.println("  -KMs traveled:" + numberOfKilometers);
        System.out.println();
        return null;
    }
}
