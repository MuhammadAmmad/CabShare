package com.example.connor.cabshare;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.example.connor.cabshare.MyActivity;
import com.firebase.client.ValueEventListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class OfferMenuPage extends ActionBarActivity {
    private AuthData authData;
    private String offerer;
    private Boolean isCreater;
    private Button viewRequestsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_menu_page);
        authData = com.example.connor.cabshare.MyActivity.getInstance();
        viewRequestsButton = (Button)findViewById(R.id.viewRequestsButton);
        isCreater = false;
        offerer = viewOffersPage.getInstance();
        System.out.println(offerer);
        if(offerer == null){
            isCreater = true;
            offerer = authData.getUid();
        }

        if(isCreater != true){
            viewRequestsButton.setVisibility(View.GONE);
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.offer_menu_page, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void viewRequests(View v){
        Intent i = new Intent(OfferMenuPage.this, viewRequestsPage.class);
        startActivity(i);
    }

    public void viewChat(View v){
        Intent i = new Intent(OfferMenuPage.this, ViewOfferChat.class);
        startActivity(i);
    }

    public void onBackPressed(){
        super.onBackPressed();
        this.finish();
    }
}
