package com.bmcong2k.crud_lt1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

     private Context context;
     private List<Employee> employeeList;
     public interface OnMyItemClickListener{
          void doSomething(int position);
     }
     private OnMyItemClickListener onMyItemClickListener;

     public void setOnMyItemClickListener(OnMyItemClickListener onMyItemClickListener) {
          this.onMyItemClickListener = onMyItemClickListener;
     }

     public EmployeeAdapter(Context context, List<Employee> employeeList) {
          this.context = context;
          this.employeeList = employeeList;
     }

     @NonNull
     @Override
     public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

          View view = LayoutInflater.from(parent.getContext())
                  .inflate(R.layout.item_employee, parent, false);

          return new EmployeeViewHolder(view);
     }

     // for
     @Override
     public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
          Employee e = employeeList.get(position);
          holder.imageView.setImageResource(e.getImg());
          holder.txtManv.setText(e.getMaNV());
          holder.txtName.setText(e.getTen());
          if( e.getGt() == "nam"){
               holder.cb.setChecked(true);
          }else {
               holder.cb.setChecked(false);
          }

          holder.btnDelete.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                  employeeList.remove(position);
                  notifyDataSetChanged();
               }
          });
          holder.cardView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                    onMyItemClickListener.doSomething(position);

               }
          });

     }

     @Override
     public int getItemCount() {
          return employeeList.size();
     }

     class EmployeeViewHolder extends RecyclerView.ViewHolder {

          private CardView cardView;
          private ImageView imageView;
          private TextView txtManv;
          private TextView txtName;
          private CheckBox cb;
          private Button btnDelete;

          public EmployeeViewHolder(@NonNull View itemView) {
               super(itemView);

               cardView = itemView.findViewById(R.id.item_cardview);
               imageView = itemView.findViewById(R.id.item_img);
               txtManv = itemView.findViewById(R.id.item_code);
               txtName = itemView.findViewById(R.id.item_name);
               cb = itemView.findViewById(R.id.item_cb);
               btnDelete = itemView.findViewById(R.id.item_delete);


          }
     }
     public void updateEmployee(int position, Employee e){
          employeeList.set(position, e);
          notifyDataSetChanged();
     }
     public void addEmployee(Employee e){
          employeeList.add(e);
          notifyDataSetChanged();
     }

}
