public class Student extends Person 
{
	private int studentId;
	private String[] cources;
	
	public Student(int uid,String name,int studentId){
		super(uid,name);
		this.studentId=studentId;
	}
	
	public int getStudentId(){
		return studentId;
	}
	
	public void setStudentId(int studentId){
		this.studentId=studentId;
	}
	
	public String[] getCource(){
		return cources;
	}
	
	public void setCources(String[] cources){
		this.cources=cources;
	}
	
	public String toString(){
		return super.toString()+", StudentID "+studentId;
	}
}
