package com.app.dao;

import java.util.List;

import com.app.model.Item;
import com.app.model.PurchaseDtls;

public interface IPurchaseDtlsDao {
Integer savePurchaseDtls(PurchaseDtls pdls);
void updatePurchaseDtls(PurchaseDtls pdls);
void deletePurchaseDtls(Integer id);
List<PurchaseDtls> getAllPurchaseDtls();

}
