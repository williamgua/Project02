import java.util.HashSet;
import java.util.Set;
import java.util.Map.Entry;


public class JobShopCSP extends CSP {
	
	
	//inner class extends Constraint
	public class PrecedenceConstraint extends Constraint {
		
		public int time;
		
		public PrecedenceConstraint(Variable v1, Variable v2, int time){
			this.setVariable1(v1);
			this.setVariable2(v2);
			this.time = time;
		}
		public boolean isSatisfied(Assignment a){
		
			Integer value1 = (Integer) a.assignments.get(getVariable1());
			Integer value2 = (Integer) a.assignments.get(getVariable2());
			
			if(value1 == null){
				return true;
			}else if(value2 == null){
				return true;
			}else if((value1 + time) <= value2){
				return true;
			}
			return false;
		}
	}
	
	//another inner class extends Constraint
	public class DisjunctiveConstraint extends Constraint {
		
		public int time;
		
		public DisjunctiveConstraint(Variable v1, Variable v2, int time){
			this.setVariable1(v1);
			this.setVariable2(v2);
			this.time = time;
		}
		public boolean isSatisfied(Assignment a){
		
			Integer value1 = (Integer) a.assignments.get(getVariable1());
			Integer value2 = (Integer) a.assignments.get(getVariable2());
			
			if(value1 == null){
				return true;
			}else if(value2 == null){
				return true;
			}else if(value1 + time <= value2 ^ value2 + time <= value1){
				return true;
			}
			return false;
		}
	}
	
	
	//constructor that creates instances for the specific problem
	public JobShopCSP() {
		//Add Domain
		Set<Object> ADomain = new HashSet<Object>();
		for(int i = 1; i <= 15; i++){
			ADomain.add(i);
		}
		Set<Object> WDomain = new HashSet<Object>();
		for(int i = 10; i <= 20; i++){
			WDomain.add(i);
		}
		Set<Object> NDomain = new HashSet<Object>();
		for(int i = 12; i <= 27; i++){
			NDomain.add(i);
		}
		Set<Object> CDomain = new HashSet<Object>();
		for(int i = 15; i <= 27; i++){
			CDomain.add(i);
		}
		Set<Object> IDomain = new HashSet<Object>();
		for(int i = 20; i <= 27; i++){
			IDomain.add(i);
		}		
		
		//Add Variables
		this.variables = new HashSet<Variable>();
		Variable AxleF = new Variable("AxleF", ADomain);
		this.variables.add(AxleF);
		Variable AxleB = new Variable("AxleB", ADomain);
		this.variables.add(AxleB);
		Variable WheelRF = new Variable("WheelRF", WDomain);
		this.variables.add(WheelRF);
		Variable WheelLF = new Variable("WheelLF", WDomain);
		this.variables.add(WheelLF);
		Variable WheelRB = new Variable("WheelRB", WDomain);
		this.variables.add(WheelRB);
		Variable WheelLB = new Variable("WheelLB", WDomain);
		this.variables.add(WheelLB);
		Variable NutsRF = new Variable("NutsRF", NDomain);
		this.variables.add(NutsRF);
		Variable NutsLF = new Variable("NutsLF", NDomain);
		this.variables.add(NutsLF);
		Variable NutsRB = new Variable("NutsRB", NDomain);
		this.variables.add(NutsRB);
		Variable NutsLB = new Variable("NutsLB", NDomain);
		this.variables.add(NutsLB);
		Variable CapRF = new Variable("CapRF", CDomain);
		this.variables.add(CapRF);
		Variable CapLF = new Variable("CapLF", CDomain);
		this.variables.add(CapLF);
		Variable CapRB = new Variable("CapRB", CDomain);
		this.variables.add(CapRB);
		Variable CapLB = new Variable("CapLB", CDomain);
		this.variables.add(CapLB);
		Variable Inspect = new Variable("Inspect", IDomain);
		this.variables.add(Inspect);
		
		//Add Constraints
		this.constraints = new HashSet<Constraint>();
		this.constraints.add(new PrecedenceConstraint(AxleF, WheelRF, 10));
		this.constraints.add(new PrecedenceConstraint(AxleF, WheelLF, 10));
		this.constraints.add(new PrecedenceConstraint(AxleB, WheelRB, 10));
		this.constraints.add(new PrecedenceConstraint(AxleB, WheelLB, 10));
		this.constraints.add(new PrecedenceConstraint(WheelRF, NutsRF, 1));
		this.constraints.add(new PrecedenceConstraint(WheelLF, NutsLF, 1));
		this.constraints.add(new PrecedenceConstraint(WheelRB, NutsRB, 1));
		this.constraints.add(new PrecedenceConstraint(WheelLB, NutsLB, 1));
		this.constraints.add(new PrecedenceConstraint(NutsRF, CapRF, 2));
		this.constraints.add(new PrecedenceConstraint(NutsLF, CapLF, 2));
		this.constraints.add(new PrecedenceConstraint(NutsRB, CapRB, 2));
		this.constraints.add(new PrecedenceConstraint(NutsLB, CapLB, 2));
		
		this.constraints.add(new DisjunctiveConstraint(AxleF, AxleB, 5));
		this.constraints.add(new PrecedenceConstraint(AxleF, Inspect, 10));
		this.constraints.add(new PrecedenceConstraint(AxleB, Inspect, 10));
		this.constraints.add(new PrecedenceConstraint(WheelRF, Inspect, 1));
		this.constraints.add(new PrecedenceConstraint(WheelLF, Inspect, 1));
		this.constraints.add(new PrecedenceConstraint(WheelRB, Inspect, 1));
		this.constraints.add(new PrecedenceConstraint(WheelLB, Inspect, 1));
		this.constraints.add(new PrecedenceConstraint(NutsRF, Inspect, 2));
		this.constraints.add(new PrecedenceConstraint(NutsLF, Inspect, 2));
		this.constraints.add(new PrecedenceConstraint(NutsRB, Inspect, 2));
		this.constraints.add(new PrecedenceConstraint(NutsLB, Inspect, 2));
		this.constraints.add(new PrecedenceConstraint(CapRF, Inspect, 1));
		this.constraints.add(new PrecedenceConstraint(CapLF, Inspect, 1));
		this.constraints.add(new PrecedenceConstraint(CapRB, Inspect, 1));
		this.constraints.add(new PrecedenceConstraint(CapLB, Inspect, 1));
	}

	public static void main(String[] args) {
		
		System.out.println("-------------Job-shop scheduling Problem (AIMA 6.1.2) -----------------");
		CSP csp = new JobShopCSP();
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
