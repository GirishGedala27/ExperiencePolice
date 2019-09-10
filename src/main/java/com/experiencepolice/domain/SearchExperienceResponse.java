package com.experiencepolice.domain;


import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SearchExperienceResponse {

  private List<Profile> profiles;
  private long totalhits;

}
