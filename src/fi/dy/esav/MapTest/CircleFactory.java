package fi.dy.esav.MapTest;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.Projection;

public class CircleFactory {
	// 1. some variables:

	private static final double EARTH_RADIUS = 6378100.0;
	private int offset;

	MainActivity main;
	GoogleMap map;

	double lat;
	double lng;

	public CircleFactory(MainActivity activity) {

		Log.e("fi.dy.esav.MapTest", "CircleFactory constructor");
		Log.e("fi.dy.esav.MapTest", "CircleFactory constructor");
		Log.e("fi.dy.esav.MapTest", "CircleFactory constructor");

		main = activity;
		map = main.map;
	}

	public void setPosition(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}

	// 2. convert meters to pixels between 2 points in current zoom:

	private int convertMetersToPixels(double radiusInMeters) {

		Log.e("fi.dy.esav.MapTest", "CircleFactory meters to pixels");
		Log.e("fi.dy.esav.MapTest", "CircleFactory meters to pixels");
		Log.e("fi.dy.esav.MapTest", "CircleFactory meters to pixels");

		double lat1 = radiusInMeters / EARTH_RADIUS;
		double lng1 = radiusInMeters
				/ (EARTH_RADIUS * Math.cos((Math.PI * lat / 180)));

		double lat2 = lat + lat1 * 180 / Math.PI;
		double lng2 = lng + lng1 * 180 / Math.PI;

		Point p1 = map.getProjection().toScreenLocation(new LatLng(lat, lng));
		Point p2 = map.getProjection().toScreenLocation(new LatLng(lat2, lng2));

		return Math.abs(p1.x - p2.x);
	}

	// 3. bitmap creation:

	Bitmap getBitmap() {

		Log.e("fi.dy.esav.MapTest", "CircleFactory getting bitmap");
		Log.e("fi.dy.esav.MapTest", "CircleFactory getting bitmap");
		Log.e("fi.dy.esav.MapTest", "CircleFactory getting bitmap");
		
		/*
		
		// fill color
		Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint1.setColor(0x110000FF);
		paint1.setStyle(Style.FILL);

		// stroke color
		Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint2.setColor(0xFF0000FF);
		paint2.setStyle(Style.STROKE);

		// icon
		// Bitmap icon = BitmapFactory.decodeResource(main.getResources(),
		// R.drawable.blue);
		Bitmap icon = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);

		// circle radius - 200 meters
		int radius = offset = convertMetersToPixels(200);

		// if zoom too small
		if (radius < icon.getWidth() / 2) {

			radius = icon.getWidth() / 2;
		}

		// create empty bitmap
		Bitmap b = Bitmap
				.createBitmap(radius * 2, radius * 2, Config.ARGB_8888);
		Canvas c = new Canvas(b);

		// draw blue area if area > icon size
		/*if (radius != icon.getWidth() / 2) {

			c.drawCircle(radius, radius, radius, paint1);
			c.drawCircle(radius, radius, radius, paint2);
		}

		// draw icon
		c.drawBitmap(icon, radius - icon.getWidth() / 2,
				radius - icon.getHeight() / 2, new Paint());*/
		
		Bitmap b = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
		Canvas c = new Canvas(b);
		
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		
		c.drawCircle(200, 200, 100, paint);
		
		
		return b;
	}

	// 4. calculate image offset:

	LatLng getCoords() {
		

		Log.e("fi.dy.esav.MapTest", "CircleFactory getting coordinates");
		Log.e("fi.dy.esav.MapTest", "CircleFactory getting coordinates");
		Log.e("fi.dy.esav.MapTest", "CircleFactory getting coordinates");

		LatLng latLng = new LatLng(lat, lng);

		Projection proj = map.getProjection();
		Point p = proj.toScreenLocation(latLng);
		p.set(p.x, p.y + offset);

		return proj.fromScreenLocation(p);
	}

}
