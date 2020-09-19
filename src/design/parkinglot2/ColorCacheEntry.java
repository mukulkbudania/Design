package design.parkinglot2;

/**
 * Created by mukulbudania on 2/12/16.
 */
public class ColorCacheEntry {
    private String licenseNumber;
    private int parkSpot;

    public ColorCacheEntry(String licenseNumber, int parkSpot) {
        this.licenseNumber = licenseNumber;
        this.parkSpot = parkSpot;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public int getParkSpot() {
        return parkSpot;
    }

    @Override
    public int hashCode(){
        return licenseNumber.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof ColorCacheEntry))return false;
        return this.licenseNumber.equals(((ColorCacheEntry) o).licenseNumber);
    }
}
