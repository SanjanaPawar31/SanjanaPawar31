public class Main 
{
    public static void main(String[] args) {
    
        int[] marks = {95, 45, 60, 89, 50};
        calculateResults(marks);
}
    public static void calculateResults(int[] marks)
    {
        if (marks == null || marks.length == 0) {
            System.err.println("Invalid input: marks should be a non-empty array.");
            return;
    }
        int totalMarks = 0;
        for (int mark : marks)
        {
            if (mark < 35 || mark > 100) 
            {
                System.err.println("Invalid mark detected. All marks should be numbers between 0 and 100.");
                return;
            }
            totalMarks += mark;
        }

        
        double averagePercentage = (double) totalMarks / marks.length;

        // Grade Calculation
        String grade;
        if (averagePercentage >= 90)
        {
            grade = "A+";
        } else if (averagePercentage >= 80)
        {
            grade = "A";
        } else if (averagePercentage >= 70) 
        {
            grade = "B";
        } else if (averagePercentage >= 60)
        {
            grade = "C";
        } else if (averagePercentage >= 50)
        {
            grade = "D";
        } else
        {
            grade = "F";
        }
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
