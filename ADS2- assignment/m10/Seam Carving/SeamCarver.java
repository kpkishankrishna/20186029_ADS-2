import java.awt.Color;
public class SeamCarver {
	Picture picture;
	int width;
	int height;
	double[][] energy;
	// create a seam carver object based on the given picture
	public SeamCarver(Picture picture) {
		this.picture = picture;

	}
	// current picture
	public Picture picture() {
		return picture;
	}
	// width of current picture
	public int width() {
		return width;
	}

	// height of current picture
	public int height() {
		return height;
	}
	public int red(int x, int y) {
		return picture.get(x, y).getRed();
	}public int green(int x, int y) {
		return picture.get(x, y).getGreen();
	}public int blue(int x, int y) {
		return picture.get(x, y).getBlue();
	}

	// energy of pixel at column x and row y
	public double energy(int x, int y) {
		int r1 = red(x-1, y);
		int r2 = red(x+1, y);
		int g = green(x, y);
		int b = blue(x, y);
		// int xxx = r;
		return 0;
	}

	// sequence of indices for horizontal seam
	public int[] findHorizontalSeam() {
		return new int[0];
	}

	// sequence of indices for vertical seam
	public int[] findVerticalSeam() {
		return new int[0];
	}

	// remove horizontal seam from current picture
	public void removeHorizontalSeam(int[] seam) {

	}

	// remove vertical seam from current picture
	public void removeVerticalSeam(int[] seam) {

	}
}