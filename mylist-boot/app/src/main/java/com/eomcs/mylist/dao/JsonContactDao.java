package com.eomcs.mylist.dao;

import java.io.File;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.domain.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JsonContactDao extends AbstractContactDao {
  String filename = "contacts.json";

  public JsonContactDao() {
    try {
      ObjectMapper mapper = new ObjectMapper();
      contactList.addAll(mapper.readValue(new File(filename), Contact[].class));
    } catch (Exception e) {
      System.out.println("데이터 로딩중 오류 발생");
    }
  }

  @Override
  public void save() throws Exception{
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(new File(filename), contactList.toArray());
  }

  @Override
  public int countAll() {
    return contactList.size();
  }
}
