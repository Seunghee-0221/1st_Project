package com.tj.hwing.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.tj.hwing.dao.ProductDao;

public class ProductModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fBoardUp");
		int maxSize = 1024*1024*20;
		MultipartRequest mRequest = null;
		String pImg = "";
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			pImg = mRequest.getFilesystemName(param);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		File file = new File(path+"/"+pImg);
		if(file.exists()) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(file);
				os = new FileOutputStream("D:/mega_IT/source/myProject/hwing/WebContent/productImg/"+pImg);
				byte[] bs = new byte[(int)file.length()];
				while(true) {
					int nByte = is.read(bs);
					if(nByte == -1) {
						break;
					}
					os.write(bs, 0, nByte);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if(os!=null) {
						os.close();
					}
					if(is!=null) {
						is.close();
					}
				} catch(Exception e) {
					
				}
			}
		} else {
			pImg = mRequest.getParameter("originalFilename");
		}
		String pCode = mRequest.getParameter("pCode");
		String pName = mRequest.getParameter("pName");
		String pContent = mRequest.getParameter("pContent");
		int pPrice = Integer.parseInt(mRequest.getParameter("pPrice"));
		int pNo = Integer.parseInt(mRequest.getParameter("pNo"));
		ProductDao pDao = new ProductDao();
		int result = pDao.modifyProduct(pCode, pName, pContent, pPrice, pImg, pNo);
		if(result == ProductDao.SUCCESS) {
			request.setAttribute("msg", "수정 성공");
		} else {
			request.setAttribute("msg", "수정 실패");
		}
	}
}
