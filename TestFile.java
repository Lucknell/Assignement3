import files.BasicFile;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.io.IOException;

class TestFile
{
    String word = null;
	public static void main(String[] arg) throws IOException
	{
		boolean done = false;
		BasicFile f = null, backup = null;

		String menu = "Enter option\n1. Open File\n2.Backup file"
                        + "\n3.Word Count \n4.Quit";
		while(!done)
		{
			String s = JOptionPane.showInputDialog( menu);
			try
			{
				int i = Integer.parseInt(s);
				switch(i)
				{
					case 1:
						f = new BasicFile();
                                                f.backUpFile();
					display(f.getContents());
                                       
                                       JOptionPane.showMessageDialog(null,"Name: "
                                               +f.getName() + " \nSize: "
                                               +f.getFileSize()
                                               +" \nLocation: "+ f.getPath());
                                       //JOptionPane.showInputDialog(word);
                                       f.Search(f.getPath());
                                        
					break;

                                        case 2:
                                            //backup = new BasicFile();
                                            display(f.toString(), "File");
                                            f.backUpFile();
                                        break;
                                        case 3:
                                            
                                            JOptionPane.showMessageDialog(null,
                                                    f.getContents());
                                            
                                        break;
					 
					case 4:
						done = true;
					break;
					default:
						display("This option is"
                                                    + " underfined", "Error");
					break;
				}
           }
           catch(NumberFormatException | NullPointerException e)
		   {
				display(e.toString(), "Error");
		   }
        }
	}

	static void display(String s, String err)
	{
		JOptionPane.showMessageDialog(null, s, err,
                        JOptionPane.ERROR_MESSAGE);
	}
	static void display(String s)
	{
		JOptionPane.showMessageDialog(null, s, "Content",
                        JOptionPane.ERROR_MESSAGE);
	}
	static void display(BasicFile f)
	{
		String s = f.getFileSize() + " bytes" + "\n" + f.getPath();
		String fn = f.getName();
		JOptionPane.showMessageDialog(null, s , "Filename: " 
                        + fn, JOptionPane.INFORMATION_MESSAGE);
	}
}
