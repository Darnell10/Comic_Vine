package c4q.com.comic_vine;

/**
 * Created by D on 2/3/18.
 */

public class Favorites {

    private String img;
    private String name;
    private String res;
    private String pub;



    public Favorites(String img, String name, String res, String pub) {
        this.img = img;
        this.name = name;
        this.res = res;
        this.pub = pub;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }


}
