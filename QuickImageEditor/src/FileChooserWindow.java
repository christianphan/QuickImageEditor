
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



@SuppressWarnings("serial")
public class FileChooserWindow extends JFileChooser{
	

	

	private String imagename;
	
	public String getImagename() {
		return imagename;
	}

	public void setImagename(String imagename) {
		this.imagename = imagename;
	}

	public FileChooserWindow()
	{
		
		//filters out only images
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
		this.setFileFilter(filter);
		
		
		//opens dialog menu
		int returnVal = this.showOpenDialog(this);
		
		//when user presses open it sets the stringe imagename to the file path
		if(returnVal == JFileChooser.APPROVE_OPTION)
		{
			imagename = this.getSelectedFile().getAbsolutePath().toString();
		}
		
		System.out.print(imagename);
	}
	
	
	
}
