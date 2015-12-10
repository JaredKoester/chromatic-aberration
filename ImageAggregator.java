package test;

import java.util.Random;

import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
	
public class ImageAggregator {

	public static void main(String[] args){
		new ImageAggregator(args);
	}

	public ImageAggregator(String[] args){
		build(args);
	}
	
	public void build(String[] args) {
		BufferedImage[] imageArr = new BufferedImage[args.length];
		for (int i = 0; i < args.length; i++){
			BufferedImage image = null;
			try {
				image = ImageIO.read(new File((String)args[i]));
			} catch (IOException e) {
				System.out.println(e);
			}
			
			imageArr[i] = image;
		}

		int w = imageArr[0].getWidth();
		int h = imageArr[0].getHeight();

		BufferedImage combined = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);

		// width and height start from the top left
		for (int ww = 0; ww<w; ww++){
			for (int hh = 0; hh<h; hh++){
				int r = 0;
				int g = 0;
				int b = 0;
				for (int i = 0; i <imageArr.length; i++){
					Color pixel = new Color(imageArr[i].getRGB(ww,hh));
					r += pixel.getRed();
					g += pixel.getGreen();
					b += pixel.getBlue();
				}
				r = r/imageArr.length;
				g = g/imageArr.length;
				b = b/imageArr.length;
				
				Color finalPixel = new Color(r,g,b);
				
				combined.setRGB(ww,hh, finalPixel.getRGB());
			}
		}
		try {
		    File outputfile = new File("saved.png");
		    ImageIO.write(combined, "png", outputfile);
		} catch (IOException e) {
		}
	}


}
