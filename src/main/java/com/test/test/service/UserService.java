package com.test.test.service;

import com.test.test.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.ResultQuery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class UserService {

    private final DSLContext dslContext;

    @Value("${app.sql-query}")
    private String sqlQuery;
    @Value("#{'${app.select-fields}'.split(',')}")
    private List<String> selectFields;

    public Map<String, String> getUserByKey(Integer key) throws NotFoundException {
        Map<String, String> userData = new HashMap<>();

        ResultQuery<Record> records = dslContext.resultQuery(sqlQuery, key);
        Result<Record> fetchedResult = records.fetch();
        if (fetchedResult.isEmpty()) {
            throw new NotFoundException();
        }

        Record record = fetchedResult.get(0);
        selectFields.forEach(fieldName -> userData.put(fieldName, (String) record.get(fieldName)));

        return userData;
    }
}
