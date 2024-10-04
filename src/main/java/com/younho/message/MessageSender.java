package com.younho.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class MessageSender {
    protected static final Logger LOGGER = LogManager.getLogger(MessageSender.class);

    public abstract void send(Message message);
}
