package com.example.slotgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    ImageView _slot1View, _slot2View, _slot3View;
    Button _btStart;
    boolean isPlay=false;

    /////// Modification
    SlotTask _slottask1,_slottask2,_slottask3;
    ExecutorService _execService1,_execService2,_execService3,_execServicePool;
    ///


    private static int[] _imgs = {R.drawable.slot1, R.drawable.slot2, R.drawable.slot3, R.drawable.slot1,
            R.drawable.slot2, R.drawable.slot3};


    // SlotAsyncTask _slotAsyn1,_slotAsyn2,_slotAsyn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _slot1View = findViewById(R.id.id_Slot1);
        _slot2View = findViewById(R.id.id_Slot2);
        _slot3View = findViewById(R.id.id_Slot3);

        _slot1View.setImageResource(R.drawable.ic_launcher_background);
        _slot2View.setImageResource(R.drawable.ic_launcher_background);
        _slot3View.setImageResource(R.drawable.ic_launcher_background);

        _btStart = findViewById(R.id.id_BtPlay);
        _btStart.setOnClickListener(this);


        //// Modification
//        _execService1 = Executors.newSingleThreadExecutor();
//        _execService2 = Executors.newSingleThreadExecutor();
//        _execService3 = Executors.newSingleThreadExecutor();
        ///opsional
        _execServicePool = Executors.newFixedThreadPool(3);
        ////


        _slottask1 = new SlotTask(_slot1View);
        _slottask2 = new SlotTask(_slot2View);
        _slottask3 = new SlotTask(_slot3View);
    }

    @Override
    public void onClick(View v) {


        if(v.getId()==_btStart.getId())
        {
            if(!isPlay){


                /// using asyntask
               /* _slotAsyn1 = new SlotAsyncTask();
                _slotAsyn2 = new SlotAsyncTask();
                _slotAsyn3 = new SlotAsyncTask();


                _slotAsyn1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,_slot1);
                _slotAsyn2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,_slot2);
                _slotAsyn3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,_slot3);
                */

                //// Modification
                _slottask1._play = true;
                _slottask2._play = true;
                _slottask3._play = true;

                //_execService1.execute(_slottask1);
                //_execService2.execute(_slottask2);
                //_execService3.execute(_slottask3);


                _execServicePool.execute(_slottask1);
                _execServicePool.execute(_slottask2);
                _execServicePool.execute(_slottask3);
                ///////

                _btStart.setText("Stop");
                isPlay=!isPlay;
            }
            else {

                ///using asyntask
             /* _slotAsyn1._play = false;
                _slotAsyn2._play = false;
                _slotAsyn3._play = false;
              */

                ///modification
                _slottask1._play = false;
                _slottask2._play = false;
                _slottask3._play = false;
                _btStart.setText("Play");
                isPlay=!isPlay;
                ///



            }

        }

    }

//// asyntask
  /*  private class SlotAsyncTask extends AsyncTask<ImageView, Integer, String> {

        ImageView _slotImg;
        Random _random = new Random();
        public  boolean _play=true;

        public SlotAsyncTask() {
               _play=true;
        }

        @Override
        protected String doInBackground(ImageView... imgs) {
            _slotImg = imgs[0];
            //int a=0;
            while (_play) {
                int i = _random.nextInt(6);

                publishProgress(i);

              try {
                    Thread.sleep(_random.nextInt(500));}
                 catch (InterruptedException e) {
                 e.printStackTrace(); }
                }
           // return !_play;
            return "";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            _slotImg.setImageResource(_imgs[values[0]]);
        }
    }

   */

    ///// modification
    class SlotTask implements Runnable {
        ImageView _slotImg;
        Random _random = new Random();
        public  boolean _play=true;
        int i;

        public SlotTask(ImageView _slotImg) {
            this._slotImg = _slotImg;
            i=0;
            _play=true;

        }

        @Override
        public void run() {

            //int a=0;
            while (_play) {
                i = _random.nextInt(6);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        _slotImg.setImageResource(_imgs[i]);
                    }
                });

                try {
                    Thread.sleep(_random.nextInt(500));}
                catch (InterruptedException e) {
                    e.printStackTrace(); }
            }
            // return !_play;

        }
    }


}