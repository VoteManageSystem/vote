/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：ThumbnailService   
 * 类描述：   
 * 创建人：袁伟倩
 * 创建时间：2016年6月3日 下午4:57:52   
 * 修改备注：     
 **********************************************************/
package com.thumbnail;
import net.coobird.thumbnailator.Thumbnails;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service
public class ThumbnailService {
   
	public static final int WIDTH=100;
	public static final int HEIGHT=100;
    
	public String thumbnail(CommonsMultipartFile file,String uploadPath,String realUploadPath){
		try {
			String des=realUploadPath+"/thum_"+file.getOriginalFilename();
			/*
			 * /*   
			 * 若图片横比200小，高比300小，不变   
			 * 若图片横比200小，高比300大，高缩小到300，图片比例不变   
			 * 若图片横比200大，高比300小，横缩小到200，图片比例不变   
			 * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300   
			 
			 */
			Thumbnails.of(realUploadPath+"/"+file.getOriginalFilename()).size(WIDTH,HEIGHT).toFile(des);
		
			//按照比例进行缩放
			//scale(比例)  
			//Thumbnails.of("images/a380_1280x1024.jpg").scale(0.25f).toFile("c:/a380_25%.jpg");  
		
			
			//不按照比例，指定大小进行缩放//keepAspectRatio(false) 默认是按照比例缩放的  
			//Thumbnails.of("images/a380_1280x1024.jpg").size(200, 200).keepAspectRatio(false).toFile("c:/a380_200x200.jpg"); 
		
		    //旋转
			//rotate(角度),正数：顺时针 负数：逆时针  
			//Thumbnails.of("images/a380_1280x1024.jpg").size(1280, 1024).rotate(90).toFile("c:/a380_rotate+90.jpg");   
			//Thumbnails.of("images/a380_1280x1024.jpg").size(1280, 1024).rotate(-90).toFile("c:/a380_rotate-90.jpg"); 
		
		    //水印
			//watermark(位置，水印图，透明度)  
			//Thumbnails.of("images/a380_1280x1024.jpg").size(1280, 1024).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File("images/watermark.png")), 0.5f).outputQuality(0.8f).toFile("c:/a380_watermark_bottom_right.jpg");  
			//Thumbnails.of("images/a380_1280x1024.jpg").size(1280, 1024).watermark(Positions.CENTER, ImageIO.read(new File("images/watermark.png")), 0.5f)   .outputQuality(0.8f).toFile("c:/a380_watermark_center.jpg"); 
		   
			//转换图片格式
			//outputFormat(图像格式)  
			//Thumbnails.of("images/a380_1280x1024.jpg").size(1280, 1024).outputFormat("png").toFile("c:/a380_1280x1024.png");   
			//Thumbnails.of("images/a380_1280x1024.jpg").size(1280, 1024).outputFormat("gif").toFile("c:/a380_1280x1024.gif");
		  
			//输出到OutputStream
		    //toOutputStream(流对象)  
		    //OutputStream os = new FileOutputStream("c:/a380_1280x1024_OutputStream.png");  
		    //Thumbnails.of("images/a380_1280x1024.jpg").size(1280, 1024).toOutputStream(os);  
	
			//输出到BufferedImage
		    //asBufferedImage() 返回BufferedImage  
		    //BufferedImage thumbnail = Thumbnails.of("images/a380_1280x1024.jpg").size(1280, 1024).asBufferedImage();  
		    //ImageIO.write(thumbnail, "jpg", new File("c:/a380_1280x1024_BufferedImage.jpg"));   
		} catch (Exception e) {
          e.printStackTrace();
		}
		
		return uploadPath+"/thum_"+file.getOriginalFilename();
	}
}

  