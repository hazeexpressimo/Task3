import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ApartmentFilter {

    BufferedReader reader;

    public ApartmentFilter() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void getRoomList() throws IOException {

        if (House.housesList.size() > 0) {
            System.out.print("Enter number of rooms: ");
            int numberOfRoom = Integer.parseInt(reader.readLine());
            List<House> filteredApartmentList = House.housesList.stream()
                    .filter(house -> house.getNumberOfRoom() == numberOfRoom)
                    .collect(Collectors.toList());
            if (filteredApartmentList.size() > 0) {
                System.out.println(filteredApartmentList);
            } else {
                System.out.println("Apartments with " + numberOfRoom + " room(s) not found!");
            }
        } else {
            System.out.println("Add one or more apartments...");
        }
    }

    public void getRoomAndFloorList() throws IOException {

        if (House.housesList.size() > 0) {
            System.out.print("Enter number of rooms: ");
            int numberOfRoom = Integer.parseInt(reader.readLine());
            System.out.print("Enter start floor: ");
            int startFloor = Integer.parseInt(reader.readLine());
            System.out.print("Enter last floor: ");
            int lastFloor = Integer.parseInt(reader.readLine());
            List<House> filteredApartmentList = House.housesList.stream()
                    .filter(h -> h.getNumberOfRoom() == numberOfRoom)
                    .filter(h -> h.getFloor() >= startFloor)
                    .filter(h -> h.getFloor() <= lastFloor)
                    .collect(Collectors.toList());
            if (filteredApartmentList.size() > 0) {
                System.out.println(filteredApartmentList);
            } else {
                System.out.println("Apartments with " + numberOfRoom + " room(s) and floors > " + startFloor + " && < " + lastFloor + " not found!");
            }
        } else {
            System.out.println("Add one or more apartments...");
        }
    }

    public void getAreaMoreThanSelected() throws IOException {

        if (House.housesList.size() > 0) {
            System.out.print("Enter area: ");
            double area = Double.parseDouble(reader.readLine());
            List<House> filteredApartmentList = House.housesList.stream()
                    .filter(h -> h.getArea() > area)
                    .sorted(Comparator.comparing(House::getArea).reversed().thenComparing(House::getFloor))
                    .collect(Collectors.toList());
            if (filteredApartmentList.size() > 0) {
                System.out.println(filteredApartmentList);
            } else {
                System.out.println("Apartments with selected area not found!");
            }
        } else {
            System.out.println("Add one or more apartments...");
        }
    }

    public void getAllApartmentsWithArea() throws IOException {
        if (House.housesList.size() > 0) {
            List<House> filteredApartmentList = House.housesList.stream()
                    .sorted(Comparator.comparing(House::getArea))
                    .collect(Collectors.toList());
            System.out.println(filteredApartmentList);
        } else {
            System.out.println("Add one or more apartments...");
        }
    }

    public void getFloorsWithApartments() throws IOException {
        if (House.housesList.size() > 0) {
            House.housesList.stream()
                    .sorted(Comparator.comparing(House::getFloor).reversed())
                    .map(House::getFloor)
                    .forEach(System.out::println);
        } else {
            System.out.println("Add one or more apartments...");
        }
    }


}
