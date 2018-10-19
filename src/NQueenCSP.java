import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


public class NQueenCSP extends CSP {
	
	//n of n-queen
	protected int n;

	
	//inner class extends Constraint
	public class NotAttackingConstraint extends Constraint {
		public int colNum1;
		public int colNum2;
		
		public NotAttackingConstraint(NQueenVar v1, NQueenVar v2){
			this.setVariable1(v1);
			this.setVariable2(v2);
			this.colNum1 = v1.column;
			this.colNum2 = v2.column;
		}
		
		public boolean isSatisfied(Assignment a){
		
			Integer rowNum1 = (Integer)a.assignments.get(getVariable1());
			Integer rowNum2 = (Integer)a.assignments.get(getVariable2());
			
			if(rowNum1 == null){
				return true;
			}else if(rowNum2 == null){
				return true;
			}
			
			if(rowNum1.equals(rowNum2)){
				return false;
			}
			if(Math.abs(colNum1 - colNum2) == Math.abs(rowNum1 - rowNum2)){
				
				return false;
			}
			return true;
		}
	}
		
		public class NQueenVar extends Variable {
			
			public int column;
			
			public int getColumn() {
				return column;
			}

			public NQueenVar(String name, Set<Object> domain, int column) {
				super(name, domain);
				this.column = column;
			}
		}
		
		
		//constructor that creates instances for the specific problem
		public NQueenCSP(int n) {
			
			this.n = n;
			
			//Add Domain
			this.Domain = new HashSet<Object>(); //values are row number
			for(int i=1; i<=n; i++) {
				Domain.add(i);
			}
			
			//Add Variables
			this.variables = new HashSet<>();
			for(int i=1; i<=n; i++) {
				String name = "Q"+Integer.toString(i); //i is column number; for example, Q1 is the queen in the first column
				variables.add(new NQueenVar(name, Domain, i));
			}	
			
			//Add Constraints
			Map<String,Variable> map = new HashMap<>(); //a map that gets variables using variables' names as keys
			for(Variable var : variables) {
				map.put(var.getName(), var);
			}
			
			this.constraints = new HashSet<Constraint>();
			
			for(int i=1; i < n; i++) {
				for(int j=i+1; j<=n; j++) {	
					constraints.add(new NotAttackingConstraint((NQueenVar)map.get("Q"+Integer.toString(i)), (NQueenVar)map.get("Q"+Integer.toString(j))));
				}
			}
			
		}

		public static void main(String[] args) {
			
			System.out.println("-------------N Queen Problem (AIMA 4.1.1) -----------------");
			System.out.println("Please enter the value of n");
			Scanner scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			scanner.close();
			NQueenCSP csp = new NQueenCSP(n);
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
