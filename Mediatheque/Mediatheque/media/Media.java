/*
*========================*
* Create  on 03-02-2020 13:02:53 *
* @author : VALLERICH Vincent*
*========================*
*/

package Mediatheque.media;

public class Media{
    private String type;
    private String title;
    private String artist;
    private int duration;

    public Media(){
        
    }

    public Media(String type, String title, String artist, int duration){
        this.type = type;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    
    /**
     * Getters
     */
    public String getType(){
        return this.type;
    }

    public String getTitle(){
        return this.title;
    }

    public String getArtist(){
        return this.artist;
    }

    public int getDuration(){
        return this.duration;
    }

    /**
     * Setters
     */
    public void setType(String type){
        this.type = type;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setArtist(String artist){
        this.artist = artist;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    /**
     * Return of the whole description of media
     */
    public String toString(){
        String toStr="C'est un " + type + " qui a pour titre " + title + " de " + artist + " de " + duration;
        if (type.equals("Livre")){
            toStr+=" pages";
        }
        else{
            toStr+=" minutes";
        }
        
        return toStr;
    }
}