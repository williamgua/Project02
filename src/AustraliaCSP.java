import java.util.HashSet;
import java.util.Map.Entry;


public class AustraliaCSP extends CSP {
	
	
	//inner class extends Constraint
	public class NotEqualConstraint extends Constraint {
		
		public NotEqualConstraint(Variable v1, Variable v2){
			this.setVariable1(v1);
			this.setVariable2(v2);
		}
		public boolean isSatisfied(Assignment a){
		
			Object value1 = a.assignments.get(getVariable1());
			Object value2 = a.assignments.get(getVariable2());
			
			if(value1 == null){
				return true;
			}else if(value2 == null){
				return true;
			}else if(!value1.equals(value2)){
				return true;
			}
			return false;
		}
		
	}
	
	//constructor that creates instances for the specific problem
	public AustraliaCSP() {
		//Add Domain
		this.Domain = new HashSet<Object>();
		Domain.add("Red");
		Domain.add("Green");
		Domain.add("Blue");
		
		//Add Variables
		this.variables = new HashSet<Variable>();
		Variable WA = new Variable("WA", Domain);
		this.variables.add(WA);
		Variable NT = new Variable("NT", Domain);
		this.variables.add(NT);
		Variable Q = new Variable("Q", Domain);
		this.variables.add(Q);
		Variable NSW = new Variable("NSW", Domain);
		this.variables.add(NSW);
		Variable V = new Variable("V", Domain);
		this.variables.add(V);
		Variable SA = new Variable("SA", Domain);
		this.variables.add(SA);
		Variable T = new Variable("T", Domain);
		this.variables.add(T);
		
		//Add Constraints
		this.constraints = new HashSet<Constraint>();
		this.constraints.add(new NotEqualConstraint(SA, WA));
		this.constraints.add(new NotEqualConstraint(SA, NT));
		this.constraints.add(new NotEqualConstraint(SA, Q));
		this.constraints.add(new NotEqualConstraint(SA, NSW));
		this.constraints.add(new NotEqualConstraint(SA, V));
		this.constraints.add(new NotEqualConstraint(WA, NT));
		this.constraints.add(new NotEqualConstraint(NT, Q));
		this.constraints.add(new NotEqualConstraint(Q, NSW));
		this.constraints.add(new NotEqualConstraint(NSW, V));
	}

	public static void main(String[] args) {
		
		System.out.println("-------------Australia Map Coloring Problem (AIMA 6.1.1) -----------------");
		CSP csp = new AustraliaCSP();
		System.out.println("-------------Backtracking search solver--------------------------");
		Solver solver = new Solver();
		Assignment result = solver.BacktrackingSearchSolver(csp);

		System.out.println();
		System.out.println("Solution:");
	
		//print out the assignments
		for(Entry<Variable, Object> item : result.assignments.entrySet()) {
			System.out.println(item.getKey().getName() + ": " + item.getValue());
		}
		
		
		
		
	}

	
}
