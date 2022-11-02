package com.cu.business.DAO;

import com.ku.business.DAO.CompanyRepository;
import com.ku.business.entity.Company;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CompanyRepositoryTest {
    CompanyRepository companyRepository = new CompanyRepository();
    @Test
    public void testGetListOfCompanies() {

        //given
        List<Company> companies = companyRepository.findAll();
        for (Company c: companies
             ) {
            System.out.println(c);
        }
        //when
        boolean isNotEmpty = (companies.isEmpty());

        //then
        Assertions.assertFalse(isNotEmpty);
    }

    @Test
    public void testReturnCompanyById() {
        //given
        Company company = companyRepository.findById(333L);

        //when
        boolean isIdEqual = (company.getId() == 333);

        //then
        Assertions.assertTrue(isIdEqual);

    }

    @Test
    public void testAddToTable() {

        //given
        companyRepository.add("ENEKA", "3390699", 342L, false);
        Company company = companyRepository.findById(1001L);
        companyRepository.delete(1001L);
        //when
        boolean isExist = (company.getId() != null);

        //then
        Assertions.assertTrue(isExist);

    }

    @Test
    public void testUpdateValueInTable() {

        //given
        long id = (long) (Math.random() * 1000 + 1);
        Company first = companyRepository.findById(id);
        companyRepository.update(new Company(id, "ENEKA", "333444999", false, 333L, null, null));
        Company second = companyRepository.findById(id);

        //when
        boolean isEqual = (first.equals(second));
        companyRepository.update(first);

        //then
        Assertions.assertFalse(isEqual);

    }

    @Test
    public void testDeleteFromTable() {
        //given
        companyRepository.add("ENEKA", "333444999", 342L, false);
        Company first = companyRepository.findById(1001L);
        boolean isExist = first.getId() != null;
        companyRepository.delete(1001L);
        Company second = companyRepository.findById(1001L);


        //when
        boolean isExistAfterDelete = second.getId() != null;

        //then
        Assertions.assertFalse(isExist == isExistAfterDelete);

    }

}

