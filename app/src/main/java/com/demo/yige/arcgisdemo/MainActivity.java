package com.demo.yige.arcgisdemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.PolygonBuilder;
import com.esri.arcgisruntime.geometry.PolylineBuilder;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.symbology.SimpleFillSymbol;
import com.esri.arcgisruntime.symbology.SimpleLineSymbol;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;
import com.esri.arcgisruntime.symbology.SimpleRenderer;

public class MainActivity extends Activity {

    private MapView mMapView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        mMapView = (MapView) findViewById(R.id.mapView);
        ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 41.8111339, 123.438973, 11);
//        ArcGISMap map = new ArcGISMap(Basemap.Type.TOPOGRAPHIC, 15.169193, 16.333479, 2);
        addGraphicsOverlay();
        mMapView.setMap(map);
    }

    private void addGraphicsOverlay(){
        // point graphic
        Point pointGeometry = new Point(40e5, 40e5, SpatialReferences.getWebMercator());
        // red diamond point symbol
        SimpleMarkerSymbol pointSymbol = new SimpleMarkerSymbol(SimpleMarkerSymbol.Style.DIAMOND, Color.RED, 10);
        // create graphic for point
        Graphic pointGraphic = new Graphic(pointGeometry);
        // create a graphic overlay for the point
        GraphicsOverlay pointGraphicOverlay = new GraphicsOverlay();
        // create simple renderer
        SimpleRenderer pointRenderer = new SimpleRenderer(pointSymbol);
        pointGraphicOverlay.setRenderer(pointRenderer);
        // add graphic to overlay
        pointGraphicOverlay.getGraphics().add(pointGraphic);
        // add graphics overlay to the MapView
        mMapView.getGraphicsOverlays().add(pointGraphicOverlay);

        // line graphic
        PolylineBuilder lineGeometry = new PolylineBuilder(SpatialReferences.getWebMercator());
        lineGeometry.addPoint(-10e5, 40e5);
        lineGeometry.addPoint(20e5, 50e5);
        // solid blue line symbol
        SimpleLineSymbol lineSymbol = new SimpleLineSymbol(SimpleLineSymbol.Style.SOLID, Color.BLUE, 5);
        // create graphic for polyline
        Graphic lineGraphic = new Graphic(lineGeometry.toGeometry());
        // create graphic overlay for polyline
        GraphicsOverlay lineGraphicOverlay = new GraphicsOverlay();
        // create simple renderer
        SimpleRenderer lineRenderer = new SimpleRenderer(lineSymbol);
        // add graphic to overlay
        lineGraphicOverlay.setRenderer(lineRenderer);
        // add graphic to overlay
        lineGraphicOverlay.getGraphics().add(lineGraphic);
        // add graphics overlay to the MapView
        mMapView.getGraphicsOverlays().add(lineGraphicOverlay);

        //polygon graphic
        PolygonBuilder polygonGeometry = new PolygonBuilder(SpatialReferences.getWebMercator());
        polygonGeometry.addPoint(-20e5, 20e5);
        polygonGeometry.addPoint(20e5, 20e5);
        polygonGeometry.addPoint(20e5, -20e5);
        polygonGeometry.addPoint(-20e5, -20e5);
        // solid yellow polygon symbol
        SimpleFillSymbol polygonSymbol = new SimpleFillSymbol(SimpleFillSymbol.Style.SOLID, Color.YELLOW, null);
        // create graphic for polygon
        Graphic polygonGraphic = new Graphic(polygonGeometry.toGeometry());
        // create graphic overlay for polygon
        GraphicsOverlay polygonGraphicOverlay = new GraphicsOverlay();
        // create simple renderer
        SimpleRenderer polygonRenderer = new SimpleRenderer(polygonSymbol);
        // add graphic to overlay
        polygonGraphicOverlay.setRenderer(polygonRenderer);
        // add graphic to overlay
        polygonGraphicOverlay.getGraphics().add(polygonGraphic);
        // add graphics overlay to MapView
        mMapView.getGraphicsOverlays().add(polygonGraphicOverlay);

    }

    @Override
    protected void onPause(){
        mMapView.pause();
        super.onPause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mMapView.resume();
    }

}
