/**********************************************************      
 
 * 项目名称：vote   
 * 类名称：ThumbnailAction   
 * 类描述： Thumbnail上传图片等比缩略
 * 创建人：袁伟倩
 * 创建时间：2016年6月3日 下午3:59:20   
 * 修改备注：     http://192.168.14.133:8081/vote/image/image.do
 **********************************************************/
package com.thumbnail;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="image")
public class ThumbnailAction {
  private UploadService  upliadService;
  
  private ThumbnailService thumbnailService;
  @RequestMapping(value="thumbnail",method=RequestMethod.POST)
  public ModelAndView thumbnail(@RequestParam("image")CommonsMultipartFile file,HttpSession session)throws Exception{
	  String uploadPath="/images";
	  String realUploadPath=session.getServletContext().getRealPath(uploadPath);
	 
	  String imageUrl=upliadService.uploadImage(file, uploadPath, realUploadPath);
	  String thumImageUrl=thumbnailService.thumbnail(file, uploadPath, realUploadPath);
	 
	  ModelAndView ret = new ModelAndView();
	  ret.addObject("imageURL",imageUrl);
	  ret.addObject("thumbImageURL",thumImageUrl);
	  ret.setViewName("image/thumbnail"); 
	  	
	  return ret;
	  
  }
  
  @RequestMapping(value="image")  
  public ModelAndView logins(){  
  	
  	ModelAndView mav = new ModelAndView();
  	mav.setViewName("image/image");
//  	mav.addObject("molly","molly你好吗");
      return mav;
  }

  @Autowired
public void setUpliadService(UploadService upliadService) {
	this.upliadService = upliadService;
}

  @Autowired
public void setThumbnailService(ThumbnailService thumbnailService) {
	this.thumbnailService = thumbnailService;
}   
  
}

  