package bca.cpi.mittu.sharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtname,edtphn,edtmail;

    Button btnsubmit;

    public static final String MyPrefrences = "MyPrefs";
    public static final String Name = "Namekey";
    public static final String PhoneNo = "Phnkey";
    public static final String MailId = "Mailkey";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtname = (EditText)findViewById(R.id.edtname);
        edtphn = (EditText)findViewById(R.id.edtphn);
        edtmail = (EditText)findViewById(R.id.edtmail);

        btnsubmit = (Button)findViewById(R.id.btnsubmit);

        sharedPreferences = getSharedPreferences(MyPrefrences, Context.MODE_PRIVATE);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String n = edtname.getText().toString();
                String phn = edtphn.getText().toString();
                String mail = edtmail.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(Name,n);
                editor.putString(PhoneNo,phn);
                editor.putString(MailId,mail);
                editor.commit();

                Toast.makeText(MainActivity.this,"thanks",Toast.LENGTH_LONG).show();

            }
        });

    }
}
