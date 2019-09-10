package com.experiencepolice.controller;


import com.experiencepolice.domain.SearchExperienceRequest;
import com.experiencepolice.domain.SearchExperienceResponse;
import com.experiencepolice.service.SearchExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchExperienceController {

  @Autowired
  private SearchExperienceService searchService;

  @RequestMapping(method = RequestMethod.POST, value = "/search")
  public SearchExperienceResponse searchProfile(@RequestBody SearchExperienceRequest request) {

    return searchService.getProfileswithName(request);

  }


}
