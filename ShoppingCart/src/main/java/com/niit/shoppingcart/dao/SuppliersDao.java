package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Suppliers;


public interface SuppliersDao {
public Boolean addSuppliers(Suppliers suppliers);
public Suppliers getSupplierById(int supplierId);
public List<Suppliers> getAllSuppliers();

public Boolean updateSuppliers(Suppliers suppliers);
public Boolean deleteSuppliers(int supplierId);
}
