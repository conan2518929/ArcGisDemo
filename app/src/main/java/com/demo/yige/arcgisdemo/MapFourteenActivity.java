package com.demo.yige.arcgisdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

import com.esri.arcgisruntime.geometry.GeometryEngine;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Callout;
import com.esri.arcgisruntime.mapping.view.DefaultMapViewOnTouchListener;
import com.esri.arcgisruntime.mapping.view.MapView;

/**
 * Created by yige on 2016/12/14.
 */

public class MapFourteenActivity extends AppCompatActivity {

    private static final String sTag = "Gesture";
    private MapView mMapView;
    private Callout mCallout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourteen);

        // inflate MapView from layout
        mMapView = (MapView) findViewById(R.id.mapView);
        // create a map with the Basemap Type topographic
        final ArcGISMap mMap = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 41.8111339, 123.438973, 10);
        // set the map to be displayed in this view
        mMapView.setMap(mMap);

        mMapView.setOnTouchListener(new DefaultMapViewOnTouchListener(this, mMapView) {

            @Override
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                Log.d(sTag, "onSingleTapConfirmed: " + motionEvent.toString());

                // get the point that was clicked and convert it to a point in map coordinates
                android.graphics.Point screenPoint = new android.graphics.Point(Math.round(motionEvent.getX()),
                        Math.round(motionEvent.getY()));
                // create a map point from screen point
                Point mapPoint = mMapView.screenToLocation(screenPoint);
                // convert to WGS84 for lat/lon format
                Point wgs84Point = (Point) GeometryEngine.project(mapPoint, SpatialReferences.getWgs84());
                // create a textview for the callout
                TextView calloutContent = new TextView(getApplicationContext());
                calloutContent.setTextColor(Color.BLACK);
                calloutContent.setSingleLine();
                // format coordinates to 4 decimal places
                calloutContent.setText("Lat: " +  String.format("%.4f", wgs84Point.getY()) +
                        ", Lon: " + String.format("%.4f", wgs84Point.getX()));

                // get callout, set content and show
                mCallout = mMapView.getCallout();
                mCallout.setLocation(mapPoint);
                mCallout.setContent(calloutContent);
                mCallout.show();

                // center on tapped point
                mMapView.setViewpointCenterAsync(mapPoint);

                return true;
            }
        });
    }


    @Override
    protected void onPause(){
        super.onPause();
        mMapView.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mMapView.resume();
    }

}
