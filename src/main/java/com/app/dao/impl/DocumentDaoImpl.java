package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IDocumentDao;
import com.app.model.Document;
@Repository
public class DocumentDaoImpl implements IDocumentDao {
	@Autowired
private HibernateTemplate ht;
	@Override
	public Integer saveDocument(Document doc) {
		
		return (Integer) ht.save(doc);
	}
	@Override
	public List<Object[]> getFileAndNames() {
		String hql="select fId,fName from com.app.model.Document";
		@SuppressWarnings("unchecked")
		List<Object[]> list=(List<Object[]>) ht.find(hql);
				return list;
	}
	@Override
	public Document getOneDoc(Integer fId) {
		// TODO Auto-generated method stub
		return ht.get(Document.class, fId);
	}
	

}
