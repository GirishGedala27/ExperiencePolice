package com.experiencepolice.service;

import com.experiencepolice.domain.SearchExperienceRequest;
import com.experiencepolice.service.configuration.ElasticSearchConfiguration;
import java.io.IOException;
import java.util.Optional;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ElasticSearchService {

  private final String FIRSTNAME = "firstName";
  private final String LASTNAME = "lastName";


  @Autowired
  private ElasticSearchConfiguration elasticSearchConfiguration;

  public long searchProfiles(SearchExperienceRequest request) {

    long totalhits = 0;
    Optional<String> fname = Optional.ofNullable(request.getFirstName());
    Optional<String> lname = Optional.ofNullable(request.getLastName());
    RestHighLevelClient client = elasticSearchConfiguration.getRestClient();

    SearchRequest nameSearchRequest = new SearchRequest();
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

    searchSourceBuilder.query(getFirstLastNameMatchQuery(fname.get(), lname.get()));
    nameSearchRequest.source(searchSourceBuilder);
    try {
      SearchResponse response = client.search(nameSearchRequest);
      totalhits = response.getHits().totalHits;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return totalhits;
  }

  private QueryBuilder getFirstLastNameMatchQuery(String fname, String lname) {
    QueryBuilder firstLastNameMatchQuery = QueryBuilders.boolQuery()
        .must(QueryBuilders.matchQuery(FIRSTNAME, fname))
        .must(QueryBuilders.matchQuery(LASTNAME, lname));

    return firstLastNameMatchQuery;


  }


}
