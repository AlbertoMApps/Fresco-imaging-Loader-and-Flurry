
package appexperts.alberto.com.fresco_imageloader.model.Model.VinoModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vino {

    @SerializedName("glossary")
    @Expose
    private Glossary glossary;

    /**
     * 
     * @return
     *     The glossary
     */
    public Glossary getGlossary() {
        return glossary;
    }

    /**
     * 
     * @param glossary
     *     The glossary
     */
    public void setGlossary(Glossary glossary) {
        this.glossary = glossary;
    }

}
