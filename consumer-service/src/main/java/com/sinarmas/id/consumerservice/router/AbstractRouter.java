package com.sinarmas.id.consumerservice.router;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractRouter extends RouteBuilder {

    @Value("${spring.sftp.host}")
    protected String sftpHost;

    @Value("${spring.sftp.port}")
    protected String sftpPort;

    @Value("${spring.sftp.user}")
    protected String sftpUser;

    @Value("${spring.sftp.password}")
    protected String sftpPassword;

    @Value("${spring.sftp.delayprocess}")
    protected Long delayProcess;
}
