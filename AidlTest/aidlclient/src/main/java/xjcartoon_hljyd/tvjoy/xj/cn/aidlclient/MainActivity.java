package xjcartoon_hljyd.tvjoy.xj.cn.aidlclient;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

import xjcartoon_hljyd.tvjoy.xj.cn.aidltest.Book;
import xjcartoon_hljyd.tvjoy.xj.cn.aidltest.IbookAidlInterface;


public class MainActivity extends AppCompatActivity {

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIbookAidlInterface = IbookAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };
    private IbookAidlInterface mIbookAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("xjcartoon_hljyd.tvjoy.xj.cn.aidltest", "xjcartoon_hljyd.tvjoy.xj.cn.aidltest.RemoteBookService"));
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    int count = 0;

    public void click(View view) {
        count++;
        Book   book=new Book("Android从入门到放弃"+count,count);
        try {
            List<Book> books = mIbookAidlInterface.addBooks(book);
            Log.d("tag", "return_from_client: "+books);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }
}
