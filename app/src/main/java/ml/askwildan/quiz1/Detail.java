package ml.askwildan.quiz1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;



public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String stringTitle = extras.getString("title");
        TextView title = (TextView) findViewById(R.id.title) ;
        title.setTextSize(40);
        title.setText(stringTitle);
        String stringDetail = extras.getString("detail");
        TextView detail = (TextView) findViewById(R.id.detail) ;
        detail.setTextSize(20);
        detail.setText(stringDetail);
    }
}
