/*
 * Copyright (c) 2002-2003 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package au.com.allianz.codetest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import au.com.allianz.codetest.model.Issue;

@Controller
@RequestMapping("/rest")
public class IssueController {
  private static final Logger logger = LoggerFactory.getLogger(IssueController.class);
  
  
  private Map<Integer, Issue> issueDatastore = new HashMap<Integer, Issue>();
   
  @RequestMapping(value = "/issue/dummy", method = RequestMethod.GET)
  public @ResponseBody Issue getDummyIssue() {
      logger.info("Start getDummyIssue");
      Issue issue = new Issue();
      issue.setId(9999);
      issue.setName("DummyIssue");
      issue.setCreatedDate(new Date());
      issueDatastore.put(9999, issue);
      return issue;
  }
   
  @RequestMapping(value = "/issue/{id}", method = RequestMethod.GET)
  public @ResponseBody Issue getIsssue(@PathVariable("id") int id) {
      logger.info("Start getIsssue. ID=" + id);       
      return issueDatastore.get(id);
  }
   
  @RequestMapping(value = "/issues", method = RequestMethod.GET)
  public @ResponseBody List<Issue> getAllIssue() {
      logger.info("Start getAllIssue.");
      List<Issue> issues = new ArrayList<Issue>();
      Set<Integer> keys = issueDatastore.keySet();
      for(Integer i : keys){
        issues.add(issueDatastore.get(i));
      }
      return issues;
  }
   
  @RequestMapping(value = "/issue/create", method = RequestMethod.POST)
  public @ResponseBody Issue createIssue(@RequestBody Issue issue) {
      logger.info("Start createIssue.");
      issue.setCreatedDate(new Date());
      issueDatastore.put(issue.getId(), issue);
      return issue;
  }
   
  @RequestMapping(value = "/issue/delete/{id}", method = RequestMethod.PUT)
  public @ResponseBody Issue deleteIssue(@PathVariable("id") int id) {
      logger.info("Start deleteIssue.");
      Issue issue = issueDatastore.get(id);
      issueDatastore.remove(id);
      return issue;
  }
}
