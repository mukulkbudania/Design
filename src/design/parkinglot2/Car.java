package design.parkinglot2;

/**
 * Created by mukulbudania on 2/12/16.
 */
public class Car {
    private String color;
    private String licenseNumber;

    public Car(String licenceNumber, String color) {
        this.licenseNumber = licenceNumber;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public int hashCode(){
        return licenseNumber.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Car))return false;
        return this.licenseNumber.equals(((Car) o).licenseNumber);
    }
}
