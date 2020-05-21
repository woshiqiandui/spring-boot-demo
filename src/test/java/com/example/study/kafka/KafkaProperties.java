package com.example.study.kafka;

/**
 * Kafka常用配置文件
 */
public class KafkaProperties {
   //此处要和kafka配置文件中的 advertised.host.name保持一致，要么都是IP,要么都是HostName
    public static final String ZK = "47.98.135.123:2181";

    public static final String TOPIC = "dpg";

    public static final String BROKER_LIST = "47.98.135.123:9092";

    public static final String GROUP_ID = "test_group1";

}
