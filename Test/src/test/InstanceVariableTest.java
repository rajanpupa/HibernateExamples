package test;

public class InstanceVariableTest {
	int i;
	
	// static field
	public static int count=0;

	public int getI() {
		return i;
	}

	protected void setI(int i) {
		this.i = i;
	}
	
	
	public static void main(String[] args) {
		System.out.println(new InstanceVariableTest().getI());
		int j=0;
		
		System.out.println(j);
	}
}
