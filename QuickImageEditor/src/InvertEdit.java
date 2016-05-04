import java.awt.Color;
import java.awt.image.BufferedImage;

public class InvertEdit {
	
	public InvertEdit(String pathname, BufferedImage image)
	{
		int width = image.getWidth();
		int height = image.getHeight();
		
		for(int i = 0; i < width; i++)
		{
			for(int j = 0; j < height; j++)
			{
 				int temp = image.getRGB(i, j);
 				
 				image.setRGB(i, j, image.getRGB(i,image.getHeight()-j-1));
 				image.setRGB(i, image.getHeight()-j-1, temp);
 				
			}
		}
		
	}

}
