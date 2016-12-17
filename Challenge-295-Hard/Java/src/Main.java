public class Main {

    public static void main(String[] args) {
        String map =
                "XXXXXXXXXXXXXX\n" +
                        "XXC1212121213X\n" +
                        "X4X21212O2121X\n" +
                        "X44X232323232X\n" +
                        "X444X43434343X\n" +
                        "X4444XXXXXX77X\n" +
                        "X4444O6789X99X\n" +
                        "XXXXXXXXXXXXXX";

        int time = 20;

        Pacman pacman = new Pacman(map);
        int maximumPacgums = pacman.getMaximumPacgums(time);
        System.out.println(maximumPacgums);
    }
}