package com.ku.business.service;

import com.ku.business.entity.CompanyStatus;
import com.ku.business.repository.CompanyStatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyStatusService {
    private CompanyStatusDao companyStatusDao;

    public Long findIdByName(CompanyStatus companyStatus) {
        return companyStatusDao.findIdByName(companyStatus);
    }

    @Autowired
    public void setCompanyStatusDao(CompanyStatusDao companyStatusDao) {
        this.companyStatusDao = companyStatusDao;
    }
}
