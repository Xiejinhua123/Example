package com.xiejinhua.example.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.xiejinhua.example.entity.LotteryData;

@Component
public interface DoubleDataZDao extends ElasticsearchRepository<LotteryData, String> {
}