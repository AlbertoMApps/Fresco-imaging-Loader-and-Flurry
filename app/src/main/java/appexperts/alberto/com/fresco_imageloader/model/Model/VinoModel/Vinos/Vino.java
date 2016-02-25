
package appexperts.alberto.com.fresco_imageloader.model.Model.VinoModel.Vinos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Vino {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("GlossDiv")
    @Expose
    private String GlossDiv;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("q")
    @Expose
    private String q;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The GlossDiv
     */
    public String getGlossDiv() {
        return GlossDiv;
    }

    /**
     * 
     * @param GlossDiv
     *     The GlossDiv
     */
    public void setGlossDiv(String GlossDiv) {
        this.GlossDiv = GlossDiv;
    }

    /**
     * 
     * @return
     *     The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The image
     */
    public String getImage() {
        return image;
    }

    /**
     * 
     * @param image
     *     The image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 
     * @return
     *     The q
     */
    public String getQ() {
        return q;
    }

    /**
     * 
     * @param q
     *     The q
     */
    public void setQ(String q) {
        this.q = q;
    }

}
