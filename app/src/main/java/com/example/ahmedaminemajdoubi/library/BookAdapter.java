package com.example.ahmedaminemajdoubi.library;

/**
 * Created by AhmedAmineMajdoubi on 17/07/2017.
 */

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.MyViewHolder>{

    private List<Book> bookList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, authors;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            authors = (TextView) view.findViewById(R.id.authors);
        }
    }

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Book myBook = bookList.get(position);
        String fullTitle = myBook.getTitle();
        if(!TextUtils.isEmpty(myBook.getAdditionalTitle()))
            fullTitle += " - " + myBook.getAdditionalTitle();
        holder.title.setText(fullTitle);
        String allAuthors = new String();
        if(myBook.getAuthors().length!=0){
            allAuthors = myBook.getAuthors()[0];
        }
        for(int i=1;i<myBook.getAuthors().length;i++){
            allAuthors += ", "+ myBook.getAuthors()[i];
        }
        holder.authors.setText(allAuthors);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

}
