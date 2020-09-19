package design.parkinglot2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by mukulbudania on 1/12/16.
 */
public class ParkingLot {
        private List<Car> parkingSpaces;
        private Set<Integer> emptySpaces;
        private Map<String,Integer> carCache;
        private Map<String,Set<ColorCacheEntry>> colorCache;
        private boolean initialized = false;
        public boolean initialize(int spaces) {
                this.parkingSpaces = new ArrayList<Car>(spaces);
                this.emptySpaces = new TreeSet<Integer>();
                this.carCache = new HashMap<String, Integer>(spaces);
                this.colorCache = new HashMap<String, Set<ColorCacheEntry>>();
                for(int i=0;i<spaces;i++) {
                        this.parkingSpaces.add(null);
                        this.emptySpaces.add(i);
                }
                this.initialized = true;
                return true;
        }

        public Map<String, Integer> getCarCache() { return this.carCache; }

        public Set<Integer> getEmptySpaces() {
                return this.emptySpaces;
        }

        public Map<String, Set<ColorCacheEntry>> getColorCache() {
                return this.colorCache;
        }

        public List<Car> getParkingSpaces() {
                return this.parkingSpaces;
        }

        public boolean isInitialized(){ return this.initialized; }

        public int reserve(Car car) {
                if(Utils.isEmpty(getEmptySpaces())) return -1;
                int parkSpot = getEmptySpaces().iterator().next();
                getParkingSpaces().set(parkSpot,car);
                getEmptySpaces().remove(parkSpot);
                getCarCache().put(car.getLicenseNumber(),parkSpot);
                if(getColorCache().get(car.getColor()) == null){
                        getColorCache().put(car.getColor(),new HashSet<ColorCacheEntry>());
                }
                getColorCache().get(car.getColor()).add(new ColorCacheEntry(car.getLicenseNumber(),parkSpot));
                return parkSpot;
        }

        public Car remove(int parkSpot) {
                Car car = this.parkingSpaces.get(parkSpot);
                if(car==null) return null;
                getParkingSpaces().set(parkSpot,null);
                getEmptySpaces().add(parkSpot);
                getCarCache().put(car.getLicenseNumber(),parkSpot);
                getColorCache().get(car.getColor()).remove(new ColorCacheEntry(car.getLicenseNumber(),parkSpot));
                return car;
        }

        public String printStatus() {
                StringBuilder sb = new StringBuilder();
                sb.append("Slot No. Registration No Color\n");
                for(int i = 0;i<getParkingSpaces().size(); i++){
                        Car car = getParkingSpaces().get(i);
                        if(car!=null){
                                sb.append(String.format("%7d",i) + " " +
                                        String.format("%15s",car.getLicenseNumber()) + "  " +
                                        car.getColor() + "\n");
                        };
                }
                return sb.toString();
        }

        public List<String> getRegistrationNumberFromColor(String color) {
                List<String> result = new ArrayList<String>();
                for(ColorCacheEntry c: getColorCache().get(color)){
                        result.add(c.getLicenseNumber());
                }
                return result;
        }

        public List<Integer> getSlotNumbersFromColor(String color) {
                List<Integer> result = new ArrayList<Integer>();
                for(ColorCacheEntry c: getColorCache().get(color)){
                        result.add(c.getParkSpot());
                }
                return result;
        }

        public Integer getSlotNumberFromRegistrationNumber(String registrationNumber) {
                if(getCarCache().containsKey(registrationNumber)) return getCarCache().get(registrationNumber);
                return -1;
        }
}
