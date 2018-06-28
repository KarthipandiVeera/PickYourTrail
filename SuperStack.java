import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SuperStack {

    private static Stack<Integer> integers = new Stack<>();

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> output = new ArrayList<>();
        do {
            sc = new Scanner(System.in);
            String option = sc.nextLine();
            String inputArray[] = option.split(" ");
            switch (inputArray[0]) {
                case "push":
                    integers.push(Integer.valueOf(inputArray[1]));
                    output.add(String.valueOf(integers.peek()));

                    break;
                case "pop":
                    if (!integers.empty()) {
                        integers.pop();
                        if (!integers.empty()) {
                            output.add(String.valueOf(integers.peek()));
                        } else {
                            output.add("Empty");
                        }
                    } else {
                        output.add("Empty");
                    }
                    break;
                case "inc":
                    if (!integers.empty()) {
                        increment(integers, Integer.parseInt(inputArray[1]), Integer.parseInt(inputArray[2]));
                        output.add(String.valueOf(integers.peek()));
                    } else {
                        output.add("Empty");
                    }
                    break;
                default:
                    System.out.println("Error invalid option: retry ");
                    n++;
                    break;

            }
        } while (--n > 0);

        System.out.println("\nOutput");
        output.forEach(System.out::println);
    }

    private static void increment(Stack<Integer> integers, int count, int value) {
        if (integers.empty()) {
            return;
        }
        int stackValueHolder;
        if (integers.size() <= count) {
            stackValueHolder = integers.pop() + value;
        } else {
            stackValueHolder = integers.pop();
        }
        increment(integers, count, value);
        integers.push(stackValueHolder);

    }
}
