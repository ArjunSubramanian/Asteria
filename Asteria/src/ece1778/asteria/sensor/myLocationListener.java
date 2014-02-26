package ece1778.asteria.sensor;

 
	

	import java.io.IOException;
	import java.util.List;
	import java.util.Locale;

	import android.app.Fragment;
	import android.content.Context;
	import android.location.Address;
	import android.location.Geocoder;
	import android.location.Location;
	import android.location.LocationListener;
	import android.os.Bundle;
	import android.util.Log;
	import android.widget.Toast;

	public class myLocationListener  implements LocationListener 
	{
		Context context;
		
		

	  public void setContext(Context context) {
			this.context = context;
		}

	@Override
	  public void onLocationChanged(Location loc)
	  {

	    loc.getLatitude();
	    loc.getLongitude();

	    String Text = "My current location is: " +
	    "Latitud = " + loc.getLatitude() +
	    "Longitud = " + loc.getLongitude();
	    
	    
	  }

	  @Override
	  public void onProviderDisabled(String provider)
	  {
	    
	  }

	  @Override
	  public void onProviderEnabled(String provider)
	  {
	    Toast.makeText( context, "Gps Enabled", Toast.LENGTH_SHORT).show();
	  }

	 
	public void displaylocation(Location location)
	{
	location.getLatitude();
	location.getLongitude();

	String Text = "My current location is: " +
	"Latitud = " + location.getLatitude() +
	"Longitud = " + location.getLongitude();


	Geocoder gcd = new Geocoder(context,
	        Locale.getDefault());
	List<Address> addresses = null;
	try {
	    addresses = gcd.getFromLocation(location.getLatitude(),
	    		location.getLongitude(), 1);

	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	if (addresses != null) {
	    if (addresses.size() > 0) {
	        Log.v("Addresses : ", addresses.get(0).getSubLocality() + "");
	       
	        Log.v("gps", Text + " " + addresses.get(0).getSubLocality()
	                + "");
	    }
	} else {
	    Log.v("addresses ", "NULL");
	}

	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub
		
	}


	}


