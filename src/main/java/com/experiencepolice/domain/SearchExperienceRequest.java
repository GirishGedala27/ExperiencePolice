package com.experiencepolice.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchExperienceRequest {

  private String firstName;
  private String lastName;

  @JsonCreator
  public SearchExperienceRequest(@JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
