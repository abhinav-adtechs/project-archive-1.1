package com.archive.jordiie.onboardingscreen;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jordiie on 14/12/15.
 */
public class APIconnection {

    public static final int SERVERTEST_CODE=0;
    public static final int LOGIN_CODE=1;
    public static final int REFRESH_CODE=2;
    public static final int GENERIC_CODE=-1;
    public static final int GET = 1 ;
    //Initialize HTTP URLs
    private final String VELLORE_LOGIN_URL="http://vitacademics-rel.herokuapp.com/api/v2/vellore/login";
    private final String CHENNAI_LOGIN_URL="http://vitacademics-rel.herokuapp.com/api/v2/chennai/login";
    private final String VELLORE_REFRESH_URL="http://vitacademics-rel.herokuapp.com/api/v2/vellore/refresh";
    private final String CHENNAI_REFRESH_URL="http://vitacademics-rel.herokuapp.com/api/v2/chennai/refresh";
    private final String SERVERTEST_URL="http://vitacademics-rel.herokuapp.com/api/v2/system";


    private DataHandler dataHandler;
    private Context mContext;
    private AppController appController;
    private RequestListener mListener;


    public APIconnection(Context mContext) {
        this.mContext = mContext;
        //dataHandler=DataHandler.getInstance(mContext);
        //appController=AppController.getInstance();
    }

    public String makeServiceCall(String url, int method, List<NameValuePair> params){
        try{
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            HttpPost httpPost = new HttpPost(url);
            // adding post params
            if (params != null) {
                httpPost.setEntity(new UrlEncodedFormEntity(params));
            }

            httpResponse = httpClient.execute(httpPost);

        }
        catch (){

        }
        catch(){

        }
    }

    public void serverTest(){
        if(mListener!=null) {
            mListener.onRequestInitiated(SERVERTEST_CODE);

        }
        else{
            return;
        }
    }

    public void login(){
        if(mListener!=null) {


            mListener.onRequestInitiated(LOGIN_CODE);

        }
        else{
            return;
        }
    }

    public void refresh(){
        if(mListener!=null) {
            mListener.onRequestInitiated(REFRESH_CODE);
        }
        else{
            return;
        }
    }

    public void setOnRequestListener(RequestListener listener){
        this.mListener=listener;
    }

    public void changeOnRequestListener(RequestListener listener){
        this.mListener=listener;
    }

    public interface RequestListener{

        public void onRequestInitiated(int code);

        //public void onRequestCompleted(ReturnParcel parcel, int code);

        //public void onErrorRequest(ReturnParcel parcel, int code);

    }


}
