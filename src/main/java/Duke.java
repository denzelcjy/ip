import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void startDuke() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke");
        System.out.println("     What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }

    public static void endDuke() {
        System.out.println("    ____________________________________________________________");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        startDuke();
        Scanner input = new Scanner(System.in);
        ArrayList<Task> taskList = new ArrayList<>();
        while (input.hasNextLine()) {
            String[] nextInput = input.nextLine().split(" ", 2);
            if (nextInput[0].equals("bye")) {
                break;
            }
            if (nextInput[0].isEmpty()) { //settle for the case of empty inputs
                continue;
            }
            if (nextInput[0].equals("list")) { //want to print out the task list
                Task.printTaskList(taskList);
                continue;
            }
            if (nextInput[0].equals("mark")) {
                int taskNumber = Integer.parseInt(nextInput[1]);
                taskList.get(taskNumber - 1).markAsDone();
                Task.printMarkedTask(taskNumber - 1, taskList);
                continue;
            }
            if (nextInput[0].equals("unmark")) {
                int taskNumber = Integer.parseInt(nextInput[1]);
                taskList.get(taskNumber - 1).markAsNotDone();
                Task.printUnmarkedTask(taskNumber - 1, taskList);
                continue;
            }
            if (nextInput[0].equals("todo")) {
                Task.addTodoTask(nextInput[1], taskList);
            }
            if (nextInput[0].equals("deadline")) {
                Task.addDeadlineTask(nextInput[1], taskList);
            }
            if (nextInput[0].equals("event")) {
                Task.addEventTask(nextInput[1], taskList);
            }

        }
        endDuke();
    }

}

