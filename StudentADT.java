/****************************************************************************
 *
 * Created by: Teddy Sannan
 * Created on: March 2020
 * Created for: ICS4U
 * This program holds student information in an array, and as each new
 * student's info is entered, a new entry is created in the array
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// Create an enum of grades; can only be one of these following values
enum GRADES {

    TWELVE("12"),
    ELEVEN("11"),
    TEN("10"),
    NINE("9"),
    EIGHT("8"),
    SEVEN("7"),
    SIX("6"),
    FIVE("5"),
    FOUR("4"),
    THREE("3"),
    TWO("2"),
    ONE("1"),
    SK("Senior Kindergarten"),
    JK("Junior Kindergarten");

    private final String grade;

    GRADES(String grade)
    {
        this.grade = grade;
    }

    public String getGrade() {
        return this.grade;
    }
}

// Information for a single student
class Student
{
    public String _firstName;
    public String _lastName;
    public String _dateOfBirth; //dd/mm/yyyy
    public String _middleInitial;
    public GRADES _grade;
    public boolean _identified;

    //constructor
    public Student (String firstName,String lastName,String dateOfBirth, String middleInitial,GRADES grade,boolean identified)
    {
        this._firstName = firstName;
        this._lastName = lastName;
        this._dateOfBirth = dateOfBirth;
        this._middleInitial = middleInitial;
        this._grade = grade;
        this._identified = identified;
    }
}

public class StudentADT
{

    public static void main(String[] args) throws IOException
    {
        // get student info
        boolean moreStudents = true;

        String firstName;
        String lastName;
        String dateOfBirth;
        String middleInitial;
        GRADES grade;
        String gradeString;
        String identification;
        boolean identified = false;

        // Creates an array list (an array with no limit/index, so user can add indefinite amount of students
        ArrayList<Student> studentsArrList = new ArrayList<Student>();

        // Keeps asking for stuent information
	for (int counter = 0; moreStudents == true; counter++)
        {

            InputStreamReader r = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(r);

            // Obtains first name
            System.out.println("Enter a first name for student # " + (counter + 1) + ".");
            firstName = br.readLine();

            // Obtains last name
            System.out.println("Enter a last name for student # " + (counter + 1) + ".");
            lastName = br.readLine();

            // Obtains date of birth
            System.out.println("Enter a date of birth (DD/MM/YYYY) for student # " + (counter + 1) + ".");
            dateOfBirth = br.readLine();

            // Obtains middle initial
            System.out.println("Enter a middle initial for student # " + (counter + 1) + ".");
            middleInitial = br.readLine();

            // Obtains grade
            System.out.println("Enter a grade (as plain text: JK-TWELVE) for student # " + (counter + 1) + ".");
            gradeString = br.readLine();
            grade = GRADES.valueOf(gradeString.toUpperCase());

            // Asks if student is identified
            System.out.println("Is student # " + (counter + 1) + " identified? Y/N");

            if (br.readLine().equals("Y"))
            {
                identified = true;
            }
            else
            {
                identified = false;
            }

            // Creates a student with all the information obtained above
            Student currentStudent = new Student(firstName, lastName, dateOfBirth, middleInitial, grade, identified);

            studentsArrList.add(currentStudent); //append new student to array list
            System.out.print("Current Students: \n");

            // Prints out every student in array and their grade
            for(int nextStudent = 0; nextStudent < studentsArrList.size(); nextStudent ++)
            {
                // Prints student first, middle, last name and grade
                System.out.print(studentsArrList.get(nextStudent)._firstName + " " + studentsArrList.get(nextStudent)._middleInitial + " " + studentsArrList.get(nextStudent)._lastName + " is in Grade " + studentsArrList.get(nextStudent)._grade + "\n");

                // Prints student date of birth
                System.out.print(studentsArrList.get(nextStudent)._firstName + " is born " + studentsArrList.get(nextStudent)._dateOfBirth + "\n");

                // Checks if student is identified
                if (identified == true)
                {
                    identification = "identified";
                }
                else
                {
                    identification = "not identified";
                }

                // Prints if student is identified or not
                System.out.print(studentsArrList.get(nextStudent)._firstName + " is " + identification + "\n\n");
            }
            System.out.print("\n");
        }
    }

}