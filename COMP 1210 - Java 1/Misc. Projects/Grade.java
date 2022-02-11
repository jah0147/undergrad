/*****************************
* @author Jacob Howard
* Description : 
*****************************/
import java.util.Scanner;
import java.text.DecimalFormat;
public class Grade {

   private double exam1;
   private double exam2;
   private double finalExam;
   private double quizAvg;
   private double activityAvg;
   private double projectAvg;
   private String studentName;
   
   public static final int EXAM_1 = 1, EXAM_2 = 2, EXAM_3 = 3;
   private static final double EXAM_WEIGHT = 0.15, FINAL_WEIGHT = 0.30,
   ACT_WEIGHT = 0.05, QUIZ_WEIGHT = 0.10, PROJ_WEIGHT = 0.25;
   
   //Constructor
   public Grade(String studentNameIn) {
      studentName =  studentnameIn;
   }
   public void setLabAverages(double activityAvgIn, double quizAvgIn) {
   }
   public void setProjectAvg(double projectAvgIn) {
   }
   public void setExamScore( int examType, double examScoreIn) {
   }
   
   //Calculates grade
   public double calculateGrade() {
      return 0.0;
   }
   public String toString() {
      return "Name: " + studentName + "\n"
         + "Course Grade: " + calculateGrade;
   }
}