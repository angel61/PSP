package daos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileBase {

	private static final String filepath=".";
	
	public Object writeObjectToFile(Object serObj, String filename) {
		 
        try {

            FileOutputStream fileOut = new FileOutputStream(filepath + File.separator + filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
  
        } catch (Exception ex) {
            //ex.printStackTrace();
            return null;
        }
        return serObj;
    }
	
	public Object readObjectFromFile(String filename) {
		Object serObj=null;
        try {
        	
            FileInputStream fileIn = new FileInputStream(filepath + File.separator + filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            serObj = objectIn.readObject();
            objectIn.close();
  
        } catch (Exception ex) {
            //ex.printStackTrace();
            return null;
        }
        return serObj;
    }
}
