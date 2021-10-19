import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ApartmentBuilder apartmentBuilder = new ApartmentBuilder();
        ApartmentFilter apartmentFilter = new ApartmentFilter();
        boolean f = false;
        while (!f) {
            System.out.println("Make your choice...");
            System.out.println("1. Add apartments.");
            System.out.println("2. Show apartments with the specified number of rooms.");
            System.out.println("3. Show apartments with the specified number of rooms and floors.");
            System.out.println("4. Show apartments with the specified area.");
            System.out.println("5. Show all apartments in order of increasing area.");
            System.out.println("6: Show all floors with apartments.");
            System.out.println("7. Exit");
            int menuChoice = Integer.parseInt(reader.readLine());
            switch (menuChoice) {
                case 1 -> {
                    apartmentBuilder.addAppartment(apartmentBuilder.housesList);
                }
                case 2 -> {
                    apartmentFilter.getRoomList(apartmentBuilder.housesList);
                }
                case 3 -> {
                    apartmentFilter.getRoomAndFloorList(apartmentBuilder.housesList);
                }
                case 4 -> {
                    apartmentFilter.getAreaMoreThanSelected(apartmentBuilder.housesList);
                }
                case 5 -> {
                    apartmentFilter.getAllApartmentsWithArea(apartmentBuilder.housesList);
                }
                case 6 -> {
                    apartmentFilter.getFloorsWithApartments(apartmentBuilder.housesList);
                }
                case 7 -> {
                    f = true;
                    return;
                }
            }
        }
    }
}
