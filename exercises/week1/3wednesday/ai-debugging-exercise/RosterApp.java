public class RosterApp {
    /*
    Old Method:
    public static void main(String[] args) {
        String[] studentNames = new String[5];
        studentNames[0] = "Alice";
        studentNames[1] = "Bob";

        for (int i = 0; i < studentNames.length; i++) {
            // Triggers NullPointerException when reaching index 2
            if (studentNames[i].startsWith("A")) {
                System.out.println("Student: " + studentNames[i]);
            }
        }
    }*/

    //AI suggested
    public static void main(String[] args) {
        String[] studentNames = new String[5];
        studentNames[0] = "Alice";
        studentNames[1] = "Bob";

        for (int i = 0; i < studentNames.length; i++) {
            if (studentNames[i] != null &&
                    studentNames[i].startsWith("A")) {

                System.out.println("Student: " + studentNames[i]);
            }
        }
    }
}