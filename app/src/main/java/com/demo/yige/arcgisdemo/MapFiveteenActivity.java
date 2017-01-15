package com.demo.yige.arcgisdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.esri.arcgisruntime.geometry.Envelope;
import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;
import com.esri.arcgisruntime.symbology.SimpleRenderer;

/**
 * Created by yige on 2016/12/14.
 */

public class MapFiveteenActivity extends AppCompatActivity {
    MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiveteen);

        //Create points to add graphics to the map to allow a renderer to style them
        //These are in WGS84 coordinates (Long, Lat)41.8111339, 123.438973
        Point oldFaithfullPoint = new Point(123.438973, 41.8111339, SpatialReferences.getWgs84());
        Point cascadeGeyserPoint = new Point(123.442233, 41.779485, SpatialReferences.getWgs84());
        Point plumeGeyserPoint = new Point(123.477814, 41.715674, SpatialReferences.getWgs84());
        //Use the farthest points to create an envelope to use for the map views visible area
        Envelope initialEnvelope = new Envelope(oldFaithfullPoint, plumeGeyserPoint);

        // inflate MapView from layout
        mMapView = (MapView) findViewById(R.id.mapView);
        // create a map with the imagery basemap. This will set the map to have a WebMercator spatial reference
        ArcGISMap map = new ArcGISMap(Basemap.createImageryWithLabels());
        // set the map to be displayed in the mapview
        mMapView.setMap(map);

        //set initial envelope on the map view sith some padding so all points will be visible
        //This envelope is using the WGS84 points above, but is reprojected by the mapview into the maps spatial reference, so its works fine
        mMapView.setViewpointGeometryAsync(initialEnvelope, 100);

        // create a new graphics overlay and add it to the mapview
        GraphicsOverlay graphicOverlay = new GraphicsOverlay();
        mMapView.getGraphicsOverlays().add(graphicOverlay);

        //[DocRef: Name=Simple Renderer, Category=Fundamentals, Topic=Symbols and Renderers]
        //create a simple symbol for use in a simple renderer
        SimpleMarkerSymbol symbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.Style.CROSS, Color.RED, 12); //size 12, style of cross
        SimpleRenderer renderer = new SimpleRenderer(symbol);

        //apply the renderer to the graphics overlay (so all graphics will use the same symbol from the renderer)
        graphicOverlay.setRenderer(renderer);
        //[DocRef: END]

        //create graphics from the geyser location points. NOTE: no need to set the symbol on the graphic because the renderer takes care of it
        //The points are in WGS84, but graphics get reprojected automatically, so they work fine in a map with a spatial reference of web mercator
        Graphic oldFaithfullGraphic = new Graphic(oldFaithfullPoint);
        Graphic cascadeGeyserGraphic = new Graphic(cascadeGeyserPoint);
        Graphic plumeGeyserGraphic = new Graphic(plumeGeyserPoint);
        graphicOverlay.getGraphics().add(oldFaithfullGraphic);
        graphicOverlay.getGraphics().add(cascadeGeyserGraphic);
        graphicOverlay.getGraphics().add(plumeGeyserGraphic);

    }

    @Override
    protected void onPause(){
        super.onPause();
        // pause MapView
        mMapView.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        // resume MapView
        mMapView.resume();
    }
}
