package com.demo.yige.arcgisdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.esri.arcgisruntime.data.ServiceFeatureTable;
import com.esri.arcgisruntime.geometry.Envelope;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.layers.FeatureLayer;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.Viewpoint;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.symbology.SimpleLineSymbol;
import com.esri.arcgisruntime.symbology.SimpleRenderer;

/**
 * Created by yige on 2016/12/9.
 */

public class MapFiveActivity extends AppCompatActivity {

    MapView mMapView;
    FeatureLayer mFeatureLayer;

    boolean overrideActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        // set up the bottom toolbar
        createBottomToolbar();

        // inflate MapView from layout
        mMapView = (MapView) findViewById(R.id.mapView);

        // create a map with the topographic basemap
        ArcGISMap map = new ArcGISMap(Basemap.createTopographic());
        //set an initial viewpoint
        map.setInitialViewpoint(new Viewpoint(
                new Envelope(-1.30758164047166E7, 4014771.46954516, -1.30730056797177E7, 4016869.78617381,
                        SpatialReferences.getWebMercator())));


        // create feature layer with its service feature table
        ServiceFeatureTable serviceFeatureTable = new ServiceFeatureTable(
                getResources().getString(R.string.sample_service_url));
        mFeatureLayer = new FeatureLayer(serviceFeatureTable);

        // add the layer to the map
        map.getOperationalLayers().add(mFeatureLayer);

        // set the map to be displayed in the mapview
        mMapView.setMap(map);

    }

    private void overrideRenderer() {

        // create a new simple renderer for the line feature layer
        SimpleLineSymbol lineSymbol = new SimpleLineSymbol(SimpleLineSymbol.Style.SOLID, Color.rgb(0, 0, 255), 2);
        SimpleRenderer simpleRenderer = new SimpleRenderer(lineSymbol);

        // override the current renderer with the new renderer defined above
        mFeatureLayer.setRenderer(simpleRenderer);
    }

    private void resetRenderer() {

        // reset the renderer back to the definition from the source (feature service) using the reset renderer method
        mFeatureLayer.resetRenderer();

    }

    private void createBottomToolbar() {

        Toolbar bottomToolbar = (Toolbar) findViewById(R.id.bottomToolbar);
        bottomToolbar.inflateMenu(R.menu.menu_two);

        bottomToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle action bar item clicks
                int itemId = item.getItemId();
                //if statement is used because this sample is used elsewhere as a Library module
                if(itemId == R.id.action_override_rend){
                    // check the state of the menu item
                    if (!overrideActive) {
                        overrideRenderer();
                        // change the text to reset
                        overrideActive = true;
                        item.setTitle(R.string.action_reset);
                    } else {
                        resetRenderer();
                        // change the text to override
                        overrideActive = false;
                        item.setTitle(R.string.action_override_rend);
                    }
                }
                return true;
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
        // pause MapView
        mMapView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // resume MapView
        mMapView.resume();
    }
}
