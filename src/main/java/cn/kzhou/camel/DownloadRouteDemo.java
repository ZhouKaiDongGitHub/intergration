package cn.kzhou.camel;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

public class DownloadRouteDemo extends RouteBuilder {
    private static Logger logger = LoggerFactory.getLogger(DownloadRouteDemo.class);

    @Value("${ftp.server.info}")
    private String sftpServer;
    @Value("${ftp.local.dir}")
    private String downloadLocation;
    @Override
    public void configure() throws Exception {
        from( sftpServer ).to(  downloadLocation ).log(LoggingLevel.INFO, logger, "Downloaded file ${file:name} complete.");
    }
}
