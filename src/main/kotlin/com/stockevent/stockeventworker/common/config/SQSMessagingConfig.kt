package com.stockevent.stockeventworker.common.config

import com.amazonaws.auth.EnvironmentVariableCredentialsProvider
import com.amazonaws.regions.Regions
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SQSMessagingConfig {

    @Bean
    fun amazonSQS(): AmazonSQSAsync {
        val environmentVariableCredentialsProvider = EnvironmentVariableCredentialsProvider();

        return AmazonSQSClientBuilder
            .standard()
            .withRegion(Regions.AP_NORTHEAST_2)
            .withCredentials(environmentVariableCredentialsProvider)
            .build() as AmazonSQSAsync;
    }
}