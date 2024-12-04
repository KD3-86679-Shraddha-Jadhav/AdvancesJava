package assign01;

public class Marks {

	String Subject;
	double Marks;
	
	
	
	public Marks() {
		
	}
	public Marks(String subject, double marks) {
		
		Subject = subject;
		Marks = marks;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public double getMarks() {
		return Marks;
	}
	public void setMarks(double marks) {
		Marks = marks;
	}
	@Override
	public String toString() {
		return "Pojo [Subject=" + Subject + ", Marks=" + Marks + "]";
	}
	
}
