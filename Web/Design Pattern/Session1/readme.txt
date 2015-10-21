Module         		: WEB
Assignment for Session	: Design Pattern Session 2
Author			: Rohit

----------------------------------------------------------------
1. Write a Logger class (Singleton) to log application exceptions in Log file.

2. Write an application to create an Office and its employees without exposing their public constructors.
   Implement Classes like
	Factory (IWorkStation) -> MechanicalEngineer (IEngineer)
	And Office (IWorkStation) -> DeveloperEngineer (IEnginneer)
	Public Interface IEngineer {
		string Name     {get;set;}
		string Role     {get;set;}
	}
	Interface IWorkStation{
		Public List<IEngineer> Engineers {get;set;}
	}