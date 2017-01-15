package com.demo.yige.arcgisdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.esri.arcgisruntime.layers.ArcGISMapImageLayer;
import com.esri.arcgisruntime.layers.SublayerList;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.MapView;

/**
 * Created by yige on 2016/12/9.
 */

public class MapSixActivity extends AppCompatActivity {

    private MapView mMapView;
    private ArcGISMapImageLayer mMapImageLayer;
    private SublayerList mLayers;

    // The layer on/off menu items.
    private MenuItem mCities = null;
    private MenuItem mContinent = null;
    private MenuItem mWorld = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        // inflate MapView from layout
        mMapView = (MapView) findViewById(R.id.mapView);
        // create a map with the Basemap Type topographic
        ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 48.354406, -99.998267, 2);
        // create a MapImageLayer with dynamically generated map images
        mMapImageLayer = new ArcGISMapImageLayer(getResources().getString(R.string.world_cities_service));
        mMapImageLayer.setOpacity(0.5f);
        // add world cities layers as map operational layer
        map.getOperationalLayers().add(mMapImageLayer);
        // set the map to be displayed in this view
        mMapView.setMap(map);
        // get the layers from the map image layer
        mLayers = mMapImageLayer.getSublayers();

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_six, menu);

        // Get the sub layer switching menu items.
        mCities = menu.getItem(0);
        mContinent = menu.getItem(1);
        mWorld = menu.getItem(2);

        // set all layers on by default
        mCities.setChecked(true);
        mContinent.setChecked(true);
        mWorld.setChecked(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle menu item selection
        //if-else is used because this sample is used elsewhere as a Library module
        int itemId = item.getItemId();
        if(itemId == R.id.Cities){
            if(mLayers.get(0).isVisible() && mCities.isChecked()){
                // cities layer is on and menu item checked
                mLayers.get(0).setVisible(false);
                mCities.setChecked(false);
            }else if(!mLayers.get(0).isVisible() && !mCities.isChecked()){
                // cities layer is off and menu item unchecked
                mLayers.get(0).setVisible(true);
                mCities.setChecked(true);
            }
            return true;
        }else if(itemId == R.id.Continents){
            if(mLayers.get(1).isVisible() && mContinent.isChecked()){
                // continent layer is on and menu item checked
                mLayers.get(1).setVisible(false);
                mContinent.setChecked(false);
            }else if(!mLayers.get(1).isVisible() && !mContinent.isChecked()){
                // continent layer is off and menu item unchecked
                mLayers.get(1).setVisible(true);
                mContinent.setChecked(true);
            }
            return true;
        }else if(itemId == R.id.World){
            if(mLayers.get(2).isVisible() && mWorld.isChecked()){
                // world layer is on and menu item checked
                mLayers.get(2).setVisible(false);
                mWorld.setChecked(false);
            }else if(!mLayers.get(2).isVisible() && !mWorld.isChecked()){
                // world layer is off and menu item unchecked
                mLayers.get(2).setVisible(true);
                mWorld.setChecked(true);
            }
            return true;
        }else{
            return super.onOptionsItemSelected(item);
        }
    }

}
