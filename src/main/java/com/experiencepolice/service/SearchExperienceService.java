package com.experiencepolice.service;

import com.experiencepolice.domain.Job;
import com.experiencepolice.domain.Profile;
import com.experiencepolice.domain.SearchExperienceRequest;
import com.experiencepolice.domain.SearchExperienceResponse;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchExperienceService {

  @Autowired
  private ElasticSearchService elasticSearchService;

  public SearchExperienceResponse getProfileswithName(SearchExperienceRequest searchName) {
    if (searchName.getFirstName().equals("Girish") && searchName.getLastName().equals("Nischel")) {
      return SearchExperienceResponse.builder().profiles(
          Arrays.asList(
              Profile.builder().firstName("Girish").lastName("Nischel").totalExprienceInYears(2)
                  .jobHistory(Arrays.asList(
                      Job.builder().skills(Arrays.asList("Java", "CPP", "ElasticSearch"))
                          .serviceInYears(2).role("Application developer").company("Equifax")
                          .pay(75000).build())).popularity(98).build()))
          .totalhits(elasticSearchService.searchProfiles(searchName))
          .build();
    }
    return SearchExperienceResponse.builder().totalhits(0).build();
  }

}
