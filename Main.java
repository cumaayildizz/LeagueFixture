package LeagueFixture;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> teams = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void createsTeams() {
        System.out.print("Number of teams you want to add : ");
        int numberTeams = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the teams:");
        for (int i = 0; i < numberTeams ; i++) {
            String team;
            boolean isContains = false;
            do{
                System.out.print("Please enter team name : ");
                team = scanner.nextLine();
                if (teams.contains(team) == false){
                    teams.add(team);
                    System.out.print((i) + 1 + " : " + team );
                    isContains = true;
                    System.out.println();
                }else {
                    System.out.println("This team is already added!! Please enter another team.");
                }
            }while (isContains == false);

        }
    }

    public static void byeTeam(){
        if (teams.size() % 2 != 0) {
            teams.add("Bye");
        }
    }

    public static void Fixtures() {

        int matchNumber = teams.size() - 1;
        int halfSize = teams.size() / 2;

        for (int week = 1; week < matchNumber; week++) {
            System.out.println("\nWeek " + (week));
            System.out.println("===============================");

            for (int i = 0; i < halfSize; i++) {
                String home = teams.get(i);
                String guest = teams.get(teams.size() - 1 - i);

                if (!home.equals("Bye") && !guest.equals("Bye")) {
                    System.out.println(home + " - " + guest);
                } else {
                    System.out.println(home + " -->> Bye");
                }
            }

            String last = teams.remove(teams.size() - 1);
            teams.add(1, last);
        }
    }

    public void run(){
        createsTeams();
        byeTeam();

        Fixtures();
        System.out.println("******************************"
                        + "\nBetween Periods"
                        + "\n******************************");
        Fixtures();
    }


    public static void main(String[] args) {

        Main start = new Main();
        start.run();

    }
}
