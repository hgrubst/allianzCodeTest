package au.com.allianz.codetest.service;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import au.com.allianz.codetest.model.Issue;

@Service
public class IssueService {

  private HashMap<Integer, Issue> store = new HashMap<Integer, Issue>(); 
  
  
  public void addIssue(Issue issue){
    store.put(issue.getId(), issue);
  }
  
  public Issue getIssue(Integer id){
    return store.get(id);
  }
  
  public Collection<Issue> getIssues(){
    return store.values();
  }
  
  public Issue deleteIssue(Integer id){
    return store.remove(id);
  }
}
