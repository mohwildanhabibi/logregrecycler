package ml.askwildan.quiz1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    ArrayAdapter adapter;
    ListView listview;
    Intent intent;
    
    ArrayList<String> itemTitle;
    ArrayList<String> itemDetail;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemTitle = new ArrayList<>();
        itemTitle.add("Asus");
        itemTitle.add("Acer");
        itemTitle.add("Apple");
        itemDetail = new ArrayList<>();
        itemDetail.add("Asus adalah merk komputer terkenal");
        itemDetail.add("Acer adalah merk komputer tidak terkenal");
        itemDetail.add("Apple adalah merk hape terkenal");
        adapter = new ArrayAdapter(this, R.layout.activity_listview, itemTitle);
        listview = (ListView) findViewById(R.id.array_list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        intent = new Intent(Main.this, Detail.class);
                        Bundle extras = new Bundle();
                        extras.putString("title", itemTitle.get(i));
                        extras.putString("detail", itemDetail.get(i));
                        intent.putExtras(extras);
                        startActivity(intent);
                    }
                });
        listview.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        itemTitle.remove(i);
                        itemDetail.remove(i);
                        listview.invalidateViews();
                        return true;
                    }
                }
        );
    }
}
