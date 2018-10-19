import java.util.Set;

public class Solver {

	//calls Backtracking search to solve CSP
	public Assignment BacktrackingSearchSolver(CSP csp){
		
		Assignment emptyAssignment = new Assignment();
	    
		return Backtrack(emptyAssignment,csp);
	}
	
	//recursive backtracking search
	public Assignment Backtrack(Assignment a, CSP csp) {
		
		Assignment temp = null;
		
		if(csp.AssignmentIsComplete(a)){
			return a;
		}
		
		Variable var = SelectUnassignedVar(a,csp);
		
		Set<Object> valueSet = var.getDomain();
		
		for(Object value : valueSet) {
		
			a.assignments.put(var, value);
			if(csp.consistent(a)) {
				temp = Backtrack(a,csp);
				if(temp != null) break;	
			}
			a.assignments.remove(var);
		}
		
		return temp;
	}


	
	public Variable SelectUnassignedVar(Assignment a, CSP csp) {
		for (Variable var: csp.variables){
			if (a.assignments.get(var)== null){
				return var;
			}
	    }
		return null;
	}
	
	
}
