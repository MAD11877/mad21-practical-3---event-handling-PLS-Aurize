package sg.edu.np.mad.madapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create!");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "On Start!");
    }

    protected void onResume() {

        User user = new User("Reiner", "Student", 001, false );
        Button button = findViewById(R.id.button3);
        Intent receivedData = getIntent();
        int id = receivedData.getIntExtra("ID", 0);
        TextView hello =findViewById(R.id.hello);
        hello.setText("Hello " + id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.isFollowed() == false){
                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();
                    button.setText("Unfollow");
                    user.setFollowed(true);
                    Log.v(TAG, "Followed toast dialog");

                }
                else{
                    Toast.makeText(MainActivity.this, "Updated", Toast.LENGTH_LONG).show();
                    button.setText("Follow");
                    user.setFollowed(false);
                    Log.v(TAG, "Unfollowed toast dialog");
                }
            }
        });
        super.onResume();
        Log.v(TAG, "On Resume!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "On Pause!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "On Stop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "On Destroy!");
    }
}