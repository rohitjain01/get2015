Module         		: WEB
Assignment for Session	: MVC2 & Java Annotation Session 2
Author			: Rohit

----------------------------------------------------------------
1. Define an annotation type for an enhancement request with elements id, synopsis, engineer, and date.
   Specify the default value as unassigned for engineer and unknown for date

2. Use Faster-XML/Jackson API to parse a Model class to JSON and vice versa.
   Model Class - Employee:
	employeeName
	employeeId
	emailId
	dateOfBirth
	dateOfJoining
	ctcPerAnnum

    Only following fields should be converted to JSON String -
	employeeName
	employeeId
	emailId
	dateOfJoining

     Only follwing fields should be converted to Model Object from JSON -
	employeeName
	employeeId
	dateOfBirth

     Only following fields are allowed to be null -
	dateOfBirth
	dateOfJoining

3. Create an annotation CanRun with no elements.
   Create a class AnnotationRunner, with 5 methods (method1 to method5), 
   printing unique text to console in each method (e.g method1() prints “Executing method-1”).
   Put CanRun annotation on methods 1, 3 and 5.
   Create a main class which instantiates an object of AnnotationRunner, and executes all the methods with annotation CanRun.
   Verify the output on the console.


3. Add following page to above site -
   Employee Registration Page / Employee Edit Info Page (Common page should be used)
			Should have a Registration / Edit form with following fields (In case of Edit, values should be pre-filled)-
				Name
				Email
				Age
				Employee ID
			Upon successful registration/edit, should redirect to Employee List Page





