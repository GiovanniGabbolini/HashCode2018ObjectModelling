package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	DistanceBetweenCoordinates.class,
	VehicleAssignedRidesDescriptionConsisten.class,
	VehicleIsFreeWhenCreated.class,
	VehicleStateConsistentAfterRideAssignment.class,
	VehicleTestEquality.class,
	RideTestEquality.class,
	CoordinatesTestEquality.class,
	IOInputFormatReadConsistent.class,
	IOOutputFormatWriteConsistent.class,
	RideCannotBeAssignedMultipleTimes.class,
	VehicleBusyCannotGetAnotherRide.class,
	RideCannotBeAssignedBeforeItsEarliestStart.class,
})
public class SuiteFixedPoints {

}
