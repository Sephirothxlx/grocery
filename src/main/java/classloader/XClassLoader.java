package classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XClassLoader extends ClassLoader {
	 private String myPath;

	    public XClassLoader(String path) {
	        // TODO Auto-generated constructor stub
	        myPath = path;
	    }

	    @Override
	    protected Class<?> findClass(String name) throws ClassNotFoundException {
	        // TODO Auto-generated method stub

	        try {
	            FileInputStream is = new FileInputStream(myPath+getFileName(name));

	            ByteArrayOutputStream bos = new ByteArrayOutputStream();
	            int len = 0;
	            try {
	                while ((len = is.read()) != -1) {
	                    bos.write(len);
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	            byte[] data = bos.toByteArray();
	            is.close();
	            bos.close();

	            return defineClass(name,data,0,data.length);

	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return super.findClass(name);
	    }

	    //获取要加载 的class文件名
	    private String getFileName(String name) {
	        // TODO Auto-generated method stub
	        int index = name.lastIndexOf('.');
	        if(index == -1){ 
	            return name+".class";
	        }else{
	            return name.substring(index+1)+".class";
	        }
	    }
}
