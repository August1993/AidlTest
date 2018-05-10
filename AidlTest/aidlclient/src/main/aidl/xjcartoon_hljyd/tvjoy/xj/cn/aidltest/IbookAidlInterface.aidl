// IbookAidlInterface.aidl
package xjcartoon_hljyd.tvjoy.xj.cn.aidltest;
import xjcartoon_hljyd.tvjoy.xj.cn.aidltest.Book;

// Declare any non-default types here with import statements

interface IbookAidlInterface {
   List<Book> addBooks(in Book b);
}
