/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage
 *
 *  @author: Joel Cabrera, jc2135, jc2135@scarletmail.rutgers.edu
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) { // td = tile dimension, column dimension = cd

	// WRITE YOUR CODE HERE
        this.tileDimension = 100; 
        this.collageDimension = 4;
        this.original = new Picture(filename);
        this.collage = new Picture(tileDimension*collageDimension, tileDimension*collageDimension);
        Color c = new Color(0, 0, 0);
        for (int tcol = 0; tcol < tileDimension*collageDimension; tcol++) {
            for (int trow = 0; trow < tileDimension*collageDimension; trow++) { 
                int scol = tcol * this.original.width() / (tileDimension*collageDimension); 
                int srow = trow * this.original.height() / (tileDimension*collageDimension); 
                Color color = this.original.get(scol, srow);
                this.collage.set(tcol, trow, c); 
                this.collage.set(tcol, trow, color);
            }
        }
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) { // td = tile dimension, column dimension = cd

	// WRITE YOUR CODE HERE
        this.tileDimension = td;
        this.collageDimension = cd;
        this.original = new Picture(filename);
        this.collage = new Picture(tileDimension*collageDimension, tileDimension*collageDimension);
        Color c = new Color(0, 0, 0);
        for (int tcol = 0; tcol < tileDimension*collageDimension; tcol++) {
            for (int trow = 0; trow < tileDimension*collageDimension; trow++) { 
                int scol = tcol * this.original.width() / (tileDimension*collageDimension); 
                int srow = trow * this.original.height() / (tileDimension*collageDimension); 
                Color color = this.original.get(scol, srow); 
                this.collage.set(tcol, trow, c);
                this.collage.set(tcol, trow, color);
            }
        }
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {

	// WRITE YOUR CODE HERE
        return this.collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {

	// WRITE YOUR CODE HERE
        return this.tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {

	// WRITE YOUR CODE HERE
        return this.original;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {

	// WRITE YOUR CODE HERE
        return this.collage;
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {

	// WRITE YOUR CODE HERE
        this.original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {

	// WRITE YOUR CODE HERE
        this.collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {

	// WRITE YOUR CODE HERE
        Picture p = new Picture(tileDimension, tileDimension);
        Picture psource = new Picture(filename);
        for (int tcol = 0; tcol < tileDimension; tcol++) {
            for (int trow = 0; trow < tileDimension; trow++) {
                int scol = tcol * psource.width() / tileDimension; 
                int srow = trow * psource.height() / tileDimension; 
                //Color color = p.get(tcol, trow);
                Color color = psource.get(scol, srow); 
                p.set(tcol, trow, color);
                this.collage.set(collageCol*tileDimension+tcol, collageRow*tileDimension+trow, color);
            }
        }
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {

	// WRITE YOUR CODE HERE
        Picture p = new Picture(tileDimension, tileDimension);
        for (int tcol = 0; tcol < tileDimension; tcol++) {
            for (int trow = 0; trow < tileDimension; trow++) {
                int scol = tcol * this.original.width() / tileDimension; 
                int srow = trow * this.original.height() / tileDimension;
                Color color = this.original.get(scol, srow);
                p.set(tcol, trow, color);
            }
        }
        for (int tcol = 0; tcol < tileDimension; tcol++) {
            for (int trow = 0; trow < tileDimension; trow++) {
                Color color = p.get(tcol, trow);
                for (int collageCol = 0; collageCol < collageDimension; collageCol++) {
                    for (int collageRow = 0; collageRow < collageDimension; collageRow++) {
                        this.collage.set(collageCol*tileDimension+tcol, collageRow*tileDimension+trow, color);
                    }
                }
            }
        }        
    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

	// WRITE YOUR CODE HERE
        for (int tcol = 0; tcol < tileDimension; tcol++) {
            for (int trow = 0; trow < tileDimension; trow++) {
                if (component.equals("red")) {
                    Color k = this.collage.get(tileDimension*collageCol+tcol, tileDimension*collageRow+trow);
                    float j = (float) k.getRed();
                    float z = j / ((float) 255.0);
                    Color newcolor = new Color(z, 0, 0);
                    this.collage.set(tileDimension*collageCol+tcol, tileDimension*collageRow+trow, newcolor);
                }
                else if (component.equals("green")) {
                    Color k = this.collage.get(tileDimension*collageCol+tcol, tileDimension*collageRow+trow);
                    float j = (float) k.getGreen();
                    float z = j / ((float) 255.0);
                    Color newcolor = new Color(0, z, 0);
                    this.collage.set(tileDimension*collageCol+tcol, tileDimension*collageRow+trow, newcolor);
                }
                else if (component.equals("blue")) {
                    Color k = this.collage.get(tileDimension*collageCol+tcol, tileDimension*collageRow+trow);
                    float j = (float) k.getBlue();
                    float z = j / ((float) 255.0);
                    Color newcolor = new Color(0, 0, z);
                    this.collage.set(tileDimension*collageCol+tcol, tileDimension*collageRow+trow, newcolor);
                }
            }
        }
    }

    /*
     * Greyscale tile at (collageCol, collageRow)
     * (see Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void greyscaleTile (int collageCol, int collageRow) {

	// WRITE YOUR CODE HERE
        for (int tcol = 0; tcol < tileDimension; tcol++) {
            for (int trow = 0; trow < tileDimension; trow++) { 
                Color color = this.collage.get(collageCol*tileDimension+tcol, collageRow*tileDimension+trow); 
                Color gray  = Luminance.toGray(color); 
                this.collage.set(collageCol*tileDimension+tcol, collageRow*tileDimension+trow, gray);
            } 
        }  
    }          

    // Test client 
    public static void main (String[] args) {}
}
