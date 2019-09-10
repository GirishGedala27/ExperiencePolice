package com.experiencepolice.domain;

import java.util.List;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Profile {

  private String firstName;
  private String lastName;
  private int totalExprienceInYears;
  private List<Job> jobHistory;
  private int popularity;

}
