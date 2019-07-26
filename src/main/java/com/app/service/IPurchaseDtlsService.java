package com.app.service;

import java.util.List;

import com.app.model.Item;
import com.app.model.PurchaseDtls;

public interface IPurchaseDtlsService {
	Integer savePurchaseDtls(PurchaseDtls pdls);
	void updatePurchaseDtls(PurchaseDtls pdls);
	void deletePurchaseDtls(Integer id);
	List<PurchaseDtls> getAllPurchaseDtls();

}
