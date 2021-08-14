public class ParenthesisMatch {
    public static void main(String[] args) {
        String exp = "[";
        boolean x = parenthesisMatch(exp);
        if (x) {
            System.out.println("the parenthesis is matching\n");
        } else {
            System.out.println("the parenthesis is not matching\n");
        }
    }

    public static boolean parenthesisMatch(String exp) {
        Stack stack = new Stack(50, -1);
        char popped;
        for (int i = 0; i < exp.length(); i++) {
            char element = exp.charAt(i);
            if (element == '(' || element == '[' || element == '{') {
                stack.push(element);
            }
            else if (element == ')' || element == ']' || element == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                popped = stack.pop();
                if (!isMatching(popped, element)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        else return false;
    }

    public static boolean isMatching(char a, char b) {
        if (a == '(' && b == ')') {
            return true;
        }
        if (a == '[' && b == ']') {
            return true;
        }
        if (a == '{' && b == '}') {
            return true;
        }
        return false;
    }
}
