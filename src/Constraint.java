
public abstract class Constraint {

	protected String constraintName;
	protected Variable variable1;
	protected Variable variable2;
	
	//Setters and Getters
	public Variable getVariable1() {
		return variable1;
	}
	public void setVariable1(Variable variable1) {
		this.variable1 = variable1;
	}
	public Variable getVariable2() {
		return variable2;
	}
	public void setVariable2(Variable variable2) {
		this.variable2 = variable2;
	}
	
	public String getConstraintName() {
		return constraintName;
	}
	public void setConstraintName(String constraintName) {
		this.constraintName = constraintName;
	}
	
	//abstract method implemented by specific constraints in each problem class
	public abstract boolean isSatisfied(Assignment a);
}
