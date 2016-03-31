package st.baoleme.com.baoleme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.Selection;
import android.text.Spannable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.lidroid.xutils.HttpUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText name;
    private EditText password;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();





    }



    private void initView() {
        name = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        toggleButton = (ToggleButton) findViewById(R.id.mTogBtn);
        TextView tv_submit = (TextView) findViewById(R.id.login);

        tv_submit.setOnClickListener(this);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD | InputType.TYPE_CLASS_TEXT);
                } else {
                    password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }

                CharSequence text = password.getText();
                //Debug.asserts(text instanceof Spannable);
                if (text instanceof Spannable) {
                    Spannable spanText = (Spannable) text;
                    Selection.setSelection(spanText, text.length());
                }

            }
        });

        toggleButton.setChecked(true);

    }


    @Override
    public void onClick(View v) {
        int clkId = v.getId();
        switch (clkId){
            case R.id.login:
                login();
                break;
            case R.id.img_back:

                break;
        }
    }


    private void login() {

    }
}
