package com.awstraining.backend.business.notifyme.adapter;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.awstraining.backend.business.notifyme.MessageSender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageSnsAWSSender implements MessageSender {

  private static final Logger LOGGER = LogManager.getLogger(MessageSnsAWSSender.class);

  private AmazonSNS amazonSNS;
  private String topicArn;

  @Autowired
  public MessageSnsAWSSender(@Value("notification.topicarn") String topicArn, AmazonSNS amazonSNS) {
    this.topicArn = topicArn;
    this.amazonSNS = amazonSNS;
  }

  @Override
  public void send(String text) {
    LOGGER.info(String.format("TopicARN: %s", this.topicArn));
    PublishRequest publishRequest = new PublishRequest(topicArn, text);
    PublishResult publishResult = amazonSNS.publish(publishRequest);
    String messageId = publishResult.getMessageId();
    LOGGER.info("Message sent to topic {} with message id {}", topicArn, messageId);
  }
}
