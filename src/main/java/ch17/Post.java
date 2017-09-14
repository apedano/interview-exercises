package ch17;

import java.util.Date;

/**
 * Created by Alex on 24/08/2017.
 */
public class Post {
    private Long ID;
    private String text;
    private Date creationDateTime;
    private User creator;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (ID != null ? !ID.equals(post.ID) : post.ID != null) return false;
        if (creationDateTime != null ? !creationDateTime.equals(post.creationDateTime) : post.creationDateTime != null)
            return false;
        if (creator != null ? !creator.equals(post.creator) : post.creator != null) return false;
        if (text != null ? !text.equals(post.text) : post.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID != null ? ID.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (creationDateTime != null ? creationDateTime.hashCode() : 0);
        return result;
    }
}
