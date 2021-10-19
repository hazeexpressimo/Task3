import java.util.*;

public class House {
    private int houseId;
    private int apartmentNumber;
    private double area;
    private int floor;
    private int numberOfRoom;
    private String streetName;


    public House(int houseId, int apartmentNumber, double area, int floor, int numberOfRoom, String streetName) {
        this.houseId = houseId;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.floor = floor;
        this.numberOfRoom = numberOfRoom;
        this.streetName = streetName;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "\n" + "╔═ House number: " + houseId + "\n"
                + "╠═ Apartment number: " + apartmentNumber + "\n"
                + "╠═ Apartment area: " + area + "\n"
                + "╠═ Floor: " + floor + "\n"
                + "╠═ Number of room: " + numberOfRoom + "\n"
                + "╚═ Street name: " + streetName + "\n";
    }
}


