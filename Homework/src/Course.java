import java.util.*;
import java.lang.Object;
public class Course implements Cloneable
{
	private String courseName;
	private String[] students = new String[100];
	private int numberOfStudents;
	
	public Course(String courseName)
	{
		this.courseName = courseName;
	}
	
	public void addStudent(String student)
	{
		students[numberOfStudents] = student;
		numberOfStudents++;
	}
	
	public String[] getStudents()
	{
		return students;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public void setCourseName(String n)
	{
		courseName = n;
	}
	
	public int getNumberOfStudents()
	{
		return numberOfStudents;
	}
	
	public void dropStudent(String student)
	{
		int i = 0;
		for(i = 0;i < numberOfStudents;i++)
			if(students[i].equals(student))
				break;
		for(;i < numberOfStudents-1;i++)
			students[i] = students[i+1];
		numberOfStudents--;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
			Course course = (Course)super.clone();
			course.students = ((String[])(students.clone()));
			return course;
	}
}
