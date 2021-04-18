package com.cathal.iterableproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.iterable.iterableapi.IterableApi;
import com.iterable.iterableapi.IterableInAppManager;
import com.iterable.iterableapi.IterableInAppMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IterableApi.getInstance().setEmail("cathal.cooney@gmail.com");
        Button profile_button = (Button) findViewById(R.id.profile_button);
        profile_button.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                JSONObject datafields = new JSONObject();

                try {
                    datafields.put("firstName", "Cathal");
                    datafields.put("isRegisteredUser", true);
                    datafields.put("SA_User_Test_Key", "completed");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                IterableApi.getInstance().updateUser(datafields);
            }
        });

        Button event_button = (Button) findViewById(R.id.event_button);
        event_button.setOnClickListener(new View.OnClickListener () {
            public void onClick(View v) {
                JSONObject datafields = new JSONObject();
                try {
                    datafields.put("platform","Android");
                    datafields.put("isTestEvent",true);
                    datafields.put("url", "https://iterable.com/sa-test/Cathal");
                    datafields.put("secret_code_key","Code_123");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                IterableApi.getInstance().track("mobileSATestEvent", datafields);
            }
        });

        Button message_button = (Button) findViewById(R.id.message_button);
        message_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                IterableInAppManager inAppManager = IterableApi.getInstance().getInAppManager();
                List<IterableInAppMessage> messages = inAppManager.getMessages();
                if(messages.size()>0) {
                    IterableInAppMessage message = messages.get(0);

                    inAppManager.showMessage(message, false,null);
                }
            }
        });

    }
}