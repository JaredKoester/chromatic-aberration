BufferedImage[] imageArr = new BufferedImage[args.count()]();
for (int i = 0; i < args.count(); i++){
	BufferedImage image = null;
	image = ImageIO.read(new File((string)args[0]));
	imageArr[0] = image;
}

int w = imageArr[0].getWidth();
int h = imageArr[0].getHeight();

BufferedImage combined = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);

// width and height start from the top left
for (int ww = 0; ww<=w; ww++){
	for (int hh = 0; hh<=h; hh++){
		int r = 0;
		int g = 0;
		int b = 0;
		for (int i = 0; i <imageArr.count(); i++){
			Color pixel = new Color(imageArr[0].getRGB(ww,hh));
			r += pixel.getRed();
			g += pixel.getGreen();
			b += pixel.getBlue();
		}
		r = r/imageArr.count();
		g = g/imageArr.count();
		b = b/imageArr.count();
		
		Color finalPixel = new Color(r,g,b);
		
		combined.setRGB(ww,hh, finalPixel.getRGB());
	}
}
try {
    File outputfile = new File("saved.png");
    ImageIO.write(combined, "png", outputfile);
} catch (IOException e) {
}
