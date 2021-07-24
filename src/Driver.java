import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        boolean[] seats = new boolean[27];
        printMainMenu(seats);
    }


    public static void printMainMenu(boolean seats[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your choice: \n1-Reserve One Economy Seat\n2-Reserve One First Class Seat\n3-Remove One Economy Seat\n4-Remove One First Class Seat\n5-Print Reservation Info\n6-Exit");
        int a = input.nextInt();
        while (a != 6) {
            switch (a) {
                case 1: {
                    if(!isEconomySeatsFull(seats))
                        reserveEconomySeat(seats);
                    else
                        System.out.println("Economy seats are full.");
                    break;
                }

                case 2: {
                    if(!isFirstClassSeatsFull(seats))
                        reserveFirstClassSeat(seats);
                    else
                        System.out.println("First Class seats are full.");
                    break;
                }

                case 3: {
                    removeEconomySeat(seats);
                    break;
                }

                case 4: {
                    removeFirstClassSeat(seats);
                    break;
                }

                case 5: {
                    printReservationInfo(seats);
                    break;
                }

                case 6: {
                    //Exit
                    System.out.println("6");
                    break;
                }

                default: {
                    System.out.println("Wrong value entered.");
                    break;
                }

            }
            System.out.println("Please enter your choice: \n1-Reserve One Economy Seat\n2-Reserve One First Class Seat\n3-Remove One Economy Seat\n4-Remove One First Class Seat\n5-Print Reservation Info\n6-Exit");
            a = input.nextInt();
        }

    }

    public static boolean isEconomySeatsFull(boolean seats[]){
        boolean flag = true;
        for(int i=3;i<seats.length;++i){
            if(seats[i]==false){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean isFirstClassSeatsFull(boolean seats[]){
        boolean flag = true;
        for(int i=0;i<3;++i){
            if(seats[i]==false){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void reserveEconomySeat(boolean seats[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the seat you'd like to reserve. Must be 4-27. Enter -1 to exit.");
        int seatNum = input.nextInt();
        while(seatNum != -1) {
            while (seatNum < 4 || seatNum > 27) {
                System.out.println("Wrong input. Seat number must be 4-27. Try again.");
                seatNum = input.nextInt();
            }
            if (seats[seatNum-1] == false) {
                seats[seatNum-1] = true;
                System.out.println("Seat successfully reserved!");
            } else {
                System.out.println("Seat is already reserved. Please pick another seat.");
            }
            System.out.println("Please enter the number of the seat you'd like to reserve. Must be 4-27. Enter -1 to exit.");
            seatNum = input.nextInt();

        }

        System.out.println("Number of Economy seats reserved: "+printNumberOfReservedEconomySeats(seats)+"\nTotal reserved:" +
                " "+(printNumberOfReservedEconomySeats(seats)+printNumberOfReservedFirstClassSeats(seats)));

    }

    public static void reserveFirstClassSeat(boolean seats[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the seat you'd like to reserve. Must be 1-3. Enter -1 to exit.");
        int seatNum = input.nextInt();

        while(seatNum != -1) {
            while (seatNum < 1 || seatNum > 3) {
                System.out.println("Wrong input. Seat number must be 1-3. Try again.");
                seatNum = input.nextInt();
            }
            if (seats[seatNum-1] == false) {
                seats[seatNum-1] = true;
                System.out.println("Seat successfully reserved!");
            } else {
                System.out.println("Seat is already reserved. Please pick another seat.");
            }
            System.out.println("Please enter the number of the seat you'd like to reserve. Must be 1-3. Enter -1 to exit.");
            seatNum = input.nextInt();

        }

        System.out.println("\nNumber of First Class seats reserved: "+printNumberOfReservedFirstClassSeats(seats)+"\nTotal reserved:" +
                " "+(printNumberOfReservedEconomySeats(seats)+printNumberOfReservedFirstClassSeats(seats)));
    }

    public static void removeEconomySeat(boolean seats[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the seat you'd like to remove. Must be 4-27. Enter -1 to exit.");
        int seatNum = input.nextInt();
        while(seatNum != -1){
            while (seatNum < 4 || seatNum > 27) {
                System.out.println("Wrong input. Seat number must be 4-27. Try again.");
                seatNum = input.nextInt();
            }
            if (seats[seatNum-1] == true) {
                seats[seatNum-1] = false;
                System.out.println("Seat successfully removed!");
            } else {
                System.out.println("Seat is already not reserved. Please pick another seat to remove.");
            }
            System.out.println("Please enter the number of the seat you'd like to remove. Must be 4-27. Enter -1 to exit.");
           seatNum = input.nextInt();

        }

        System.out.println("Number of Economy seats reserved: "+printNumberOfReservedEconomySeats(seats)+"\nTotal reserved:" +
                " "+(printNumberOfReservedEconomySeats(seats)+printNumberOfReservedFirstClassSeats(seats)));
    }

    public static void removeFirstClassSeat(boolean seats[]){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the number of the seat you'd like to remove. Must be 1-3. Enter -1 to exit.");
        int seatNum = input.nextInt();

        while(seatNum != -1){
            while (seatNum < 1 || seatNum > 3) {
                System.out.println("Wrong input. Seat number must be 1-3. Try again.");
                seatNum = input.nextInt();
            }
            if (seats[seatNum-1] == true) {
                seats[seatNum-1] = false;
                System.out.println("Seat successfully removed!");
            } else {
                System.out.println("Seat is already not reserved. Please pick another seat to remove.");
            }
            System.out.println("Please enter the number of the seat you'd like to remove. Must be 1-3. Enter -1 to exit.");
            seatNum = input.nextInt();

        }

        System.out.println("Number of First Class seats reserved: "+printNumberOfReservedFirstClassSeats(seats)+"\nTotal reserved:" +
                " "+(printNumberOfReservedEconomySeats(seats)+printNumberOfReservedFirstClassSeats(seats)));
    }


    public static void printReservationInfo(boolean seats[]){
        System.out.println("Number of Economy seats reserved: "+printNumberOfReservedEconomySeats(seats)+"\nNumber Of First Class seats reserved: "+printNumberOfReservedFirstClassSeats(seats)+"\nTotal:" +
                " "+(printNumberOfReservedEconomySeats(seats)+printNumberOfReservedFirstClassSeats(seats)));
    }

    public static int printNumberOfReservedEconomySeats(boolean seats[]){
        int count=0;
        for(int i=3;i<seats.length;++i){
            if(seats[i] == true){
                count++;
            }
        }
        return count;
    }

    public static int printNumberOfReservedFirstClassSeats(boolean seats[]){
        int count=0;
        for(int i=0;i<3;++i){
            if(seats[i] == true){
                count++;
            }
        }
        return count;
    }

}
