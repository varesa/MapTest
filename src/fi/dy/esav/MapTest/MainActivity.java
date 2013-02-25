package fi.dy.esav.MapTest;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	GoogleMap map = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	Log.e("fi.dy.esav.MapTest", "Started");
    	Log.e("fi.dy.esav.MapTest", "Started");
    	Log.e("fi.dy.esav.MapTest", "Started");
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(60.878303300051456, 26.07350405305624), 15));
     
        map.setOnCameraChangeListener(new OnCameraChangeListener() {
			
			@Override
			public void onCameraChange(CameraPosition arg0) {
				System.out.println("Lat: " + arg0.target.latitude + ", Long: " + arg0.target.longitude);
				
			}
		});

    	Log.e("fi.dy.esav.MapTest", "Initialising circlefactory");
    	Log.e("fi.dy.esav.MapTest", "Initialising circlefactory");
    	Log.e("fi.dy.esav.MapTest", "Initialising circlefactory");
        
        CircleFactory cf = new CircleFactory(this);
        //cf.setPosition(map.getCameraPosition().target.latitude, map.getCameraPosition().target.longitude);
        
        //MarkerOptions options = new MarkerOptions();
        
        LatLng position = cf.getCoords();
        //options.position(cf.getCoords());
        BitmapDescriptor image = BitmapDescriptorFactory.fromBitmap(cf.getBitmap());
        //options.icon(BitmapDescriptorFactory.fromBitmap(cf.getBitmap()));

        //Marker marker = map.addMarker(options);
        map.addGroundOverlay((new GroundOverlayOptions()).image(image).position(new LatLng(60.878303300051456, 26.07350405305624), 100));
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	Log.e("fi.dy.esav.MapTest", "Creating menus");
    	Log.e("fi.dy.esav.MapTest", "Creating menus");
    	Log.e("fi.dy.esav.MapTest", "Creating menus");
    	
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
