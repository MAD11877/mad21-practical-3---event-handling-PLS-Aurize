package sg.edu.np.mad.madapplication;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Random;

import static java.lang.Math.floor;

public class ListActivity extends AppCompatActivity {

    private final static String TAG = "List Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.v(TAG, "On Create list activity!");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "On Start list activity!");
    }

    @Override
    protected void onResume() {
        View image = findViewById(R.id.imageView2);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(false);


                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent intent = new Intent(ListActivity.this, MainActivity.class);
                        int random_int = randomOTP();
                        intent.putExtra("ID", random_int);
                        startActivity(intent);
                    }

                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }

        });
        super.onResume();
        Log.v(TAG, "On Resume list activity!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "On Pause list activity!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "On Stop list activity!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy list activity!");
    }

    private int randomOTP(){
        Random ran = new Random();
        int value = ran.nextInt(999999999);
        return value;
    }
}
