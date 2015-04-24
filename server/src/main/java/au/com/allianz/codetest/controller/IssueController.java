/*
 * Copyright (c) 2002-2003 Allianz Australia Ltd. (Allianz) All Rights Reserved.
 * This work is a trade secret of Allianz and unauthorized use or copying is prohibited.
 */
package au.com.allianz.codetest.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import au.com.allianz.codetest.model.Issue;
import au.com.allianz.codetest.service.IssueService;


@RestController
@RequestMapping("/issue")
public class IssueController {
  private static final Logger logger = LoggerFactory.getLogger(IssueController.class);
  
  @Autowired
  private IssueService issueService;
  
  @RequestMapping(value = "/dummy", method = RequestMethod.GET)
  public Issue getDummyIssue() {
      logger.info("Start getDummyIssue");
      Double id = Math.random() * 100;
      Issue issue = new Issue();
      issue.setId(id.intValue());
      issue.setDescription("DummyIssue");
      issue.setCreatedDate(new Date());
      
      issueService.addIssue(issue);
      
      return issue;
  }
   
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Collection<Issue> getIssues() {
      logger.info("get issues");
      return issueService.getIssues();
  }
   
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Issue getIsssue(@PathVariable("id") int id) {
    logger.info("Start getIsssue. ID=" + id);       
    return issueService.getIssue(id);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Issue createIssue(@RequestBody Issue issue) {
      logger.debug("Adding issue with title {} and description {}", issue.getTitle(), issue.getDescription());
      return issue;
  }
   
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public Issue deleteIssue(@PathVariable("id") int id) {
      logger.info("Start deleteIssue.");
      return issueService.deleteIssue(id);
  }
}
