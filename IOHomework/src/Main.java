import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private List<Shooter> shooters = new ArrayList<>();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");

    public static void main(String[] args) {
        Main main = new Main();
        main.readFile("file.csv");

        int size = main.sortBasedOnTime().size();
        for (int i = 0; i<size; i++) {
            Shooter currentShooter = main.sortBasedOnTime().get(i);
            if (i == 0) {
                System.out.println("Winner - " + currentShooter);
            } else if (i == 1) {
                System.out.println("Runner-Up - " + currentShooter);
            } else if (i == 2) {
                System.out.println("Third Place - " + currentShooter);
            }
        }

    }

    private void readFile(String filename) {
        try (Stream<String> stream = Files.lines(Paths.get(filename))) {

            //for every line do
            stream.forEach(s -> {

                String[] tokens = s.split(",");
                ArrayList<String> tokensString = new ArrayList<>(Arrays.asList(tokens));

                Shooter shooter = new Shooter(tokens[0], tokens[1], tokens[2], tokens[3], tokensString.subList(4, tokensString.size()));
                shooters.add(shooter);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calculateMissedShoots(String shoots) {
        String[] tokens = shoots.split("");
        int sum = 0;
        for (String token : tokens) {
            if (token.equals("o")) {
                sum++;
            }
        }

        return sum;
    }

    private List<Shooter> sortBasedOnTime() {
        shooters.sort(new Comparator<Shooter>() {
            @Override
            public int compare(Shooter o1, Shooter o2) {
                return o1.getFinalTime().compareTo(o2.getFinalTime());
            }
        });
        return shooters;
    }

}
