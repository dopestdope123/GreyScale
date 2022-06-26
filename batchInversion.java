import edu.duke.*;
import java.io.*;
/**
 *Peter Qian 
 *Github: dopestdope123
 *This program converts a batch of images into its inverted form
 */
public class batchInversion {
       public ImageResource makeInverse(ImageResource inImage) {
		//I made a blank image of the same size
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			
			//subtract 255 with the current pixels
			int inverseRed = 255-inPixel.getRed();
			int inverseBlue = 255-inPixel.getBlue();
			int inverseGreen = 255-inPixel.getGreen();
			//set pixel's red to inverted red
			pixel.setRed(inverseRed);
			//set pixel's green to inverted green
			pixel.setGreen(inverseGreen);
			//set pixel's blue to inverted blue
			pixel.setBlue(inverseBlue);
		}
		//outImage is your answer
		return outImage;
	}

	public void selectAndConvert () {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource inImage = new ImageResource(f);
			ImageResource inverse = makeInverse(inImage);
			inverse.draw();
			String fname = inImage.getFileName();
			String newName = "copy_inverse-" + fname;
			inverse.setFileName(newName);
			inverse.save();
		}
	}

	public void testInverse() {
		ImageResource ir = new ImageResource();
		ImageResource inverse = makeInverse(ir);
		inverse.draw();
	}
	
	public void testBatch(){
	    selectAndConvert();
	}
	
}
