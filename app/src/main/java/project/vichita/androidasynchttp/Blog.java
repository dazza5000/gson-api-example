package project.vichita.androidasynchttp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Vichita Fongmala on 2/7/15.
 */
public class Blog {

    private String status;
    private int count;

    @SerializedName("count_total")
    private int countTotal;

    private int pages;
    private List<Post> posts;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountTotal() {
        return countTotal;
    }

    public void setCountTotal(int countTotal) {
        this.countTotal = countTotal;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
