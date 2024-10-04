package com.younho.message;

import javax.inject.Inject;

public class TibrvSender extends MessageSender {
    @Inject
    public TibrvSender() {
        LOGGER.debug("Initializing TibrvWrapper");
    }

    @Override
    public void send(Message message) {
        LOGGER.debug("Send tibrv Message");
    }
}
