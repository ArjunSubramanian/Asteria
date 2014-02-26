package ece1778.asteria.sensor;

/*To access the method call the default constructor
 * set the activity and context using setActivity and setContext method
 * call the updateLocation method
 * then get the Location Latitude and Longitude using the respective getters */
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class LocationSensor {

	private Location Loc;
	private Activity activity;
	private Context context;
	private double latitude;
	private double longitude;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Location getLoc() {
		return Loc;
	}

	public void setLoc(Location loc) {
		Loc = loc;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public void updateLoaction() {
		LocationManager mlocManager = (LocationManager) getActivity()
				.getSystemService(Context.LOCATION_SERVICE);
		myLocationListener mlocListener = new myLocationListener();
		 
		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				mlocListener);
		mlocManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0,
				0, mlocListener);
		if ((mlocManager != null)) {
			Location l = (Location) mlocManager
					.getLastKnownLocation(LocationManager.GPS_PROVIDER);
			if (l != null) {
				setLoc(l);
				setLatitude(l.getLatitude());
				setLongitude(l.getLongitude());
			} else {
				Location l1 = mlocManager
						.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
				setLoc(l1);
				setLatitude(l1.getLatitude());
				setLongitude(l1.getLongitude());
			}
		}
	}
}
