/*
 * Copyright 2020-2021 redragon.dongbin
 *
 * This file is part of redragon-erp/赤龙ERP.

 * redragon-erp/赤龙ERP is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.

 * redragon-erp/赤龙ERP is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with redragon-erp/赤龙ERP.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.erp.finance.receipt.service.spring;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.framework.annotation.Cache;
import com.framework.annotation.Cache.CacheType;
import com.framework.annotation.Log;
import com.framework.dao.model.Pages;
import com.erp.finance.receipt.dao.ArInvoiceLineDao;
import com.erp.finance.receipt.dao.model.ArInvoiceLine;
import com.erp.finance.receipt.dao.model.ArInvoiceLineCO;
import com.erp.finance.receipt.service.ArInvoiceLineService;

@Service
@Transactional(rollbackFor=Exception.class)
public class ArInvoiceLineServiceImpl implements ArInvoiceLineService {

    //注入Dao
    @Autowired
    private ArInvoiceLineDao receiptLineDao;
    
    @Override
    public void insertDataObject(ArInvoiceLine obj) {
        this.receiptLineDao.insertDataObject(obj);
    }

    @Override
    public void updateDataObject(ArInvoiceLine obj) {
        this.receiptLineDao.updateDataObject(obj);
    }
    
    @Override
    public void insertOrUpdateDataObject(ArInvoiceLine obj) {
        this.receiptLineDao.insertOrUpdateDataObject(obj);
    }

    @Override
    public void deleteDataObject(ArInvoiceLine obj) {
        this.receiptLineDao.deleteDataObject(obj);
    }

    @Override
    public List<ArInvoiceLine> getDataObjects() {
        return this.receiptLineDao.getDataObjects();
    }

    @Override
    public ArInvoiceLine getDataObject(int id) {
        return this.receiptLineDao.getDataObject(id);
    }

    @Override
    public ArInvoiceLine getDataObject(String code) {
        return this.receiptLineDao.getDataObject(code);
    }

    @Override
    public List<ArInvoiceLine> getDataObjects(ArInvoiceLineCO paramObj) {
        return this.receiptLineDao.getDataObjects(paramObj);
    }

    @Override
    public List<ArInvoiceLine> getDataObjects(Pages pages) {
        return this.receiptLineDao.getDataObjects(pages);
    }
    
    @Override
    public List<ArInvoiceLine> getDataObjects(Pages pages, ArInvoiceLineCO paramObj) {
        return this.receiptLineDao.getDataObjects(pages, paramObj);
    }
    
    @Override
    public List<Map<String, Object>> getDataObjectsArray(Pages pages, ArInvoiceLineCO paramObj) {
        return this.receiptLineDao.getDataObjectsArray(pages, paramObj);
    }
    
    @Override
    public List<ArInvoiceLine> getDataObjectsForDataAuth(String dataAuthSQL, Pages pages, ArInvoiceLineCO paramObj) {
        return this.receiptLineDao.getDataObjectsForDataAuth(dataAuthSQL, pages, paramObj);
    }
    
    @Override
    public void deleteLineByHeadCode(String headCode) {
        this.receiptLineDao.deleteLineByHeadCode(headCode);
    }
    
    @Override
    public BigDecimal getHISArInvoiceAmountForSO(String soHeadCode, String headCode) {
        return this.receiptLineDao.getHISArInvoiceAmountForSO(soHeadCode, headCode);
    }
    
    @Override
    public List<ArInvoiceLine> getArInvoiceLineListByHeadCode(Pages pages, ArInvoiceLineCO paramObj) {
        return this.receiptLineDao.getArInvoiceLineListByHeadCode(pages, paramObj);
    }
    
    @Override
    public BigDecimal getArInvoiceAmountByHeadCode(String headCode) {
        return this.receiptLineDao.getArInvoiceAmountByHeadCode(headCode);
    }
    
}