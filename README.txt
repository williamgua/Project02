Collaboraters: Kehao Guo (kguo), Haozhang Deng (hdeng5), Xing Li (xli98)

Project Building:
Please unzip the file. All the source codes are in the src folder. You can run either by an IDE or by cmd/Terminal.
If using command line and having a java compiler preinstalled, please cd to the src directory and run the following code:
javac *.java
java AustraliaCSP	OR	java JobShopCSP		OR 	java NQueenCSP
(There is a main method for each specific CSP. To solve a specific CSP, please run the codes in the CSP's own class)

Each CSP extends the generic (abstract) CSP class which includes the sets of Variables, Constraints and Domain to create its own instance via 
its unique constructor. Each CSP also has inner classes that extend the abstract Constraint class and Variable class for further specification
in order to address the CSP. Futhermore, an Assignment is the set of all assiments made so far. 
Backtrack algorithm is located in the solver class, takes a CSP and returns a set of complete assignment as a solutionvto the CSP. 
It is very similar in structure to the one written in pseudo code from class.