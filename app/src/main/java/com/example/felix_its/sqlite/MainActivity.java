package com.example.felix_its.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rvUsers=findViewById( R.id.rvUsers );
        rvUsers.setLayoutManager( new LinearLayoutManager( getApplicationContext() ) );
        DBholder dbholder=new DBholder( getApplicationContext() );
        List<Employee> employees=dbholder.getAllEmployee();


        EmployeeListAdapter adapter=new EmployeeListAdapter(employees ,dbholder );
        rvUsers.setAdapter( adapter );

    }

    public void adddata(View view) {

        Intent intent=new Intent(MainActivity.this,AddActivity.class);
        startActivity(intent);
    }
}
