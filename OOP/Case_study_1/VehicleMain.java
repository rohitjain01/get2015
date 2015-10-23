/**
 * CASE STUDY Phase 1 Assignment
 * VehicleMain.java
 * @author Rohit
 *
 */
public class VehicleMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle vehicle = VehicleHelper.createVehicle("bike", "apacheRTR", "TVS"); // call create vehicle for bike
		System.out.println("\n Details of Bike is : ");
		System.out.print(VehicleDetailPrinter.printVehicleSpecification(vehicle));
		
		vehicle = VehicleHelper.createVehicle("car", "i10", "Hundai");		// call create vehicle for car
		System.out.println("\n Details of Car is : ");
		System.out.print(VehicleDetailPrinter.printVehicleSpecification(vehicle));

	}

}
