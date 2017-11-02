package sop.search.utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import sop.report.context.ServletContextListennerImpl;
import sop.search.entities.Version;



public class FileUtility
{
    

    public static void upload(List<FileItem> fieldList, Version version){
        
        for(FileItem item : fieldList) {
            String pathName = "G:\\Service Oriented Programming\\Project\\seach-report\\WebContent\\";
            if(!item.isFormField()) {
                try {
                    String suffix = item.getName().trim();
                    while(suffix.length() > 5) {
                        suffix = suffix.substring(suffix.indexOf("."));
                    }
                    if(".png".equalsIgnoreCase(suffix) || ".jpeg".equalsIgnoreCase(suffix) || ".jpg".equalsIgnoreCase(suffix)) {
                        pathName+= "pictures\\"+ version.getPictureCoverFileCode();
                    }else {
                        pathName+= "documents\\" + version.getDocumentFileCode();
                    }
                    item.write(new File(pathName));
                    System.out.println("UPLOAD FILE AT: " + pathName);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }
    
    public static String getFileExtension(List<FileItem> fieldList) {
        for(FileItem item : fieldList) {
            if(!item.isFormField()) {
                try {
                    String suffix = item.getName().trim();
                    while(suffix.length() > 5) {
                        suffix = suffix.substring(suffix.indexOf("."));
                    }
                    
                    if("doc".equals(suffix) || ".docx".equals(suffix) || ".pdf".equals(suffix)) {
                        return suffix;
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
    
    public static void download(HttpServletResponse response, String fileName) throws IOException{
        String pathName = ServletContextListennerImpl
                .context.getRealPath("/") + "\\documents\\" + fileName;
        PrintWriter out = response.getWriter();
        try {
            FileInputStream fis = new FileInputStream(pathName);
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-DisPosition"
                    , "attachment;filename="+ fileName);
            int i;
            while((i = fis.read()) != -1) {
                out.write(i);
            }
            fis.close();
            out.close();
            System.out.println("DOWMLOAD FILE AT: " + pathName);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
