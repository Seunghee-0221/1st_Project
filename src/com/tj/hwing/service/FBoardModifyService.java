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
import com.tj.hwing.dao.FBoardDao;

public class FBoardModifyService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("fBoardUp");
		int maxSize = 1024*1024*20;
		MultipartRequest mRequest = null;
		String fbFilename = "";
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			fbFilename = mRequest.getFilesystemName(param);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		File file = new File(path+"/"+fbFilename);
		if(file.exists()) {
			InputStream is = null;
			OutputStream os = null;
			try {
				is = new FileInputStream(file);
				os = new FileOutputStream("D:/mega_IT/source/myProject/hwing/WebContent/fBoardUp/"+fbFilename);
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
			fbFilename = mRequest.getParameter("originalFilename");
		}
		int fbNo = Integer.parseInt(mRequest.getParameter("fbNo"));
		String fbTitle = mRequest.getParameter("fbTitle");
		String fbContent = mRequest.getParameter("fbContent");
		FBoardDao fDao = new FBoardDao();
		int result = fDao.modifyFBoard(fbTitle, fbContent, fbFilename, fbNo);
		if(result == FBoardDao.SUCCESS) {
			request.setAttribute("msg", "수정 성공");
		} else {
			request.setAttribute("msg", "수정 실패");
		}
	}
}
