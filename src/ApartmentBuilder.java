import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ApartmentBuilder {


    public void addAppartment() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter number of apartments: ");
        int countOfApartments = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= countOfApartments; i++) {
            System.out.print("Enter house number: ");
            int houseId = Integer.parseInt(reader.readLine());
            System.out.print("Enter apartment number: ");
            int apNumber = Integer.parseInt(reader.readLine());
            System.out.print("Enter floor: ");
            int floor = Integer.parseInt(reader.readLine());
            System.out.print("Enter area of apartment: ");
            double area = Double.parseDouble(reader.readLine());
            System.out.print("Enter number of rooms: ");
            int numberOfRooms = Integer.parseInt(reader.readLine());
            System.out.print("Enter street name: ");
            String streetName = reader.readLine();
            addHouse(new House(houseId, apNumber, area, floor, numberOfRooms, streetName));
        }
    }

    public static void addHouse(House house) {
        House.housesList.add(house);
    }
}
