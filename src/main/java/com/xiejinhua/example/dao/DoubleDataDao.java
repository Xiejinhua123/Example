package com.xiejinhua.example.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.xiejinhua.example.entity.DoubleData;

@Component
public interface DoubleDataDao extends ElasticsearchRepository<DoubleData, String> {
}