class Solution {
    public int calPoints(String[] ops) {
        final Stack<Integer> stack = new Stack<>();
        int totalScore = 0;
        for (final String op : ops) {
            switch (op) {
                case "+":
                    int num2 = stack.pop(), num1 = stack.pop();
                    stack.push(num1);
                    stack.push(num2);
                    stack.push(num1 + num2);
                    break;
                case "D":
                    int num = stack.pop();
                    stack.push(num);
                    stack.push(num * 2);
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
            System.out.println(stack);
        }
        while (!stack.isEmpty()) {
            totalScore += stack.pop();
        }
        return totalScore;
    }
}