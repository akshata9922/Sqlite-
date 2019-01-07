package com.example.felix_its.sqlite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;



public class EmployeeViewHolder extends RecyclerView.ViewHolder{
    TextView txtName,txtPhone,txtAddress,txtCourse,txtBranch,txtYear;
    ImageButton btnDelete;
    public EmployeeViewHolder(@NonNull View itemView) {
        super( itemView );
        txtName=itemView.findViewById(R.id.txtName );
        txtAddress=itemView.findViewById( R.id.txtAddress );
        txtPhone=itemView.findViewById(R.id.txtPhone );
        txtCourse=itemView.findViewById(R.id.txtCourse );
        txtBranch=itemView.findViewById(R.id.txtBranch );
        txtYear=itemView.findViewById(R.id.txtYear );
        btnDelete=itemView.findViewById( R.id.btnDelete );

    }
}