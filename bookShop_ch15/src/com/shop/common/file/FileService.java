package com.shop.common.file;

import java.util.ArrayList;
import java.util.HashMap;

import com.shop.goods.ImageFileVO;

public class FileService {
	FileDao dao=new FileDao();
	public void addFile(HashMap fileMap) throws Exception {
		dao.addFile(fileMap);
	}
}
