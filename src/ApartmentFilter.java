import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ApartmentFilter {

    BufferedReader reader;
    ApartmentBuilder apBuilder;

    public ApartmentFilter() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        apBuilder = new ApartmentBuilder();
    }

    public List<House> getRoomList(List<House> list) throws IOException {

        if (list.size() > 0) {
            System.out.print("Enter number of rooms: ");
            int numberOfRoom = Integer.parseInt(reader.readLine());
            List<House> filteredApartmentList = list.stream()
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
        return null;
    }

    public List<House> getRoomAndFloorList(List<House> list) throws IOException {

        if (list.size() > 0) {
            System.out.print("Enter number of rooms: ");
            int numberOfRoom = Integer.parseInt(reader.readLine());
            System.out.print("Enter start floor: ");
            int startFloor = Integer.parseInt(reader.readLine());
            System.out.print("Enter last floor: ");
            int lastFloor = Integer.parseInt(reader.readLine());
            List<House> filteredApartmentList = list.stream()
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
        return null;
    }

    public List<House> getAreaMoreThanSelected(List<House> list) throws IOException {

        if (list.size() > 0) {
            System.out.print("Enter area: ");
            double area = Double.parseDouble(reader.readLine());
            List<House> filteredApartmentList = list.stream()
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
        return null;
    }

    public List<House> getAllApartmentsWithArea(List<House> list) throws IOException {
        if (list.size() > 0) {
            List<House> filteredApartmentList = list.stream()
                    .sorted(Comparator.comparing(House::getArea))
                    .collect(Collectors.toList());
            System.out.println(filteredApartmentList);
            return filteredApartmentList;
        } else {
            System.out.println("Add one or more apartments...");
            return null;
        }
    }

    public List<House> getFloorsWithApartments(List<House> list) throws IOException {
        if (list.size() > 0) {
            list.stream()
                    .sorted(Comparator.comparing(House::getFloor).reversed())
                    .map(House::getFloor)
                    .forEach(System.out::println);
        } else {
            System.out.println("Add one or more apartments...");
        }
        return null;
    }

    public List<House> getApartmentsFromEveryFloor(List<House> list) throws IOException{
        if (list.size() > 0) {
            list.stream()
                    .sorted(Comparator.comparing(House::getFloor))
                    .collect(Collectors.groupingBy(House::getFloor));
        } else {
            System.out.println("Add one or more apartments...");
        }
        return null;
    }
}
