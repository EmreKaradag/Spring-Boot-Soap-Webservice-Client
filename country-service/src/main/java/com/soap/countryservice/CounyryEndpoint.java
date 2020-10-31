package com.soap.countryservice;

import io.spring.guides.soap_countryservice.GetCountryRequest;
import io.spring.guides.soap_countryservice.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CounyryEndpoint {

  private static final String NAMESPACE_URI = "http://spring.io/guides/soap-countryservice";

  private CountryRepository countryRepository;

  @Autowired
  public CounyryEndpoint(CountryRepository countryRepository){
    this.countryRepository=countryRepository;
  }


  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
  @ResponsePayload
  public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request){

    GetCountryResponse response = new GetCountryResponse();
    response.setCountry(countryRepository.findCountry(request.getName()));

    return response;
  }


}
