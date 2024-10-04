package com.younho.message;

import javax.inject.Inject;

public class KafkaSender extends MessageSender {
    @Inject
    public KafkaSender() {
        LOGGER.debug("Initializing KafkaWrapper");
    }

    @Override
    public void send(Message message) {
        LOGGER.debug("Send kafka Message");
    }
}
