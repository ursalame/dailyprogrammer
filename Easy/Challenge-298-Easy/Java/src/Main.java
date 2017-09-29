public class Main {

    public static void main(String[] args) {

        TooManyParentheses tmp = new TooManyParentheses();
        String str = "((a((bc)(de)))f)";

        System.out.println(tmp.clean(str));

    }
}
