package com.deitel.littlethinkers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.deitel.littlethinkers.Adapter.ImageAdapter;

public class ShapesActivity extends AppCompatActivity {
    
    ImageView curView=null;
    private int countPair=0;
    //private GridView gridView;
    final int[] drawable = new int[]{R.drawable.img1, R.drawable.img2, R.drawable.img3,
            R.drawable.img4,R.drawable.img6,R.drawable.img5};

    int[] pos ={0,1,2,3,4,5,0,1,2,3,4,5};
    int currentPos=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        ImageAdapter imageAdapter = new ImageAdapter(this);
        gridView.setAdapter(imageAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(currentPos<0){
                    currentPos=position;
                    curView=(ImageView)view;
                    ((ImageView)view).setImageResource(drawable[pos[position]]);
                }
                else {
                    if(currentPos ==position){
                        ((ImageView)view).setImageResource(R.drawable.questionm);
                    }else if(pos[currentPos] != pos[position]){
                        curView.setImageResource(R.drawable.questionm);
                        //    Toast.makeText(getApplicationContext(),"incorrect",Toast.LENGTH_SHORT).show();
                        Toast.makeText(ShapesActivity.this,"Incorrect",Toast.LENGTH_SHORT).show();
                    }else {
                        ((ImageView)view).setImageResource(drawable[pos[position]]);
                        countPair++;

                        if(countPair==0){
                            //  Toast.makeText(getApplicationContext(),"you win",Toast.LENGTH_SHORT.show);
                            Toast.makeText(ShapesActivity.this,"you win",Toast.LENGTH_SHORT).show();
                        }
                    }
                    currentPos = -1;

                }
                // for(int k = -1; k<2; k++){
                //    ((ImageView)view).setImageResource(drawable[pos[k]]);
                // }
            }
        });

    }
}