public class TooManyParentheses {

   public String clean(String str) {

        StringBuilder sb = new StringBuilder(str);

        int rightMostOpenParenthesis = findRightMostOpenParenthesis(str, str.length());
        int leftMostClosedParenthesis = findLeftMostClosedParenthesis(str, rightMostOpenParenthesis);

        do {
            if (!isValidGroup(sb.toString(), rightMostOpenParenthesis, leftMostClosedParenthesis)) {
                sb = sb.deleteCharAt(rightMostOpenParenthesis);
                sb = sb.deleteCharAt(leftMostClosedParenthesis - 1);
            }

            rightMostOpenParenthesis = findRightMostOpenParenthesis(sb.toString(), rightMostOpenParenthesis - 1);
            leftMostClosedParenthesis = findLeftMostClosedParenthesis(sb.toString(), rightMostOpenParenthesis);

        } while (rightMostOpenParenthesis != -1);

        return sb.toString();
    }

    private boolean isValidGroup(String str, int start, int end) {
        String substring = str.substring(start, end + 1);

        int level = 0, groups = 0, length = substring.length()-1;

        if(length == 1){
            return false;
        }

        for (int i = 0; i <= length; ++i) {
            char c = substring.charAt(i);

            if (c == '(') {
                ++level;
            } else if (c == ')') {
                if (--level == 1) {
                    ++groups;
                }

                if (level == 0 && groups != 1 && i == length) {
                    return true;
                }

            } else if (level == 1) {
                return true;
            }
        }

        return false;
    }

    private int findRightMostOpenParenthesis(String str, int offset) {
        return str.lastIndexOf("(", offset);
    }

    private int findLeftMostClosedParenthesis(String str, int openParenthesisIndex) {
        int subGroups = 0;

        for (int i = openParenthesisIndex + 1; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                ++subGroups;
            } else if (c == ')' && subGroups > 0) {
                --subGroups;
            } else if (c == ')' && subGroups == 0) {
                return i;
            }
        }

        return -1;
    }

}