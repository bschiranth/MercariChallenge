package com.mercari.mercaritest.utils;

import android.content.Context;

import com.mercari.mercaritest.data.model.Item;
import com.mercari.mercaritest.ui.SaleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bschiranth1692 on 9/25/17.
 */

public class JsonUtils {

    public static void parseJson(Context context, SaleAdapter saleAdapter){
        List<Item> allItems = new ArrayList<Item>();
        String json = loadJSONFromAsset(context);
        try {
            JSONObject jsonObject = new JSONObject(json);
            if(jsonObject.getString("result").equals("ok")){
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                if(jsonArray != null) {
                    allItems = getListFromJsonArray(jsonArray);
                    saleAdapter.updateAdapter(allItems);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static List<Item> getListFromJsonArray(JSONArray jsonArray){
        List<Item> allItems = new ArrayList<Item>();
        for(int i = 0 ; i < jsonArray.length();i++){
            try {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String status = jsonObject.getString("status");
                long num_likes = jsonObject.getLong("num_likes");
                long num_comments = jsonObject.getLong("num_comments");
                long price = jsonObject.getLong("price");
                String photo = jsonObject.getString("photo");

                Item item = new Item(id,name,num_likes,num_comments,price,photo,status);
                allItems.add(item);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return allItems;
    }

    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("all.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



}
