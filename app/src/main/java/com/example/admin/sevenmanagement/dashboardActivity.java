package com.example.admin.sevenmanagement;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class dashboardActivity extends AppCompatActivity implements View.OnClickListener  {
    private FirebaseAuth firebaseAuth;
    TextView firebasenameview;
    Button toast;

    private LinearLayout addItems;
    private LinearLayout deleteItems;
    private LinearLayout scanItems;
    private LinearLayout viewInventory;
    private LinearLayout attend;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_dashboard);
        firebasenameview= (TextView) findViewById(R.id.firebasename);

        // this is for username to appear after login

        firebaseAuth = FirebaseAuth.getInstance();

        final FirebaseUser users = firebaseAuth.getCurrentUser();
        String finaluser=users.getEmail();
        String result = finaluser.substring(0, finaluser.indexOf("@"));
        String resultemail = result.replace(".","");
        firebasenameview.setText(resultemail);
//        toast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(dashboardActivity.this, users.getEmail(), Toast.LENGTH_SHORT).show();
//            }
//        });


        addItems = (LinearLayout) findViewById(R.id.addItems);
        deleteItems = (LinearLayout) findViewById(R.id.deleteItems);
        scanItems = (LinearLayout) findViewById(R.id.scanItems);
        viewInventory = (LinearLayout) findViewById(R.id.viewInventory);
        attend = (LinearLayout) findViewById(R.id.attendance);


        addItems.setOnClickListener(this);
        deleteItems.setOnClickListener(this);
        scanItems.setOnClickListener(this);
        viewInventory.setOnClickListener(this);
        attend.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.addItems : i = new Intent(this,additemActivity.class); startActivity(i); break;
            case R.id.deleteItems : i = new Intent(this,deleteItemsActivity.class);startActivity(i); break;
            case R.id.scanItems : i = new Intent(this,scanItemsActivity.class);startActivity(i); break;
            case R.id.viewInventory : i = new Intent(this,viewInventoryActivity.class);startActivity(i); break;
            case R.id.attendance : i = new Intent(this,attendanceActivity.class);startActivity(i); break;
            //case R.id.clockout : i = new Intent(this,clockoutActivity.class);startActivity(i); break;
            default: break;
        }
    }





    // logout below
    private void Logout()
    {
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(dashboardActivity.this,LoginActivity.class));
        Toast.makeText(dashboardActivity.this,"LOGOUT SUCCESSFUL", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.logoutMenu:{
                Logout();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
