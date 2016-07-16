package ycri.p4.pendaftaranmember;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Daftar_Member_baru extends AppCompatActivity {


    ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();
    Button btn4, btn5;
    EditText edit1, edit2, edit3, edit4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar__member_baru);



    }
}
