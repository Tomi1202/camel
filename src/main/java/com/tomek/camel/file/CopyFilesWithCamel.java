package com.tomek.camel.file;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CopyFilesWithCamel {

    public static void main(String[] args) {

        CamelContext camelContext = new DefaultCamelContext();

        try {
            camelContext.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("file:data/input?noop=true")
                            .to("log:?level=INFO&showBody=true&showHeaders=true")
                            .to("file:data/output");
                }
            });

            camelContext.start();
            Thread.sleep(5000);
            camelContext.stop();

        } catch (Exception e) {
            System.out.println("Exception is : " + e);
            e.printStackTrace();
        }
    }
}