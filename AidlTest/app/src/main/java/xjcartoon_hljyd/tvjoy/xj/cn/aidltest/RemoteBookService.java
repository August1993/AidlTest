package xjcartoon_hljyd.tvjoy.xj.cn.aidltest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 2018/5/10.
 */

public class RemoteBookService extends Service {
    List<Book>  mBookList=new ArrayList<>();
    IBinder mIBinder= new IbookAidlInterface.Stub() {
        @Override
        public List<Book> addBooks(Book b) throws RemoteException {
            b.setPrice(b.getPrice()*10);
            mBookList.add(b);
            return mBookList;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        mBookList.add(new Book("第一行代码",1));
        return mIBinder;
    }
}
