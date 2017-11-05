package com.group2.soft.induk;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.nhn.android.maps.NMapActivity;
import com.nhn.android.maps.NMapController;
import com.nhn.android.maps.NMapOverlay;
import com.nhn.android.maps.NMapOverlayItem;
import com.nhn.android.maps.NMapView;
import com.nhn.android.maps.maplib.NGeoPoint;
import com.nhn.android.maps.nmapmodel.NMapError;
import com.nhn.android.maps.overlay.NMapPOIdata;
import com.nhn.android.mapviewer.overlay.NMapCalloutOverlay;
import com.nhn.android.mapviewer.overlay.NMapOverlayManager;
import com.nhn.android.mapviewer.overlay.NMapPOIdataOverlay;

/**
 * Created by Lee Kyu Hwa on 2016-08-19.
 */
public class ShowMapOne extends NMapActivity implements NMapView.OnMapViewTouchEventListener, NMapView.OnMapStateChangeListener, NMapOverlayManager.OnCalloutOverlayListener {

    private Intent intent1 = new Intent();

    public static final String API_KEY = "giSVTAMFpwlelpR1faH0";
    private NMapView mMapView = null;
    private NMapController mMapController = null;
    private LinearLayout MapContainer;

    // 오버레이의 리소스를 제공하기 위한 객체
    NMapViewerResourceProvider mMapViewerResourceProvider = null;
    // 오버레이 관리자
    NMapOverlayManager mOverlayManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_detail);

        intent1 = getIntent();
        String mapx = intent1.getStringExtra("mapx");
        String mapy = intent1.getStringExtra("mapy");
        String addr1 = intent1.getStringExtra("addr1");
        System.out.println("MAPX ::" + mapx + mapy + addr1);

        MapContainer = (LinearLayout) findViewById(R.id.map);

        mMapView = new NMapView(this);
        mMapView.setApiKey(API_KEY);
        setContentView(mMapView);
        mMapView.setClickable(true);
        mMapView.setOnMapStateChangeListener(this);
        mMapView.setOnMapViewTouchEventListener(this);
        mMapView.setBuiltInZoomControls(true, null);
        mMapController = mMapView.getMapController();

        /******************* 오버레이 관련 코드 시작 ********************/
        // 오버레이 리소스 관리객체 할당
        mMapViewerResourceProvider = new NMapViewerResourceProvider(this);

        // 오버레이 관리자 추가
        mOverlayManager = new NMapOverlayManager(this, mMapView,
                mMapViewerResourceProvider);

        // 오버레이들을 관리하기 위한 id값 생성
        int markerId = NMapPOIflagType.PIN;

        // 표시할 위치 데이터를 지정한다. 마지막 인자가 오버레이를 인식하기 위한 id값
        NMapPOIdata poiData = new NMapPOIdata(1, mMapViewerResourceProvider);
        poiData.beginPOIdata(1);
        poiData.addPOIitem(Double.parseDouble(mapx), Double.parseDouble(mapy), addr1, markerId, 0);
        poiData.endPOIdata();

        // 위치 데이터를 사용하여 오버레이 생성
        NMapPOIdataOverlay poiDataOverlay
                = mOverlayManager.createPOIdataOverlay(poiData, null);

        // id값이 0으로 지정된 모든 오버레이가 표시되고 있는 위치로
        // 지도의 중심과 ZOOM을 재설정
        poiDataOverlay.showAllPOIdata(0);

        // 오버레이 이벤트 등록
        mOverlayManager.setOnCalloutOverlayListener(this);
        /******************* 오버레이 관련 코드 끝 ********************/

    }

    @Override
    public void onMapInitHandler(NMapView nMapView, NMapError nMapError) {
        intent1 = getIntent();
        String mapx = intent1.getStringExtra("mapx");
        String mapy = intent1.getStringExtra("mapy");
        String addr1 = intent1.getStringExtra("addr1");

        if (nMapError == null) {
            mMapController.setMapCenter(new NGeoPoint(Double.parseDouble(mapx), Double.parseDouble(mapy)), 50);
        } else {
            android.util.Log.e("NMAP", "onMapInitHandler: error=" + nMapError.toString());
        }
    }

    @Override
    public void onMapCenterChange(NMapView nMapView, NGeoPoint nGeoPoint) {

    }

    @Override
    public void onMapCenterChangeFine(NMapView nMapView) {

    }

    @Override
    public void onZoomLevelChange(NMapView nMapView, int i) {

    }

    @Override
    public void onAnimationStateChange(NMapView nMapView, int i, int i1) {

    }

    @Override
    public void onLongPress(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onLongPressCanceled(NMapView nMapView) {

    }

    @Override
    public void onTouchDown(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onTouchUp(NMapView nMapView, MotionEvent motionEvent) {

    }

    @Override
    public void onScroll(NMapView nMapView, MotionEvent motionEvent, MotionEvent motionEvent1) {

    }

    @Override
    public void onSingleTapUp(NMapView nMapView, MotionEvent motionEvent) {

    }

    //마커
    @Override
    public NMapCalloutOverlay onCreateCalloutOverlay(NMapOverlay nMapOverlay, NMapOverlayItem nMapOverlayItem, Rect rect) {
        return new NMapCalloutBasicOverlay(nMapOverlay, nMapOverlayItem, rect);
    }
}
