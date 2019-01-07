package com.example.felix_its.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    Spinner spCourse,spBranch;
    Button btnSave;
    EditText edtName,edtAddress,edtPhone,edtYears;

    String branch[]={"COM","Sience","Arts"};
    String course[]={"BCA","B.Com","BE"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        spBranch=findViewById(R.id.spnBranch);
        spCourse=findViewById(R.id.spnCourse);
        btnSave=findViewById( R.id.btnSave );
        edtName=findViewById( R.id.edtName );
        edtAddress=findViewById( R.id.edtAddress);
        edtPhone=findViewById( R.id.edtPhone);
        edtYears=findViewById( R.id.edtYears);

        ArrayAdapter<String> courseAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line ,  course);
        spCourse.setAdapter(courseAdapter);
        ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line ,  branch);
        spBranch.setAdapter(branchAdapter);

        btnSave.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                String name =edtName.getText().toString().trim();
                String address =edtAddress.getText().toString().trim();
                String phone =edtPhone.getText().toString().trim();
                String course =spCourse.getSelectedItem().toString();
                String branch =spBranch.getSelectedItem().toString();
                String years =edtYears.getText().toString().trim();


                Employee employee=new Employee( name,address,phone,course,branch,years );
                DBholder dBholder=new DBholder( getApplicationContext() );
                boolean isAddes= dBholder.addEmployee( employee );
                if(isAddes){
                    Toast.makeText( getApplicationContext(),"Recod Added",Toast.LENGTH_SHORT ).show();

                }



            }
        } );


    }
    }

