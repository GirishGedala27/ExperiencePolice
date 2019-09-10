package com.experiencepolice.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@AllArgsConstructor
@Data
@Builder
public class Job {

  private String company;
  private int serviceInYears;
  private String role;
  private List<String> skills;
  private double pay;

}
