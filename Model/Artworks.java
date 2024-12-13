package Model;

public class Artworks {
    int id;
    String title;
    String description;
    String image_path;
    String userId;
    public Artworks(int id, String title, String description, String image_path, String userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image_path = image_path;
        this.userId = userId;
    }
    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage_path() {
        return image_path;
    }
    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}

