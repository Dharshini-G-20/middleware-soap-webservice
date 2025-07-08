package com.abc.cmpinfo.endpoint;

import com.abc.cmpinfo.generated.Company;
import com.abc.cmpinfo.generated.GetCompanyDetailRequest;
import com.abc.cmpinfo.generated.GetCompanyDetailResponse;
import com.abc.cmpinfo.model.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * SOAP Endpoint for Company Information Service
 * Handles GetCompanyDetail requests
 */
@Endpoint
public class CompanyEndpoint {

    private static final String NAMESPACE_URI = "http://www.abc.org/cmpinfo";

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Handle GetCompanyDetail SOAP request
     * @param request - contains company ID
     * @return GetCompanyDetailResponse with company details
     */
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCompanyDetailRequest")
    @ResponsePayload
    public GetCompanyDetailResponse getCompanyDetail(@RequestPayload GetCompanyDetailRequest request) {
        
        System.out.println("Received request for company ID: " + request.getCompanyId());
        
        GetCompanyDetailResponse response = new GetCompanyDetailResponse();
        
        // Get company from repository
        Company company = companyRepository.findCompanyById(request.getCompanyId());
        
        if (company != null) {
            response.setCompany(company);
            System.out.println("Found company: " + company.getCompanyName());
        } else {
            // Create error response for company not found
            Company errorCompany = new Company();
            errorCompany.setCompanyId(request.getCompanyId());
            errorCompany.setCompanyName("Company Not Found");
            errorCompany.setIndustry("N/A");
            errorCompany.setLocation("N/A");
            errorCompany.setEmployeeCount(0);
            errorCompany.setWebsite("N/A");
            errorCompany.setDescription("The requested company ID does not exist in our database");
            errorCompany.setJobOpenings(0);
            errorCompany.setEstablished(0);
            errorCompany.setContactEmail("N/A");
            
            response.setCompany(errorCompany);
            System.out.println("Company not found for ID: " + request.getCompanyId());
        }
        
        return response;
    }
}

