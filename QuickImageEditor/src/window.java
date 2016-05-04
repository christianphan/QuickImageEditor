import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;



@SuppressWarnings("serial")
public class window extends JFrame {
	
	private String pathName;

	public window(){
		super("Quick Image Editor");
		setSize(500,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(0,0,0,0);
		
		
		JButton item1 = new JButton("Select Image");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(item1, gbc);
		
		//Action for item1
		item1.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e)
			{
				FileChooserWindow fc = new FileChooserWindow();
				pathName = fc.getImagename();
			}	
		});
		
		
		
		JButton item4 = new JButton("Apply Changes");
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(item4, gbc);
		
		panel.setAlignmentY(JComponent.LEFT_ALIGNMENT);
		
		JCheckBox[] check = new JCheckBox[3];
		check[0] = new JCheckBox("GreyScale");
		check[1] = new JCheckBox("Invert");
		check[2] = new JCheckBox("Pixelate");

		for(int i = 0; i < 3; i++)
		{
			panel.add(check[i]);
		}
		
		
		
		item4.addActionListener(new ActionListener(){	
			public void actionPerformed(ActionEvent e)
			{
				BufferedImage  image;
				try{
			         File input = new File(pathName);
			         image = ImageIO.read(input);
			         
			         if(check[0].isSelected())
			         {
			        	 GreyScaleEdit makeGrey = new GreyScaleEdit(pathName, image);
			         }
			         
			         if(check[1].isSelected())
			         {
			        	 InvertEdit makeInvert = new InvertEdit(pathName, image);
			         }
			         
			         if(check[2].isSelected())
			         {
			        	 PixelEdit makePixelate = new PixelEdit(pathName, image);
			         }
			         
			         File ouptut = new File(pathName);
			         ImageIO.write(image, "jpg", ouptut);
					
				} catch (Exception e1) {}
				

			}	
		});
		
		
		
		add(panel);
		
		
	}
	
	
}