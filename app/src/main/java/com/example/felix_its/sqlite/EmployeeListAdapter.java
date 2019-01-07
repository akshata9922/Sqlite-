package com.example.felix_its.sqlite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

public class EmployeeListAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    List<Employee> employees;
    DBholder dbholder;
    public  EmployeeListAdapter(List<Employee> employees, DBholder dbholder){ //constructor
        this.employees =employees;
        this.dbholder=dbholder;
    }


    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate( R.layout.item_employee_list,viewGroup,false  );
        return new EmployeeViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int i) {

        //accept row and columns
        final Employee employee=employees.get( i );
        employeeViewHolder .txtName.setText( "Name :"+ employee.getName() );
        employeeViewHolder .txtAddress.setText( "Address :"+ employee.getAddress() );
        employeeViewHolder .txtPhone.setText( "Phone :"+ employee.getPhone() );

        employeeViewHolder .txtCourse.setText( "Course :"+ employee.getCourse() );
        employeeViewHolder .txtBranch.setText( "Branch :"+ employee.getBranch() );

        employeeViewHolder .txtYear.setText( "Year :"+ employee.getYears() );

        employeeViewHolder.btnDelete.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                boolean isDelete = dbholder.deleateEmployee( employee.getId() );
                if (isDelete){
                    employees.remove( employee );
                    notifyDataSetChanged();
                }
            }
        } );
    }

    @Override
    public int getItemCount() {
        return employees.size();
    }
}
