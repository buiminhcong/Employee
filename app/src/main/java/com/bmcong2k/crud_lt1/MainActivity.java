package com.bmcong2k.crud_lt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText edtMa;
    private EditText edtTen;
    private RadioGroup rb;
    private RadioButton rbNam;
    private RadioButton rbNu;
    private Button btnAdd, btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(R.drawable.nam, "112", "Cong", "nam"));
        employeeList.add(new Employee(R.drawable.nam, "113", "Nam", "nam"));
        employeeList.add(new Employee(R.drawable.nu, "114", "Anh", "nu"));
        employeeList.add(new Employee(R.drawable.nu, "115", "Luyen", "nu"));

        initView();

        EmployeeAdapter adapter = new EmployeeAdapter(this, employeeList );
        rbNam.setChecked(true);
        //Add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String maNV = edtMa.getText().toString();
                    String tenNV = edtTen.getText().toString();
                    int radioID = rb.getCheckedRadioButtonId();
                    int anh = 0;
                    if(maNV.trim().equals("") || tenNV.trim().equals("")){
                        Toast.makeText(MainActivity.this, "Vui Long nhap du tt", Toast.LENGTH_SHORT).show();
                    }else {
                        String gt = "";
                        if(radioID == rbNam.getId())
                            gt = "nam";
                        else
                            gt="nu";
                        if(gt=="nam")
                            anh = R.drawable.nam;
                        else
                            anh = R.drawable.nu;
                        Employee e = new Employee(anh, maNV, tenNV,gt);
                        adapter.addEmployee(e);
                    }
            }
        });



        adapter.setOnMyItemClickListener(new EmployeeAdapter.OnMyItemClickListener() {
            @Override
            public void doSomething(int position) {
                //Hien thi dc chon len form
                btnAdd.setEnabled(false);
                btnUpdate.setEnabled(true);

                Employee e1 = employeeList.get(position);
                edtMa.setText(e1.getMaNV());
                edtTen.setText(e1.getTen());
                String gt = e1.getGt();
                if(gt=="nam")
                    rbNam.setChecked(true);
                else
                    rbNu.setChecked(true);
                ////
                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String maNV = edtMa.getText().toString();
                        String tenNV = edtTen.getText().toString();
                        int radioID = rb.getCheckedRadioButtonId();
                        String gioiTinh = "";
                        int anh = 0;
                        if(maNV.trim().equals("") || tenNV.trim().equals("")){
                            Toast.makeText(MainActivity.this, "Vui Long nhap du tt", Toast.LENGTH_SHORT).show();
                        }else {
                            if(radioID == rbNam.getId())
                                gioiTinh = "nam";
                            else
                                gioiTinh="nu";
                            if(gioiTinh=="nam")
                                anh = R.drawable.nam;
                            else
                                anh = R.drawable.nu;

                            Employee e = new Employee(anh, maNV, tenNV,gioiTinh);
                            adapter.updateEmployee(position,e);
                            btnUpdate.setEnabled(false);
                            btnAdd.setEnabled(true);
                        }
                    }
                });
            }
        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));

    }


    private void initView() {
        recyclerView = findViewById(R.id.recycleview);
        edtMa = findViewById(R.id.edt_manv);
        edtTen = findViewById(R.id.edt_tennv);
        rb = findViewById(R.id.radio_group);
        rbNam = findViewById(R.id.radio_nam);
        rbNu = findViewById(R.id.radio_nu);
        btnAdd = findViewById(R.id.btn_add);
        btnUpdate = findViewById(R.id.btn_update);
    }
}