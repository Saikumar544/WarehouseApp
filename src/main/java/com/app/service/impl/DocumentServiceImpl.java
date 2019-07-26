package com.app.service.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
import com.app.service.IDocumentService;
@Service
public class DocumentServiceImpl implements IDocumentService{
	@Autowired
private IDocumentDao dao;
	@Override
	@Transactional
	public Integer saveDocument(Document doc) {
		// TODO Auto-generated method stub
		return dao.saveDocument(doc);
	}
	@Transactional(readOnly=true)
	public List<Object[]> getFileAndNames() {
		// TODO Auto-generated method stub
		return dao.getFileAndNames();
	}
	@Override
	@Transactional(readOnly=true)
	public Document getOneDoc(Integer fId) {
		// TODO Auto-generated method stub
		return dao.getOneDoc(fId);
	}

}
