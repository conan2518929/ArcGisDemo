package com.demo.yige.arcgisdemo;

import android.app.Activity;
import android.os.Bundle;

import com.esri.arcgisruntime.layers.ArcGISMapImageLayer;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.view.MapView;

/**
 * Created by yige on 2016/12/8.
 */

public class MapTwoActivity extends Activity {

    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        // inflate MapView from layout
        mMapView = (MapView) findViewById(R.id.mapView);
        // create a MapImageLayer with dynamically generated map images
//        ArcGISMapImageLayer mapImageLayer = new ArcGISMapImageLayer(getResources().getString(R.string.world_elevation_service));
        ArcGISMapImageLayer mapImageLayer = new ArcGISMapImageLayer(getResources().getString(R.string.world_elevation_service_one));
        // create an empty map instance
        ArcGISMap map = new ArcGISMap();
        // add map image layer as operational layer
        map.getOperationalLayers().add(mapImageLayer);
        // set the map to be displayed in this view
        mMapView.setMap(map);

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
