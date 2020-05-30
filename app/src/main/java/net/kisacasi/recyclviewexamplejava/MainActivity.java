package net.kisacasi.recyclviewexamplejava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<RvItem> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }
    private void initData() {
        arrayList = new ArrayList<>();
        arrayList.add(new RvItem(R.drawable.ic_smile,"Item title 0", "Item subtitle 0"));
        arrayList.add(new RvItem(R.drawable.ic_smile,"Item title 1", "Item subtitle 1"));
        arrayList.add(new RvItem(R.drawable.ic_smile,"Item title 2", "Item subtitle 2"));
        arrayList.add(new RvItem(R.drawable.ic_smile,"Item title 3", "Item subtitle 3"));
        arrayList.add(new RvItem(R.drawable.ic_smile,"Item title 4", "Item subtitle 4"));

        setAdapter();
    }

    private void setAdapter(){
        RecyclerView recyclerView = findViewById(R.id.rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RvAdapter rvAdapter = new RvAdapter(arrayList);
        recyclerView.setAdapter(rvAdapter);
        rvAdapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),arrayList.get(position).getTitle(),Toast.LENGTH_LONG).show();;
            }
        });
    }

}
