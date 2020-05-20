class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int result = 0;
            int number2 = stack.pop();
            int number1 = stack.pop();
            switch(token) {
                case "+":
                    result += number1 + number2;
                    break;
                case "-":
                    result += number1 - number2;
                    break;
                case "*":
                    result += number1 * number2;
                    break;
                case "/":
                    result += number1 / number2;
                    break;
                default:
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }
}
}