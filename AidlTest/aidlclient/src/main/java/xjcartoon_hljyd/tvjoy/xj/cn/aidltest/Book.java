package xjcartoon_hljyd.tvjoy.xj.cn.aidltest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hp on 2018/5/10.
 */

public class Book implements Parcelable {
    String bookName;
    int price;

    public Book(String bookName, int price) {
        this.bookName = bookName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static Creator<Book> getCREATOR() {
        return CREATOR;
    }

    protected Book(Parcel in) {
        bookName = in.readString();
        price = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(bookName);
        dest.writeInt(price);
    }
}
