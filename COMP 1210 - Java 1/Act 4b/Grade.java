/**************************************
* Program to calculate grade in Java.
* @author Jacob Howard
**************************************/
public class Grade {
/**
* shows grades that will be used to calculate the overall grade for class
* @param args not used
*/

//declares the variables that will be used.
   private double exam1;
   private double exam2;
   private double finalExam;
   private double activityAvg;
   private double quizAvg;
   private double projectAvg;
   private String studentName;
   /**
   //declares the constants.
   */
   public static final int EXAM_1 = 1, EXAM_2 = 2, FINAL = 3;
   private static final double EXAM_WEIGHT = 0.15,
              FINAL_WEIGHT = 0.30, ACT_WEIGHT = 0.05,
              QUIZ_WEIGHT = 0.10, PROJ_WEIGHT = 0.25;
   /**
   //defines the constructor.
   * @param studentNameIn the Student Name
   */
   public Grade(String studentNameIn) {
      studentName = studentNameIn;
   }
   /**
   * Set lab averages.
   * @param activityAvgIn the the Activity Average
   * @param quizAvgIn the Quiz Average
   */
   public void setLabAverages(double activityAvgIn, double quizAvgIn) {
      activityAvg = activityAvgIn;
      quizAvg = quizAvgIn;
   }
   /**
   * Set the project averages.
   * @param projectAvgIn for the Projects Average
   */
   public void setProjectAvg(double projectAvgIn) {
      projectAvg = projectAvgIn;
   }
   /**
   * Set the exam scores.
   * @param examType for the type of Exam
   * @param examScoreIn for the score of the Exam
   */
   public void setExamScore(double examType, double examScoreIn) {
      if (examType == EXAM_1) {
         exam1 = examScoreIn;
      }
      else if (examType == EXAM_2) {
         exam2 = examScoreIn;
      }
      else if (examType == FINAL) {
         finalExam = examScoreIn;
      }
   }
   /**
   * Calculate the grade.
   * @return grade
   */
   public double calculateGrade() {
      double grade = exam1 * EXAM_WEIGHT + exam2 * EXAM_WEIGHT
         + finalExam * FINAL_WEIGHT
         + activityAvg * ACT_WEIGHT
         + quizAvg * QUIZ_WEIGHT
         + projectAvg * PROJ_WEIGHT;
      return grade;
   }
   /**
   * String the statement.
   * @return statement
   */
   public String toString() {
      return "Name: " + studentName + "\n"
            + "Course Grade: " + calculateGrade();
   }
}