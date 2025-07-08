package com.abc.cmpinfo.model;

import com.abc.cmpinfo.generated.Company;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Company Repository - Mock Data Store
 * In production, this would connect to a real database
 */
@Repository
public class CompanyRepository {

    private static final Map<String, Company> companies = new HashMap<>();

    static {
        // Initialize with sample company data
        initializeSampleData();
    }

    /**
     * Initialize sample company data
     */
    private static void initializeSampleData() {
        // Company 1 - Tech Solutions Inc.
        Company company1 = new Company();
        company1.setCompanyId("12345");
        company1.setCompanyName("Tech Solutions Inc.");
        company1.setIndustry("Information Technology");
        company1.setLocation("Bangalore, India");
        company1.setEmployeeCount(1500);
        company1.setWebsite("https://techsolutions.com");
        company1.setDescription("Leading IT solutions provider specializing in enterprise software development");
        company1.setJobOpenings(25);
        company1.setEstablished(2010);
        company1.setContactEmail("careers@techsolutions.com");
        companies.put("12345", company1);

        // Company 2 - Global Finance Corp
        Company company2 = new Company();
        company2.setCompanyId("67890");
        company2.setCompanyName("Global Finance Corp");
        company2.setIndustry("Financial Services");
        company2.setLocation("Mumbai, India");
        company2.setEmployeeCount(2000);
        company2.setWebsite("https://globalfinance.com");
        company2.setDescription("International financial services providing banking and investment solutions");
        company2.setJobOpenings(15);
        company2.setEstablished(1995);
        company2.setContactEmail("jobs@globalfinance.com");
        companies.put("67890", company2);

        // Company 3 - Innovation Labs
        Company company3 = new Company();
        company3.setCompanyId("11111");
        company3.setCompanyName("Innovation Labs");
        company3.setIndustry("Research & Development");
        company3.setLocation("Hyderabad, India");
        company3.setEmployeeCount(800);
        company3.setWebsite("https://innovationlabs.com");
        company3.setDescription("Cutting-edge R&D company focused on AI and machine learning solutions");
        company3.setJobOpenings(35);
        company3.setEstablished(2018);
        company3.setContactEmail("talent@innovationlabs.com");
        companies.put("11111", company3);

        // Company 4 - Manufacturing Pro
        Company company4 = new Company();
        company4.setCompanyId("22222");
        company4.setCompanyName("Manufacturing Pro");
        company4.setIndustry("Manufacturing");
        company4.setLocation("Chennai, India");
        company4.setEmployeeCount(3000);
        company4.setWebsite("https://manufacturingpro.com");
        company4.setDescription("Leading manufacturing company specializing in automotive components");
        company4.setJobOpenings(50);
        company4.setEstablished(1985);
        company4.setContactEmail("recruitment@manufacturingpro.com");
        companies.put("22222", company4);

        // Company 5 - HealthCare Plus
        Company company5 = new Company();
        company5.setCompanyId("33333");
        company5.setCompanyName("HealthCare Plus");
        company5.setIndustry("Healthcare");
        company5.setLocation("Delhi, India");
        company5.setEmployeeCount(1200);
        company5.setWebsite("https://healthcareplus.com");
        company5.setDescription("Comprehensive healthcare services and medical technology solutions");
        company5.setJobOpenings(40);
        company5.setEstablished(2005);
        company5.setContactEmail("careers@healthcareplus.com");
        companies.put("33333", company5);
    }

    /**
     * Find company by ID
     */
    public Company findCompanyById(String companyId) {
        return companies.get(companyId);
    }

    /**
     * Check if company exists
     */
    public boolean companyExists(String companyId) {
        return companies.containsKey(companyId);
    }

    /**
     * Get all company IDs
     */
    public java.util.Set<String> getAllCompanyIds() {
        return companies.keySet();
    }
}

