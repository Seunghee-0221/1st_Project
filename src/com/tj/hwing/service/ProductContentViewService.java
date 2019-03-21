package com.tj.hwing.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.hwing.dao.ProductDao;
import com.tj.hwing.dto.ProductDto;

public class ProductContentViewService implements Service {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int pNo = Integer.parseInt(request.getParameter("pNo"));
		ProductDao pDao = new ProductDao();
		ProductDto dto = pDao.getOneProduct(pNo);
		request.setAttribute("product", dto);
	}
}
