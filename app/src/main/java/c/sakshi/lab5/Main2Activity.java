package c.sakshi.lab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        welcome = findViewById(R.id.welcomeNote);
        Intent intent = getIntent();
        String str = intent.getStringExtra("message");
        //Log.i("Info", str);
        welcome.setText("Welcome " + str + "!");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.logout:
                Intent activity1 = new Intent(this, MainActivity.class);
                SharedPreferences LoginInfo = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
                LoginInfo.edit().remove(MainActivity.usernameKey).apply();
                startActivity(activity1);
                return true;

            case R.id.addnote:
                // TODO
                return true;



             default: return super.onOptionsItemSelected(item);

        }
    }


}
