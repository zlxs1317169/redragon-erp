/*
 * Copyright 2020-2021 redragon.dongbin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.erp.masterdata.customer.dao.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import com.framework.annotation.Cache;
import com.framework.annotation.Permissions;
import com.framework.annotation.Permissions.PermissionType;
import com.framework.annotation.SqlParam;
import com.framework.dao.DaoSupport;
import com.framework.dao.model.Pages;
import com.framework.util.DaoUtil;
import com.erp.masterdata.customer.dao.MdCustomerContactDao;
import com.erp.masterdata.customer.dao.model.MdCustomer;
import com.erp.masterdata.customer.dao.model.MdCustomerBank;
import com.erp.masterdata.customer.dao.model.MdCustomerContact;
import com.erp.masterdata.customer.dao.model.MdCustomerContactCO;

@Repository
public class MdCustomerContactDaoImpl implements MdCustomerContactDao{ 

    //注入DaoSupport工具类
    @Autowired
    private DaoSupport daoSupport;
    
    @Override
    public void insertDataObject(MdCustomerContact obj) {
        this.daoSupport.insertDataTransaction(obj);
    }

    @Override
    public void updateDataObject(MdCustomerContact obj) {
        this.daoSupport.updateDataTransaction(obj);
    }
    
    @Override
    public void insertOrUpdateDataObject(MdCustomerContact obj) {
        this.daoSupport.insertOrUpdateDataTransaction(obj);
    }

    @Override
    public void deleteDataObject(MdCustomerContact obj) {
        this.daoSupport.deleteDataTransactionJPA(obj);
    }

    @Override
    public List<MdCustomerContact> getDataObjects() {
        return this.daoSupport.getDataAllObject(MdCustomerContact.class);
    }

    @Override
    public MdCustomerContact getDataObject(int id) {
        return (MdCustomerContact)this.daoSupport.getDataObject(MdCustomerContact.class, id);
    }
    
    @Override
    public MdCustomerContact getDataObject(String code) {
        return null;
    }
    
    @Override
    public List<MdCustomerContact> getDataObjects(MdCustomerContactCO paramObj) {
        String sql = "select c.* from md_customer_contact c where customer_code=:code";
        
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("code", paramObj.getCustomerCode());
        
        sql = sql + " order by c.contact_id desc";
        
        Map<String, Class<?>> entity = new HashMap<String, Class<?>>();
        entity.put("c", MdCustomerContact.class);
        
        return this.daoSupport.selectDataSql(sql, entity, args);
    }
    
    @Override
    public List<MdCustomerContact> getDataObjects(Pages pages) {
        return null;
    }
    
    @Override
    public List<MdCustomerContact> getDataObjects(Pages pages, MdCustomerContactCO paramObj) {
        return null;
    }

    @Override
    public List<Map<String, Object>> getDataObjectsArray(Pages pages, MdCustomerContactCO paramObj) {
        return null;
    }
    
    @Override
    @Permissions(PermissionType.OWN)
    public List<MdCustomerContact> getDataObjectsForDataAuth(@SqlParam String dataAuthSQL, Pages pages, MdCustomerContactCO paramObj) {
        return null;
    }
    
    @Override
    public int getContactCountByCustomerCode(String customerCode) {
        String sql = "select count(1) from md_customer_contact c where c.customer_code = :customerCode";
        
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("customerCode", customerCode);
        
        List list = this.daoSupport.selectDataSqlCount(sql, args);
        if(list.size()>0) {
            return Integer.parseInt(String.valueOf(list.get(0)));
        }
        
        return 0;
    }
    
    @Override
    public List<MdCustomerContact> getContactListByCustomerCode(Pages pages, MdCustomerContactCO paramObj) {
        String sql = "select c.* from md_customer_contact c where customer_code=:code";
        
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("code", paramObj.getCustomerCode());
        
        sql = sql + " order by c.contact_id desc";
        
        Map<String, Class<?>> entity = new HashMap<String, Class<?>>();
        entity.put("c", MdCustomerContact.class);
        
        return this.daoSupport.getDataSqlByPage(sql, entity, args, pages);
    }
    
}
