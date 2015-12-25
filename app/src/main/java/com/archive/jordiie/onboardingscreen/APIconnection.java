package com.archive.jordiie.onboardingscreen;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.archive.jordiie.onboardingscreen.Constants ;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jordiie on 14/12/15.
 */
public class APIconnection {

    //Initialize HTTP URLs
    private final String VELLORE_LOGIN_URL="http://vitacademics-rel.herokuapp.com/api/v2/vellore/login";
    private final String CHENNAI_LOGIN_URL="http://vitacademics-rel.herokuapp.com/api/v2/chennai/login";
    private final String VELLORE_REFRESH_URL="http://vitacademics-rel.herokuapp.com/api/v2/vellore/refresh";
    private final String CHENNAI_REFRESH_URL="http://vitacademics-rel.herokuapp.com/api/v2/chennai/refresh";
    private final String SERVERTEST_URL="http://vitacademics-rel.herokuapp.com/api/v2/system";

    public void LoginVellore(){

        /*Setting parameters to POST call*/
        HashMap<String, String> params = new HashMap<>() ;
        /*params.put(REGNO, regno) ;
        params.put(PARENTNO, parentno) ;
        params.put(DOB, dob);
        */

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest(Request.Method.POST, VELLORE_LOGIN_URL, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    String data = response.getString("response");




                }
                catch (JSONException je){

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) ;

    }

    private void checkErrors() {
    }


}
