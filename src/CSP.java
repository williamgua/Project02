import java.util.Set;

public abstract class CSP {
	
	public Set<Variable> variables;
	public Set<Constraint> constraints;
	public Set<Object> Domain;
	
	
	//for backtracking search method
	public boolean AssignmentIsComplete(Assignment a) {
	    if (this.variables.size() > a.assignments.size()) {
	    	return false; 
	    }
	    return true;
	  }
	
	
	//for backtracking search method
	public boolean consistent(Assignment a){
		for(Constraint c: this.constraints){
			if(!c.isSatisfied(a)){
				return false;
			}
		}
		return true;
	}
	
	
}
